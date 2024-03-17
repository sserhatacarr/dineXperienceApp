import { axiosInstance } from "./AxiosInstance";

interface User {
    "name": string,
  "surname": string,
  "birthDate": string,
  "email": string,
  "gender": string,
  "userStatus": string,
  "latitude": number,
  "longitude": number
}

const deleteUser = async (id: number) => {
    try {
        const response = await axiosInstance.delete(`/api/v1/users/${id}`);
        return response.data;
    }catch (error) {
        console.error(error);
    }
}

const fetchAllUsers = async () => {
    try {
        const response = await axiosInstance.get(`/api/v1/users`);
        return response.data;
    }catch (error) {
        console.error(error);
    }
}

const saveUser = async (user: User) => {
    try {
        const response = await axiosInstance.post(`/api/v1/users`, user);
        return response.data;
    }catch (error) {
        console.error(error);
    }
}

export {deleteUser,fetchAllUsers,saveUser}