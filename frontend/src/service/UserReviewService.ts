/* eslint-disable @typescript-eslint/no-explicit-any */
import { axiosInstance } from "./AxiosInstance";

interface UserReviewApiResponse {
  data: {
    id: number;
    user: {
      baseAdditionalFields: {
        createdAt: string;
        updatedAt: string;
        creatorId: number;
        updatedId: number;
      };
      id: number;
      name: string;
      surname: string;
      birthDate: string;
      email: string;
      gender: string;
      userStatus: string;
      latitude: number;
      longitude: number;
    };
    restaurantId: string;
    restaurantName: string;
    comment: string;
    userRate: number;
  }[];
  responseDate: string;
  message: string;
  success: boolean;
}

interface UserReviewPost{
  "restaurantId": string,
  "comment": string,
  "userRate": number,
  "user": {
    "baseAdditionalFields": {
      "createdAt": string,
      "updatedAt": string,
      "creatorId": number,
      "updatedId": number
    },
    "id": number,
    "name": string,
    "surname": string,
    "birthDate": string,
    "email": string,
    "gender": string,
    "userStatus": string,
    "latitude": number,
    "longitude": number
  }
}

const fetchUserReviewByRestauranId = async (id: string): Promise<any> => {
    try {
        const response = await axiosInstance.get<any>(`/api/v1/users/reviews/restaurant/${id}`);
        return response.data;
    } catch (e) {
        console.log(e);
        throw e;
    }
}

const saveUserReview = async (userReview: UserReviewPost): Promise<any> => {
    try {
        const response = await axiosInstance.post<UserReviewPost>("/api/v1/users/reviews", userReview);
        console.log(response.data);
        return response.data;
    } catch (e) {
        console.log(e);
        throw e;
    }

}

export { fetchUserReviewByRestauranId,saveUserReview}

