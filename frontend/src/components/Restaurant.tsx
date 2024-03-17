import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons";

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
  score?: number;
  distance?: number;
}

function Restaurant({
  restaurant,
  handleRestaurantClick,
}: {
  restaurant: Restaurant | null;
  handleRestaurantClick: ((id: string) => void) | null;
}) {
  const handleClick = () => {
    if (restaurant?.id && handleRestaurantClick)
      handleRestaurantClick(restaurant.id);
  };

  return (
    <div
      key={restaurant?.id}
      onClick={() => handleClick()}
      className={`mt-20 mb-10 flex-shrink-0 flex flex-col gap-3 w-80 md:w-96 h-fit bg-gradient-to-br to-orange-600 from-purple-800 rounded-xl shadow-black shadow-xl m-5 p-5 relative text-white ${
        handleRestaurantClick !== null
          ? "cursor-pointer hover:border-2 hover:border-black hover:shadow-2xl hover:scale-105 transition-all duration-300 ease-in-out"
          : ""
      }`}
    >
      {restaurant?.score && restaurant?.distance && (
        <div className="absolute top-[-100px] right-20 bg-gradient-to-br from-purple-700 to-orange-500 text-white rounded-lg shadow-md px-4 py-2">
          <h3 className="font-bold text-lg">Recommendation Score</h3>
          <p>{restaurant?.score.toFixed(2)}</p>
          <h3 className="font-bold text-lg">Distance</h3>
          <p>{restaurant?.distance.toFixed(2)}</p>
        </div>
      )}
      <div>{}</div>
      <h1 className="text-2xl font-bold">{restaurant?.name}</h1>
      <div className="absolute top-4 right-5">
        <h3 className="font-bold text-lg">Rate</h3>
        <div className="flex items-center gap-2">
          <p className="text-lg">{restaurant?.restaurantRate}</p>
          <FontAwesomeIcon icon={faStar} />
        </div>
      </div>
      <div>
        <h3 className="font-bold text-lg">Address</h3>
        <p>{restaurant?.address}</p>
        <div className="flex flex-col items-center justify-center">
          <h3 className="font-bold text-lg">Coordinates</h3>
          <div className="flex gap-5">
            <p>Latitude: {restaurant?.latitude}</p>
            <p>Longitude: {restaurant?.longitude}</p>
          </div>
        </div>
      </div>
      <div>
        <h3 className="font-bold text-lg">Description</h3>
        <p>{restaurant?.description}</p>
        <div>
          <h3 className="font-bold text-sm">Working Hours</h3>
          <p>{restaurant?.workingHours}</p>
        </div>
      </div>
      <div>
        <h3 className="font-bold text-lg">Contact Info</h3>
        <p>{restaurant?.phone}</p>
        <p>{restaurant?.email}</p>
        <p>{restaurant?.website}</p>
      </div>

      <div className="absolute top-5 flex flex-col items-center justify-center">
        <div
          className={`w-6 h-6 rounded-full ${
            restaurant?.status === "ACTIVE" ? "bg-green-500" : "bg-gray-500"
          }`}
        ></div>
        <p className="text-sm font-bold">{restaurant?.status}</p>
      </div>
    </div>
  );
}

export default Restaurant;
