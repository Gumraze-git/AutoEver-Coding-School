<template>
  <h2>{{ message }}</h2>
  <h2>{{ refName }}</h2>
  <h2>{{ name }}</h2>
  <input :value="refName" @input="updateName($event)" />
</template>

<script setup>
// ref는 원시 값을 감싸는 반응형 warper이다. 따라서 변경이 일어나면 화면을 다시 그려준다.
// vue의 모듈에서 ref를 가져옵니다.
// {}, 중괄호가 있으면 모듈에서 특정한 것만 가져온다는 의미이다.
import { ref } from "vue";
const message = ref("Hello Vue 3!");
const refName = ref("Wonyoung Jang");
let name = "Yujin An";

const updateName = (e) => {
  refName.value = e.target.value;
};
</script>

<style scoped>
/* Your styles here */
</style>
