import { createRouter, createWebHistory } from "vue-router";

import About from "../pages/About.vue";
import Profile from "../pages/profile.vue";
import Login from "../pages/login.vue";
import SignUp from "../pages/SignUp.vue";
import Layout from "../Layout.vue";
import Member from "../pages/Member.vue";
import Home from "../pages/Home.vue";
import ImageUploader from "../pages/ImageUploader.vue";

const routes = [
  // routes 배열 생성
  { path: "/", component: Login },
  { path: "/signUp", component: SignUp },
  {
    path: "/home",
    component: Layout,
    children: [
      { path: "", component: Home },
      { path: "/about", component: About },
      { path: "/profile/:username", component: Profile },
      { path: "/members", component: Member },
      { path: "/image-uploader", component: ImageUploader },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
