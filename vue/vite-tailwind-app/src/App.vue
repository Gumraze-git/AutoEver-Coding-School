<script setup>
import { useThemeStore } from "./stores/theme";

import Modal from "./components/base/BaseModal.vue";

const themeStore = useThemeStore();
</script>

<template>
  <div
    :style="{ backgroundColor: themeStore.color }"
    class="min-h-screen transition-all"
  >
    <router-view />
    <Modal />
  </div>
</template>
