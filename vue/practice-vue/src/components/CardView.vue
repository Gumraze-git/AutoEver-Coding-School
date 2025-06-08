<script setup>
// 부모 요소에서 name, job, age를 넘겨받으면 렌더링이 발생함.
const props = defineProps({
  name: String,
  job: String,
  age: Number,
});
</script>

<template>
  <div class="card">
    <h2>이름: {{ name }}</h2>
    <p>직업: {{ job }}</p>
    <p>나이: {{ age }}</p>
  </div>
</template>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 8px;
}
</style>
