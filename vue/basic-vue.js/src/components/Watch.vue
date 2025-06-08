<template>
  <div style="padding: 2rem">
    <h2>watch() 예제</h2>
    <!-- v-model은 양방향 바인딩을 가능하게 함. -->
    <input v-model="search" placeholder="검색어 입력" />
    <input v-model="test" placeholder="검증용 입력" />
    <p>입력값은: {{ search }}입니다.</p>
    <p>최근 검색어: {{ recent }}</p>
  </div>
</template>

<script setup>
import { ref, watch } from "vue";
const search = ref("");
const recent = ref("");
const test = ref("");

// watch는 상태 변화를 감지 후 특정 로직을 수행하는 역할을 한다.
watch(search, (newVal, oldVal) => {
  console.log(`검색어 변경: ${oldVal} -> ${newVal}`);
  recent.value = newVal;
  // 다음 동작
  // 서버와의 비동기 통신이 주로 이루어짐. async ~ await 방식
  // await를 통해서 결과가 수신되면 결과를 ref나 reactive로 만들어진 변수나
});
</script>

<style scoped>
input {
  padding: 8px;
  width: 200px;
  margin-bottom: 1rem;
}

p {
  font-size: 20px;
  margin: 4px 0px;
}
</style>
