import { axiosInstance } from "./AxiosInstance";

interface Restaurant {
    id: string;
    name: string;
    address: string;
    phone: string;
    email: string;
    description: string;
    website: string;
    workingHours: string;
    latitude: number;
    longitude: number;
    restaurantRate: number;
    status: string;
}

interface RestaurantRecommendation extends Restaurant{
    score: number;
    distance: number;
}

interface FetchAllRestaurantsResponse {
    data: Restaurant[];
    responseDate: string;
    message: string;
    success: boolean;
}

interface FetchRestaurantByIdResponse {
    data: Restaurant;
    responseDate: string;
    message: string;
    success: boolean;
}

interface DeleteRestaurantResponse {
    data: object;
    responseDate: string;
    message: string;
    success: boolean;
}

interface data {
    user: {
            id: number;
            name: string;
            surname: string;
            email: string;
            latitude: number;
            longitude: number;
        };
    restaurantList: RestaurantRecommendation[];
}

interface FetchRestaurantByIdResponse {
    data: Restaurant
    responseDate: string;
    message: string;
    success: boolean;
}

interface FetchRestaurantRecommendationByIdResponse {
    data: data;
    responseDate: string;
    message: string;
    success: boolean;
}



const fetchAllRestaurants = async (): Promise<FetchAllRestaurantsResponse> => {
    try{
        const response = await axiosInstance.get("/api/v1/restaurants/")
        return response.data
    }catch(e){
        console.log(e)
        throw e
    }
}

const fetchRestaurantById = async (id: string): Promise<FetchRestaurantByIdResponse> => {
    try{
        const response = await axiosInstance.get(`/api/v1/restaurants/${id}`)
        return response.data
    }catch(e){
        console.log(e)
        throw e
    }
}

const deleteRestaurant = async (id: string): Promise<DeleteRestaurantResponse> => {
    try{
        const response = await axiosInstance.delete(`/api/v1/restaurants/${id}`)
        return response.data
    }catch(e){
        console.log(e)
        throw e
    }

}

const saveRestaurant = async (restaurant: Restaurant): Promise<FetchRestaurantByIdResponse> => {
    try{
        const response = await axiosInstance.post("/api/v1/restaurants/", restaurant)
        return response.data
    }catch(e){
        console.log(e)
        throw e
    }

}


const restaurantRecommendation = async (id: string): Promise<FetchRestaurantRecommendationByIdResponse> => {
    try {
        const response = await axiosInstance.get(`/api/v1/restaurants/recommendations/${id}`);
        return response.data as FetchRestaurantRecommendationByIdResponse;
    } catch (e) {
        console.log(e);
        throw e;
    }
}



export {fetchAllRestaurants, fetchRestaurantById,deleteRestaurant,restaurantRecommendation}