<script setup>
import { useUserStore } from "./stores/userInfo";
import { useRouter } from "vue-router";
import { useModalState } from "./stores/modal";

const userStore = useUserStore();
const router = useRouter();
const modal = useModalState();

const handleLogout = () => {
  userStore.clearUserInfo();
  modal.Open = true;
  modal.Open({
    title: "로그아웃",
    message: "성공적으로 로그아웃 되었습니다.",
  });
};
</script>
<template>
  <div class="flex flex-col min-h-screen">
    <header class="bg-gray-800 text-white px-6 py-4 shadow-md">
      <div class="container mx-auto flex items-center justify-between">
        <h1 class="text-xl font-bold">LOGO</h1>
        <nav class="flex space-x-4">
          <router-link class="hover:underline" to="/home">Home</router-link>
          <router-link class="hover:underline" to="/about">About</router-link>
          <router-link class="hover:underline" to="/members"
            >Members</router-link
          >
          <div v-if="userStore.name" class="flex gap-4">
            <span>{{ userStore.name }}</span>
            <button class="hover:underline" @click="handleLogout">
              로그아웃
            </button>
          </div>
          <div v-else>
            <button class="hover:underline" @click="router.push('/')">
              로그인
            </button>
          </div>
        </nav>
      </div>
    </header>
    <main class="flex-1 container mx-auto px-4 py-6 content-center">
      <router-view />
    </main>

    <footer class="bg-gray-100 text-gray-600 text-sm py-4 mt-8 border-t">
      <div class="container mx-auto text-center">
        © 2025 MyApp. All rights reserved.
      </div>
    </footer>
  </div>
</template>
