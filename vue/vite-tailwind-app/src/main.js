// 앱 설정
import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
const app = createApp(App);

// 라우터 설정
import router from "./router";

// 전역 상태 관리(pinia)
import { createPinia } from "pinia";
import piniaPluginPersistedstate from "pinia-plugin-persistedstate";

const pinia = createPinia();
pinia.use(piniaPluginPersistedstate);

app.use(pinia);
app.use(router);
app.mount("#app");
