import React, { createContext, useState } from "react";

interface DataContextType {
  restaurants: object[];
  setRestaurants: React.Dispatch<React.SetStateAction<object[]>>;
  updateApp: boolean;
  setUpdateApp: React.Dispatch<React.SetStateAction<boolean>>;
}

interface DataProviderProps {
  children: React.ReactNode;
}

export const DataProvider: React.FC<DataProviderProps> = ({ children }) => {
  const [restaurants, setRestaurants] = useState<object[]>([]);
  const [updateApp, setUpdateApp] = useState<boolean>(false);

  const dataContextValue = {
    restaurants,
    setRestaurants,
    updateApp,
    setUpdateApp,
  };

  return (
    <DataContext.Provider value={dataContextValue}>
      {children}
    </DataContext.Provider>
  );
};

export const DataContext = createContext<DataContextType | undefined>(
  undefined
);
