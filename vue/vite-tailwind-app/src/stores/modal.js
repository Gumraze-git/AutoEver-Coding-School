import { defineStore } from "pinia";

export const useModalState = defineStore("modal", {
  state: () => ({
    isOpen: false,
    title: "",
    message: "",
    buttons: [],
  }),
  actions: {
    Open({ title, message, buttons }) {
      //
      this.isOpen = true;
      this.title = title;
      this.message = message;
      this.buttons = buttons;
    },
    Close() {
      this.isOpen = false;
      this.title = "";
      this.message = "";
      this.buttons = [];
    },
  },
});
