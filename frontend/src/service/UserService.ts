import { axiosInstance } from "./AxiosInstance";

const deleteUser = async (id: number) => {
    try {
        const response = await axiosInstance.delete(`/api/v1/users/${id}`);
        return response.data;
    }catch (error) {
        console.error(error);
    }
}

export {deleteUser}