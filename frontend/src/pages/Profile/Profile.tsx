import React, { useEffect, useState } from "react";
import Navbar from "../../components/Navbar/Navbar";
import { deleteUser } from "../../service/UserService";
import { useHistory } from "react-router-dom";

function Profile() {
  const history = useHistory();
  const [userId, setUserId] = useState<number>(0);

  useEffect(() => {}, []);

  const handleDelete = async () => {
    if (userId === 0) {
      return;
    }
    const response = await deleteUser(userId);
    console.log(response);
    history.push("/");
    localStorage.setItem("au", "");
  };

  return (
    <div className="w-screen h-screen flex flex-col items-center pt-5 relative px-20 pb-16 bg-[#f4edcc]">
      <Navbar />
      <div
        id="innerHomeContainer"
        className="w-screen h-screen mt-48 flex flex-col flex-wrap gap-5 justify-center items-center"
      >
        <div className="flex flex-col gap-5 bg-slate-600 px-10 py-10 rounded-md">
          <h2></h2>
          <input
            type="text"
            placeholder="Your Id"
            className="px-3 py-1 rounded"
          />
          <button
            className="bg-purple-700 py-3 rounded-lg text-white w-full"
            onClick={() => handleDelete()}
          >
            Delete User
          </button>
        </div>
      </div>
    </div>
  );
}

export default Profile;
