import React, { useEffect, useState } from "react";
import Navbar from "../../components/Navbar/Navbar";
import UserTable from "../../components/Table/UserTable";
import { fetchAllUsers } from "../../service/UserService";
import ProfileForm from "../../components/ProfileForm";

interface User {
  id: number;
  name: string;
  surname: string;
  birthDate: string;
  email: string;
  gender: string;
  userStatus: string;
  latitude: number;
  longitude: number;
}

interface UserResponse {
  data: User[];
  responseDate: string;
  message: string;
  success: boolean;
}

function Profile() {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    fetchAllUsers().then((response: UserResponse) => {
      setUsers(response.data);
    });
    
  }, []);

  return (
    <div className="w-screen h-screen flex flex-col items-center pt-5 relative px-20 pb-16 bg-[#f4edcc]">
      <Navbar />
      <div
        id="innerHomeContainer"
        className="w-screen h-screen mt-48 flex  flex-wrap gap-5 justify-center items-center"
      >
        <UserTable data={users} />
        <ProfileForm />
      </div>
    </div>
  );
}

export default Profile;
