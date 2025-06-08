<script setup>
import { ref, reactive, computed, watch, onMounted } from "vue";

// ref, reactive 값이 변경되면 렌더링이 발생함.
const name = ref("");
const age = ref(0);

const isAdult = computed(() => {
  // 익명 함수는 현재 등록만 되어 있는 상태이고
  // 값이 변경 될 때에만 함수가 실행되는 것이다.
  // 불필요한 함수 호출을 방지, re-rendering시 함수 호출이 일어나지 않는 경우는
  return age.value >= 20;
});

// 나이 변화 추적
watch(
  () => age,
  (newAge, oldAge) => {
    console.log(`기존 나이: ${oldAge} -> 현재 나이 ${newAge}`);
  }
);

// 초기 실행
onMounted(() => {
  console.log("초기 마운트 실행입니다.");
});

// 제출 처리
const handleSubmit = () => {
  alert(`${name.value}님은 ${isAdult.value ? "성인" : "미성년자"}입니다.`);
};
</script>

<template>
  <div>
    <h2>이름과 나이를 입력하세요</h2>
    <input v-model="name" type="text" placeholder="사용자 이름" />
    <input v-model="age" type="number" placeholder="사용자 나이" />
  </div>

  <div>
    <h2>사용자 정보</h2>
    <p>이름:{{ name }}</p>
    <p>나이:{{ age }}</p>
    <div>현재 상태: {{ isAdult.valueOf ? "성인" : "미성년자" }}</div>
  </div>

  <button @click="handleSubmit">제출</button>
</template>

<style scoped>
input {
  padding: 2px;
  margin: 1rem;
  width: 200px;
  height: 30px;
}
</style>
