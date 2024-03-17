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

// updateApp ekle useeffect
// updateApp ekle saveUser
// home 192.satır user ismi gösterme kısmı
// css rate 5 e kadar

function Profile() {
  const [users, setUsers] = useState<User[]>([]);

  useEffect(() => {
    fetchAllUsers().then((response: UserResponse) => {
      setUsers(response.data);
    });
    /*setUsers([
      {
        id: 1,
        name: "John",
        surname: "Doe",
        birthDate: "1990-01-15",
        email: "john.doe@example.com",
        gender: "MALE",
        userStatus: "ACTIVE",
        latitude: 40.74,
        longitude: -74.1,
      },
      {
        id: 2,
        name: "Jane",
        surname: "Smith",
        birthDate: "1985-05-20",
        email: "jane.smith@example.com",
        gender: "FEMALE",
        userStatus: "ACTIVE",
        latitude: 40.7,
        longitude: -73.93,
      },
      {
        id: 3,
        name: "Bob",
        surname: "Jones",
        birthDate: "1998-08-10",
        email: "bob.jones@example.com",
        gender: "MALE",
        userStatus: "ACTIVE",
        latitude: 40.69,
        longitude: -74.07,
      },
      {
        id: 4,
        name: "Alice",
        surname: "Miller",
        birthDate: "1980-03-25",
        email: "alice.miller@example.com",
        gender: "FEMALE",
        userStatus: "INACTIVE",
        latitude: 40.69,
        longitude: -73.99,
      },
      {
        id: 5,
        name: "David",
        surname: "Wilson",
        birthDate: "1995-12-03",
        email: "david.wilson@example.com",
        gender: "MALE",
        userStatus: "ACTIVE",
        latitude: 40.72,
        longitude: -74.05,
      },
      {
        id: 6,
        name: "Emily",
        surname: "Brown",
        birthDate: "1987-09-18",
        email: "emily.brown@example.com",
        gender: "FEMALE",
        userStatus: "INACTIVE",
        latitude: 40.72,
        longitude: -73.95,
      },
      {
        id: 7,
        name: "Charlie",
        surname: "Anderson",
        birthDate: "1993-07-12",
        email: "charlie.anderson@example.com",
        gender: "MALE",
        userStatus: "ACTIVE",
        latitude: 40.68,
        longitude: -73.92,
      },
      {
        id: 8,
        name: "Olivia",
        surname: "White",
        birthDate: "1983-11-30",
        email: "olivia.white@example.com",
        gender: "FEMALE",
        userStatus: "INACTIVE",
        latitude: 40.75,
        longitude: -73.97,
      },
    ]);*/
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
