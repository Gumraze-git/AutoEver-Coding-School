<template>
  <label><input type="checkbox" value="apple" v-model="selected" /> 사과</label>
  <label
    ><input type="checkbox" value="orange" v-model="selected" /> 오렌지</label
  >
  <label><input type="checkbox" value="berry" v-model="selected" />딸기</label>
  <p>선택된 과일 : {{ selected.join(", ") }}</p>
</template>

<script setup>
import { ref } from "vue";
const selected = ref(["apple"]);
</script>
