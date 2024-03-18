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
