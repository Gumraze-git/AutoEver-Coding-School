<script setup>
import { ref } from "vue";
import DataBinding from "./components/DataBinding.vue"; // DataBinding 컴포넌트를 가져옵니다.
import ConditionRender from "./components/ConditionRender.vue";
import Iterable from "./components/IterableArray.vue";
import Class from "./components/ClassBinding.vue";
import Reactive from "./components/Reactive.vue";
import Compute from "./components/Compute.vue";
import Watch from "./components/Watch.vue";
</script>

<template>
  <h3>App.vue의 영역입니다.</h3>
  <!-- <DataBinding></DataBinding> -->
  <!-- <ConditionRender /> -->
  <!-- <Iterable /> -->
  <!-- <Class></Class> -->
  <!-- <Reactive /> -->
  <!-- <Compute /> -->
  <Watch />
</template>

<style scoped>
h1 {
  font-size: 30px;
  color: blue;
}
input {
  padding: 10px;
  font-size: 16px;
  margin-top: 10px;
}
</style>
