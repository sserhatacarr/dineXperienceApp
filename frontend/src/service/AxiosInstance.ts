import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/", // Replace with your API base URL
});

//const jwtToken = localStorage.getItem("au");
//const cleanedToken = jwtToken ? jwtToken.replace(/^"(.*)"$/, "$1") : null;

export { axiosInstance};
