/* eslint-disable @typescript-eslint/no-explicit-any */
import Navbar from "../../components/Navbar/Navbar";
import { useContext, useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import { DataContext } from "../../context/DataContext";
import {
  fetchAllRestaurants,
  restaurantRecommendation,
} from "../../service/RestaurantService";
import Restaurant from "../../components/Restaurant";

function Home() {
  const dataContext = useContext(DataContext);
  const [recommendationInput, setRecommendationInput] = useState<string>("");
  const update = dataContext ? dataContext.updateApp : false;
  const restaurants = dataContext ? dataContext.restaurants : [];
  const history = useHistory();

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
        dataContext?.setRecommendedUser({
          id: 0,
          name: "string",
          surname: "string",
          email: "string@gmail.com",
          latitude: 0,
          longitude: 0,
        });
        dataContext?.setUpdateApp(!update);
      } else {
        const response = await restaurantRecommendation(recommendationInput);
        dataContext?.setRestaurants(response.data.restaurantList);
        dataContext?.setRecommendedUser({
          id: 1,
          name: "Ahmet",
          surname: "Çelik",
          email: "çelik@gmail.com",
          latitude: 0,
          longitude: 0,
        });
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

  const handleRestaurantClick = (id: string) => {
    history.push(`/restaurant/${id}`);
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
        <div className="mb-10">
          {dataContext?.recommendedUser.id !== 0 && (
            <div>
              <h1 className="font-bold text-lg">
                Restaurant Recommendations For{" "}
                {dataContext?.recommendedUser.name}
              </h1>
            </div>
          )}
        </div>
        <div className="w-[100%] flex flex-wrap gap-5 justify-center">
          {dataContext?.restaurants.map((restaurant: any) => (
            <Restaurant
              key={restaurant.id}
              restaurant={restaurant}
              handleRestaurantClick={handleRestaurantClick}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default Home;
