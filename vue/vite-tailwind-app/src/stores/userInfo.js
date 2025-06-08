import { defineStore } from "pinia";

export const useUserStore = defineStore("user", {
  state: () => ({
    name: "",
    email: "",
  }),
  actions: {
    setUserInfo({ name, email }) {
      this.name = name;
      this.email = email;
    },
    clearUserInfo() {
      this.name = "";
      this.email = "";
    },
  },
  persist: true,
});
