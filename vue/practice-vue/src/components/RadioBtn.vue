<template>
  <label><input type="radio" value="apple" v-model="selected" /> 사과</label>
  <label><input type="radio" value="orange" v-model="selected" /> 오렌지</label>
  <p>선택된 과일: {{ selected }}</p>
</template>

<script setup>
import { ref } from "vue";
const selected = ref("apple");
</script>
