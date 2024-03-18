/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useEffect, useContext, useState } from "react";
import { useParams } from "react-router-dom";
import { fetchRestaurantById } from "../../service/RestaurantService";
import Restaurant from "../../components/Restaurant";
import { fetchUserReviewByRestauranId } from "../../service/UserReviewService";
import ReviewForm from "../../components/ReviewForm";
import { DataContext } from "../../context/DataContext";

interface RestaurantType {
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

interface UserReviewType {
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
}

function RestaurantDetail() {
  const dataContext = useContext(DataContext);
  const { id } = useParams<{ id: string }>();
  const [restaurant, setRestaurant] = useState<RestaurantType | null>(null);
  const [userReviews, setUserReviews] = useState<any>([]);

  useEffect(() => {
    console.log("aaa");
    console.log(id);
    if (id) {
      const fetchData = async () => {
        await fetchRestaurantById(id)
          .then((response) => {
            setRestaurant(response.data);
        
          })
          .catch((error) => {
            console.error(error);
          });

        await fetchUserReviewByRestauranId(id)
          .then((response: any) => {
            console.log(response);
            setUserReviews(response.data);
          })
          .catch((error) => {
            console.error(error);
          });
      };
      fetchData();
    }
  }, [id, dataContext?.updateApp]);

  return (
    <div className="flex justify-center items-center w-screen h-screen bg-[#f4edcc] overflow-x-hidden">
      <ReviewForm restaurantId={id} />
      <div className="flex flex-col mr-auto">
        <Restaurant restaurant={restaurant} handleRestaurantClick={null} />
        <div id="userReviewContainer" className="w-96 overflow-y-auto p-4">
          {userReviews.map((review: any) => (
            <div
              className="bg-gradient-to-br to-orange-600 from-purple-800 rounded-lg shadow-md shadow-black p-4 mb-4 text-white"
              key={review.id}
            >
              <div className="flex justify-between mb-2">
                <h3 className="font-bold">{review.user.name}</h3>
                <p className="text-sm text-gray-500">
                  {new Date(
                    review.user.baseAdditionalFields.createdAt
                  ).toLocaleDateString()}
                </p>
              </div>
              <p className="mb-2">{review.comment}</p>
              <p className="text-sm">Rate: {review.userRate}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default RestaurantDetail;