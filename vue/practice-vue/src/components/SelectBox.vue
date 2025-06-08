<template>
  <select v-model="fruit">
    <option disabled value="">과일을 선택하세요</option>
    <option value="apple">사과</option>
    <option value="banana">바나나</option>
    <option value="mango">망고</option>
  </select>
  <h3>선택된 과일: {{ fruit }}</h3>
</template>

<script setup>
import { ref } from "vue";
const fruit = ref("");
</script>
