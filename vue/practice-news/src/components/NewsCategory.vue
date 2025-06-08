<script setup>
const emit = defineEmits(["btn-state"]);

const activeBtn = (category) => {
  emit("btn-state", category);
};

const props = defineProps({
  item: Array,
});
</script>

<template>
  <div class="btn-box">
    <button class="btn" v-for="(item, index) in props.item" :key="index">
      {{ item }}
    </button>
  </div>
</template>

<style scoped>
.btn-box {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 12px;
  background-color: #f0f0f0;
  padding: 1rem;
  border-radius: 10px;
  flex-wrap: wrap;
}

.btn {
  flex: 1;
  padding: 0.6rem 1.2rem;
  font-weight: 600;
  font-size: 14px;
  border: none;
  border-radius: 6px;
  background-color: #007bff;
  color: white;
  cursor: pointer;
  transition: background-color 0.2s ease, transform 0.1s ease;
}

.btn:hover {
  background-color: #0056b3;
}

.btn:focus {
  outline: none;
  box-shadow: 0 0 0 2px rgba(0, 123, 255, 0.4);
}
</style>
