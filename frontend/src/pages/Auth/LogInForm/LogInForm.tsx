/* eslint-disable @typescript-eslint/no-explicit-any */
import { useContext } from "react";
import { AuthContext } from "../../../context/AuthContext";
import { useHistory } from "react-router-dom";
import SendRequest from "../../../service/SendAuthRequest";

function LogInForm() {
  const history = useHistory();

  const authContext = useContext(AuthContext);

  const handleLogIn = async (e: any) => {
    e.preventDefault();

    if (authContext) {
      try {
        const username = localStorage.getItem("username");
        const password = localStorage.getItem("password");

        if (
          username === authContext.logInUserForm.username &&
          password === authContext.logInUserForm.password
        ) {
          authContext.setIsLoggedIn(true);
          localStorage.setItem("jwt", "pseudoJwt");
          history.push("/home");
        }
      } catch (error) {
        console.error("Error occurred during login:", error);
      }
    }
  };

  function toggleForm() {
    if (authContext) {
      authContext.setIsRegistered(!authContext.isRegistered);
    }
  }

  const onChangeLogIn = (e: any) => {
    if (authContext) {
      const { name, value } = e.target;

      authContext.setLogInUserForm((prevState) => ({
        ...prevState,
        [name]: value,
      }));
    }
  };

  return (
    <div className="h-full w-fit flex justify-center mt-10 bg-gradient-to-br from-purple-600 to-orange-400 rounded-3xl">
      <form className="w-full h-full" onSubmit={handleLogIn}>
        <div className="h-full w-[100%] flex flex-col justify-center rounded-3xl items-center gap-5 border px-40 shadow-xl shadow-[#FFDEB9] text-black">
          <h2 className="text-5xl">Log In</h2>
          <label htmlFor="username" className="text-2xl">
            Username
          </label>
          <input
            type="text"
            name="username"
            placeholder="John"
            required={true}
            value={authContext?.logInUserForm?.username} 
            onChange={onChangeLogIn}
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
            value={authContext?.logInUserForm?.password}
            onChange={onChangeLogIn}
            maxLength={50}
            className="border-1 border-black rounded-md p-2 w-80 text-lg"
          />

          <button
            type="submit"
            name="register"
            onClick={handleLogIn}
            className="mt-5 border-1 border-black rounded-md p-2 w-40 text-lg bg-[#FFDEB9] hover:bg-[#FE6244] transition-all duration-300 ease-in-out"
          >
            Log In
          </button>

          <button
            onClick={toggleForm}
            className="border-1 border-black rounded-md p-2 w-80 text-lg bg-[#FFDEB9] hover:bg-[#FE6244] transition-all duration-300 ease-in-out"
            name="toLogIn"
          >
            Don&apos;t you have an account?
          </button>
        </div>
      </form>
    </div>
  );
}

export default LogInForm;
