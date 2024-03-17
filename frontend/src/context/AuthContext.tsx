import React, { createContext, useState } from "react";

// TYPES START
interface CreateUserForm {
  name: string;
  password: string;
  mail: string;
}

interface LogInUserForm {
  username: string;
  password: string;
}

interface AuthContextType {
  isRegistered: boolean;
  setIsRegistered: React.Dispatch<React.SetStateAction<boolean>>;
  setUserId: React.Dispatch<React.SetStateAction<string>>;
  setIsLoggedIn: React.Dispatch<React.SetStateAction<boolean>>;
  jwt: string;
  setJwt: React.Dispatch<React.SetStateAction<string>>;
  createUserForm: CreateUserForm;
  setCreateUserForm: React.Dispatch<React.SetStateAction<CreateUserForm>>;
  logInUserForm: LogInUserForm;
  setLogInUserForm: React.Dispatch<React.SetStateAction<LogInUserForm>>;
  passwordChecker: string;
  setPasswordChecker: React.Dispatch<React.SetStateAction<string>>;
}

interface AuthProviderProps {
  children: React.ReactNode;
}

// TYPES END

export const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const [isRegistered, setIsRegistered] = useState<boolean>(true);
  const [userId, setUserId] = useState<string>("");
  const [jwt, setJwt] = useState<string>("");
  const [isLoggedIn, setIsLoggedIn] = useState<boolean>(false);
  const [passwordChecker, setPasswordChecker] = useState<string>("");
  const [createUserForm, setCreateUserForm] = useState<CreateUserForm>({
    name: "",
    password: "",
    mail: "",
  });
  const [logInUserForm, setLogInUserForm] = useState<LogInUserForm>({
    username: "",
    password: "",
  });

  const authContextValue: AuthContextType = {
    isRegistered,
    setIsRegistered,
    setUserId,
    setIsLoggedIn,
    jwt,
    setJwt,
    createUserForm,
    setCreateUserForm,
    logInUserForm,
    setLogInUserForm,
    passwordChecker,
    setPasswordChecker,
  };

  return (
    <AuthContext.Provider value={authContextValue}>
      {children}
    </AuthContext.Provider>
  );
};

export const AuthContext = createContext<AuthContextType | undefined>(
  undefined
);
