import { Link } from "react-router-dom";

function Navbar() {
  return (
    <div className="w-fit h-fit max-w-full bg-gradient-to-r from-purple-600  to-orange-500 flex shadow-lg shadow-black justify-between py-6 px-10 rounded-3xl items-center gap-5 fixed z-20">
      <ul className="flex gap-10 justify-between items-align px-5">
        <Link to="/home">
          <li className="text-2xl text-center px-4 py-2 shadow-black shadow-md rounded-lg bg-gradient-to-r from-orange-600 to-orange-400  font-extrabold text-purple-200 border-2 border-transparent hover:text-[#f4edcc] hover:text-purple-600 hover:border-[#f4edcc] transition-colors duration-300 ease-in-out">
            Restaurants
          </li>
        </Link>
        <Link to="/profile">
          <li className="text-2xl text-center px-4 py-2 shadow-black shadow-md rounded-lg bg-gradient-to-r from-purple-600 to-purple-400  font-extrabold text-purple-200  border-2 border-transparent  hover:text-[#f4edcc] hover:bg-orange-500 hover:border-[#f4edcc] transition-colors duration-300 ease-in-out">
            Users
          </li>
        </Link>
      </ul>
    </div>
  );
}

export default Navbar;
