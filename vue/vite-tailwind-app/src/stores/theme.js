// pinia에서 스토어(store)를 정의
// components에서 useXXXStore()와 같은 함수를 만들어서 호출하면 됨.
import { defineStore } from "pinia";

export const useThemeStore = defineStore("theme", {
  state: () => ({
    color: "orange",
  }),
  actions: {
    setColor(newColor) {
      this.color = newColor;
    },
  },
  persist: true,
});
