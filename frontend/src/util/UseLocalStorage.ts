import { useState, useEffect } from "react";

function useLocalState(defaulValue:string, key: string) {
  const [value, setValue] = useState(() => {
    const localValue = localStorage.getItem(key);
    return localValue !== null ? JSON.parse(localValue) : defaulValue;
  });

  useEffect(() => {
    localStorage.setItem(key, JSON.stringify(value));
  }, [key, value]);

  return [value, setValue];
}

export { useLocalState };
