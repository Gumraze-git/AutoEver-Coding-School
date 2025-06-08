<script setup>
import { useModalState } from "@/stores/modal";
const modal = useModalState();
</script>

<template>
  <div
    v-if="modal.isOpen"
    class="fixed inset-0 bg-black bg-opacity-50 z-50 flex items-center justify-center"
  >
    <div
      class="flex bg-white rounded-xl shadow-lg p-6 w-[90%] min-h-[25%] max-w-md animate-fadeIn flex-col justify-between"
    >
      <h2 class="text-2xl font-bold text-gray-800 text-center self-start">
        {{ modal.title }}
      </h2>
      <hr />
      <p class="text-gray-600 text-center m-6">
        {{ modal.message }}
      </p>
      <div class="flex justify-center gap-4">
        <button
          v-for="(button, index) in modal.buttons"
          :key="index"
          @click="button.onClick"
        >
          {{ button.label }}
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: scale(0.95);
  }
  to {
    opacity: 1;
    transform: scale(1);
  }
}

.animate-fadeIn {
  animation: fadeIn 0.2s ease-out;
}
</style>
