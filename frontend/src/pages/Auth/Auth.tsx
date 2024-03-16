import { AuthContext } from "../../context/AuthContext";
import { useContext } from "react";
import LogInForm from "./LogInForm/LogInForm";
import RegisterForm from "./RegisterForm/RegisterForm";

function Auth() {
  const authContext = useContext(AuthContext);
  const isRegistered = authContext ? authContext.isRegistered : true;

  return (
    <div className="w-[100%] h-[100%] bg-[#7149C6] flex flex-col justify-center items-center rounded-3xl ">
      {isRegistered ? <LogInForm /> : <RegisterForm />}
      <h1 className="mb-5 mt-10 text-lg">
        This project is for educational purposes only. Do not use your personal
        data!
      </h1>
    </div>
  );
}

export default Auth;