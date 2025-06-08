<template>
  <div style="padding: 2rem">
    <h2>computed 예제</h2>
    <input v-model.number="num0" placeholder="숫자 0 입력" />
    <input v-model.number="num1" placeholder="숫자 1 입력" />
    <input v-model.number="num2" placeholder="숫자 2 입력" />
    <p>{{ sum }}</p>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
const num0 = ref(0);
const num1 = ref(0);
const num2 = ref(0);

// computed는 의존하는 값이 변경 될 때만 재계산됨.
const sum = computed(() => {
  console.log("sum 값을 재계산");
  return num1.value + num2.value;
});
</script>

<style scoped>
input {
  padding: 8px;
  margin-right: 8px;
  width: 120px;
}

p {
  margin-top: 1rem;
  font-size: 20px;
  font-weight: bold;
}
</style>
