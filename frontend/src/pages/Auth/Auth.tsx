import { AuthContext } from "../../context/AuthContext";
import { useContext } from "react";
import LogInForm from "./LogInForm/LogInForm";
import RegisterForm from "./RegisterForm/RegisterForm";

function Auth() {
  const authContext = useContext(AuthContext);
  const isRegistered = authContext ? authContext.isRegistered : true;

  return (
    <div className="w-screen h-screen flex flex-col justify-center items-center overflow-hidden">
      {isRegistered ? <LogInForm /> : <RegisterForm />}
      <h1 className="mb-5 mt-10 text-lg text-black">
      </h1>
    </div>
  );
}

export default Auth;
