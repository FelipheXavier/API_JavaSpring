import axios from "axios";

const API_URL = "http://localhost:8080/foods";

export const FoodList = () => axios.get(API_URL);

export const CreateANewFood = (food) => axios.post(API_URL,food);