/* eslint-disable @typescript-eslint/no-explicit-any */
import Navbar from "../../components/Navbar/Navbar";
import { useContext, useEffect, useState } from "react";
import { DataContext } from "../../context/DataContext";
import {
  fetchAllRestaurants,
  restaurantRecommendation,
} from "../../service/RestaurantService";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faStar } from "@fortawesome/free-solid-svg-icons"; // İkonu import edin

function Home() {
  const dataContext = useContext(DataContext);
  const [recommendationInput, setRecommendationInput] = useState<string>("");
  const update = dataContext ? dataContext.updateApp : false;
  const restaurants = dataContext ? dataContext.restaurants : [];

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetchAllRestaurants();
        dataContext?.setRestaurants(response.data);
        /*dataContext?.setRestaurants([
          {
            id: "10",
            name: "Test Restaurant 10",
            address: "Test Address 10",
            phone: "1234567890",
            email: "test10@test.com",
            description: "Test Description",
            website: "www.testrestaurant10.com",
            workingHours: "09:00-18:00",
            latitude: 41.71,
            longitude: -71.2,
            restaurantRate: 5,
            status: "ACTIVE",
          },
          {
            id: "1",
            name: "Test Restaurant 1",
            address: "Test Address 1",
            phone: "1234567890",
            email: "test1@test.com",
            description: "Test Description",
            website: "www.testrestaurant1.com",
            workingHours: "09:00-18:00",
            latitude: 40.71,
            longitude: -74.05,
            restaurantRate: 1,
            status: "ACTIVE",
          },
          {
            id: "3",
            name: "Test Restaurant 3",
            address: "Test Address 3",
            phone: "1234567890",
            email: "test3@test.com",
            description: "Test Description",
            website: "www.testrestaurant3.com",
            workingHours: "09:00-18:00",
            latitude: 40.71,
            longitude: -74.3,
            restaurantRate: 3,
            status: "ACTIVE",
          },
          {
            id: "4",
            name: "Test Restaurant 4",
            address: "Test Address 4",
            phone: "1234567890",
            email: "test4@test.com",
            description: "Test Description",
            website: "www.testrestaurant4.com",
            workingHours: "09:00-18:00",
            latitude: 40.71,
            longitude: -74.02,
            restaurantRate: 4,
            status: "ACTIVE",
          },
          {
            id: "5",
            name: "Test Restaurant 5",
            address: "Test Address 5",
            phone: "1234567890",
            email: "test5@test.com",
            description: "Test Description",
            website: "www.testrestaurant5.com",
            workingHours: "09:00-18:00",
            latitude: 40.7132,
            longitude: -74.2,
            restaurantRate: 5,
            status: "ACTIVE",
          },
          {
            id: "6",
            name: "Test Restaurant 7",
            address: "Test Address 7",
            phone: "1234567890",
            email: "test7@test.com",
            description: "Test Description",
            website: "www.testrestaurant7.com",
            workingHours: "09:00-18:00",
            latitude: 41.71,
            longitude: -73.05,
            restaurantRate: 1,
            status: "ACTIVE",
          },
          {
            id: "7",
            name: "Test Restaurant 7",
            address: "Test Address 7",
            phone: "1234567890",
            email: "test7@test.com",
            description: "Test Description",
            website: "www.testrestaurant7.com",
            workingHours: "09:00-18:00",
            latitude: 41.74,
            longitude: -73.2,
            restaurantRate: 2,
            status: "ACTIVE",
          },
          {
            id: "9",
            name: "Test Restaurant 9",
            address: "Test Address 9",
            phone: "1234567890",
            email: "test9@test.com",
            description: "Test Description",
            website: "www.testrestaurant9.com",
            workingHours: "09:00-18:00",
            latitude: 42.71,
            longitude: -73.02,
            restaurantRate: 4,
            status: "ACTIVE",
          },
          {
            id: "2",
            name: "Test Restaurant 2",
            address: "Test Address 2",
            phone: "1234567890",
            email: "test2@test.com",
            description: "Test Description",
            website: "www.testrestaurant2.com",
            workingHours: "09:00-18:00",
            latitude: 40.74,
            longitude: -74,
            restaurantRate: 2,
            status: "ACTIVE",
          },
          {
            id: "8",
            name: "Test Restaurant 8",
            address: "Test Address 8",
            phone: "1234567890",
            email: "test8@test.com",
            description: "Test Description",
            website: "www.testrestaurant8.com",
            workingHours: "09:00-18:00",
            latitude: 40.75,
            longitude: -74.5,
            restaurantRate: 3,
            status: "ACTIVE",
          },
        ]);*/
      } catch (error) {
        console.log(error);
      }
    };

    if (dataContext) {
      fetchData();
    }
  }, [update]);

  console.log(restaurants);

  const handleRecommendation = async () => {
    try {
      if (recommendationInput === "") {
        dataContext?.setUpdateApp(!update);
      } else {
        const response = await restaurantRecommendation(recommendationInput);
        dataContext?.setRestaurants(response.data.restaurantList);
        /*dataContext?.setRestaurants([
          {
            id: "5",
            name: "Test Restaurant 5",
            address: "Test Address 5",
            phone: "1234567890",
            email: "test5@test.com",
            description: "Test Description",
            website: "www.testrestaurant5.com",
            workingHours: "09:00-18:00",
            latitude: 40.7132,
            longitude: -74.2,
            restaurantRate: 5,
            score: 3.5318566551063597,
            distance: 8.938111496454672,
            status: "ACTIVE",
          },
          {
            id: "4",
            name: "Test Restaurant 4",
            address: "Test Address 4",
            phone: "1234567890",
            email: "test4@test.com",
            description: "Test Description",
            website: "www.testrestaurant4.com",
            workingHours: "09:00-18:00",
            latitude: 40.71,
            longitude: -74.02,
            restaurantRate: 4,
            score: 2.874348912159858,
            distance: 7.5217029280047205,
            status: "ACTIVE",
          },
          {
            id: "2",
            name: "Test Restaurant 2",
            address: "Test Address 2",
            phone: "1234567890",
            email: "test2@test.com",
            description: "Test Description",
            website: "www.testrestaurant2.com",
            workingHours: "09:00-18:00",
            latitude: 40.74,
            longitude: -74,
            restaurantRate: 2,
            score: 1.4472498642417984,
            distance: 8.425004525273385,
            status: "ACTIVE",
          },
        ]);*/
      }
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <div className="w-screen h-[%100]  flex flex-col items-center pt-5 relative px-20 bg-[#f4edcc] pb-16">
      <Navbar />
      <div
        id="innerHomeContainer"
        className="mt-48 flex flex-col flex-wrap gap-5 justify-center items-center"
      >
        <div
          id="recommendationContainer"
          className="flex flex-col justify-center items-center gap-5 min-w-[600px] w-[50%] py-6 h-full bg-gradient-to-br to-orange-600 from-purple-800 rounded-xl shadow-black shadow-xl m-5 p-5 relative text-white"
        >
          <h2 className="font-bold text-lg">
            Get Restaurant Recommendation Special To You
          </h2>
          <div className="flex gap-5">
            <input
              type="text"
              value={recommendationInput}
              onChange={(e) => setRecommendationInput(e.target.value)}
              className="px-3 py-1 rounded border-none text-black"
              maxLength={10}
              placeholder="Please enter your user id"
            />
            <button
              onClick={handleRecommendation}
              className="px-5 py-3 rounded-lg bg-black"
            >
              Get Recommended Restaurants
            </button>
          </div>
        </div>
        <div className="w-[100%] flex flex-wrap gap-5 justify-center">
          {dataContext?.restaurants.map((restaurant: any) => (
            <div
              key={restaurant.id}
              className="mt-20 flex-shrink-0 flex flex-col gap-3 w-80 md:w-96 h-full bg-gradient-to-br to-orange-600 from-purple-800 rounded-xl shadow-black shadow-xl m-5 p-5 relative text-white"
            >
              {restaurant.score && (
                <div className="absolute top-[-100px] right-20 bg-gradient-to-br from-purple-700 to-orange-500 text-white rounded-lg shadow-md px-4 py-2">
                  <h3 className="font-bold text-lg">Recommendation Score</h3>
                  <p>{restaurant.score.toFixed(2)}</p>
                  <h3 className="font-bold text-lg">Distance</h3>
                  <p>{restaurant.distance.toFixed(2)}</p>
                </div>
              )}
              <div>{}</div>
              <h1 className="text-2xl font-bold">{restaurant.name}</h1>
              <div className="absolute top-4 right-5">
                <h3 className="font-bold text-lg">Rate</h3>
                <div className="flex items-center gap-2">
                  <p className="text-lg">{restaurant.restaurantRate}</p>
                  <FontAwesomeIcon icon={faStar} />
                </div>
              </div>
              <div>
                <h3 className="font-bold text-lg">Address</h3>
                <p>{restaurant.address}</p>
                <div className="flex flex-col items-center justify-center">
                  <h3 className="font-bold text-lg">Coordinates</h3>
                  <div className="flex gap-5">
                    <p>Latitude: {restaurant.latitude}</p>
                    <p>Longitude: {restaurant.longitude}</p>
                  </div>
                </div>
              </div>
              <div>
                <h3 className="font-bold text-lg">Description</h3>
                <p>{restaurant.description}</p>
                <div>
                  <h3 className="font-bold text-sm">Working Hours</h3>
                  <p>{restaurant.workingHours}</p>
                </div>
              </div>
              <div>
                <h3 className="font-bold text-lg">Contact Info</h3>
                <p>{restaurant.phone}</p>
                <p>{restaurant.email}</p>
                <p>{restaurant.website}</p>
              </div>

              <div className="absolute top-5 flex flex-col items-center justify-center">
                <div
                  className={`w-6 h-6 rounded-full ${
                    restaurant.status === "ACTIVE"
                      ? "bg-green-500"
                      : "bg-gray-500"
                  }`}
                ></div>
                <p className="text-sm font-bold">{restaurant.status}</p>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default Home;
