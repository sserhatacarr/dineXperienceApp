/* eslint-disable @typescript-eslint/no-explicit-any */
import { useContext } from "react";
import { AuthContext } from "../../../context/AuthContext";
import SendRequest from "../../../service/SendAuthRequest";

function RegisterForm() {
  const authContext = useContext(AuthContext);

  const handleRegister = async (e: any) => {
    e.preventDefault();

    if (
      authContext &&
      authContext.logInUserForm.username !== "" &&
      authContext.logInUserForm.password !== ""
    ) {
      try {
        
        await SendRequest({
          actionType: "signIn",
          createUserForm: authContext.createUserForm,
          setCreateUserForm: authContext.setCreateUserForm,
          setIsRegistered: authContext.setIsRegistered,
          isRegistered: authContext.isRegistered,
          logInUserForm: authContext.logInUserForm,
          setUserId: authContext.setUserId,
          setIsLoggedIn: authContext.setIsLoggedIn,
          setJwt: authContext.setJwt,
          history: history,
        });
      } catch (error) {
        console.error("Error occurred during login:", error);
      }
    } else {
      alert("Please fill in all fields");
    }
  };

  function toggleForm() {
    if (authContext) {
      authContext.setIsRegistered(!authContext.isRegistered);
    }
  }

  const onChangeRegister = (e: any) => {
    if (authContext) {
      const { name, value } = e.target;

      if (name === "passwordChecker") {
        authContext.setPasswordChecker(value);
      } else {
        authContext.setCreateUserForm((prevState) => ({
          ...prevState,
          [name]: value,
        }));
      }
    }
  };

  return (
    <div className="h-full w-fit flex justify-center mt-10 bg-gradient-to-br from-purple-600 to-orange-400 rounded-3xl">
      <form className="w-full h-full" onSubmit={handleRegister}>
        <div className="h-full w-[100%] flex flex-col justify-center rounded-3xl items-center gap-5 border px-40 shadow-xl shadow-[#FFDEB9] text-black">
          <h2 className="text-5xl">Create Account</h2>
          <label htmlFor="mail" className="text-2xl">
            Mail
          </label>
          <input
            type="email"
            name="mail"
            placeholder="example@gmail.com"
            required={true}
            value={authContext?.createUserForm?.mail}
            onChange={onChangeRegister}
            maxLength={50}
            className="border-1 border-black rounded-md p-2 w-80 text-lg"
          />

          <label htmlFor="name" className="text-2xl">
            Name
          </label>
          <input
            type="text"
            name="name"
            placeholder="John"
            required={true}
            value={authContext?.createUserForm?.name}
            onChange={onChangeRegister}
            maxLength={40}
            className="border-1 border-black rounded-md p-2 w-80 text-lg"
          />

          <label htmlFor="surname" className="text-2xl">
            Surname
          </label>
          <input
            type="text"
            name="surname"
            placeholder="John"
            required={true}
            value={authContext?.createUserForm?.surname}
            onChange={onChangeRegister}
            maxLength={40}
            className="border-1 border-black rounded-md p-2 w-80 text-lg"
          />

          <label htmlFor="password" className="text-2xl">
            Password
          </label>
          <input
            type="password"
            name="password"
            placeholder="Password"
            required={true}
            value={authContext?.createUserForm?.password}
            onChange={onChangeRegister}
            maxLength={50}
            className="border-1 border-black rounded-md p-2 w-80 text-lg"
          />

          <label htmlFor="passwordChecker" className="text-2xl">
            Verify Password
          </label>
          <input
            type="password"
            name="passwordChecker"
            placeholder="Verify Password"
            required={true}
            value={authContext?.passwordChecker}
            onChange={onChangeRegister}
            maxLength={50}
            className="border-1 border-black rounded-md p-2 w-80 text-lg"
          />

          <button
            type="submit"
            name="register"
            onClick={handleRegister}
            className="mt-5 border-1 border-black rounded-md p-2 w-40 text-lg bg-[#FFDEB9] hover:bg-[#FE6244] transition-all duration-300 ease-in-out"
          >
            Register
          </button>

          <button
            onClick={toggleForm}
            className="mt-5 border-1 border-black rounded-md p-2 w-80 text-lg bg-[#FFDEB9] hover:bg-[#FE6244] transition-all duration-300 ease-in-out"
            name="toLogIn"
          >
            Do you already have an account?
          </button>
        </div>
      </form>
    </div>
  );
}

export default RegisterForm;
