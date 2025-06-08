import { extractRuntimeProps } from "vue/compiler-sfc";
import axios from "./axiosInstance";

export const useAuthApi = () => {
  const signUp = async (email, pwd, name) => {
    return await axios.post("/auth/signup", { email, pwd, name });
  };

  const login = async (email, pwd) => {
    return await axios.post("/auth/login", { email, pwd });
  };

  const exists = async (email) => {
    return await axios.post(`/auth/exists/${email}`);
  };

  return { login, signUp, exists };
};
