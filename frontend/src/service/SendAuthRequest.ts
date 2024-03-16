/* eslint-disable @typescript-eslint/no-explicit-any */
import axios from "axios";
import { Dispatch, SetStateAction } from "react";

interface createUserForm {
    username: string;
    password: string;
    mail: string;
}

interface LogInForm {
    username: string;
    password: string;

}

interface SendRequestProps {
    actionType: "signUp" | "signIn";
    createUserForm: createUserForm;
    setCreateUserForm: Dispatch<SetStateAction<createUserForm>>;
    setIsRegistered: Dispatch<SetStateAction<boolean>>;
    isRegistered: boolean;
    logInUserForm: LogInForm;
    setUserId: Dispatch<SetStateAction<string>>;
    setIsLoggedIn: Dispatch<SetStateAction<boolean>>;
    setJwt: Dispatch<SetStateAction<string>>;
    history: any;
}

export default function SendRequest({
  actionType,
  createUserForm,
  setCreateUserForm,
  setIsRegistered,
  isRegistered,
  logInUserForm,
  setUserId,
  setIsLoggedIn,
  setJwt,
  history,
}: SendRequestProps) {
  if (actionType === "signUp") {
    axios
      .post("http://localhost:8080/api/v1/user/signUp", createUserForm, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((res) => {
        console.log(res);
      })
      .then(() => {
        setCreateUserForm({
          username: "",
          password: "",
          mail: "",
        });
        setIsRegistered(!isRegistered);
      })
      .catch((e) => {
        console.warn(e);
      });
  } else if (actionType === "signIn") {
    axios
      .post("http://localhost:8080/api/v1/user/signIn", logInUserForm)
      .then((res) => {
        if (res.data.id !== "") {
          console.log(res.data);
          setIsLoggedIn(true);
          setUserId(res.data.id);
          setJwt(res.data.jwt);
          history.push("/appointments");
        }
      })
      .catch((e) => {
        console.warn(e);
        return false;
      });
  }
}
