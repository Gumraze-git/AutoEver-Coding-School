<script setup>
import { reactive, onMounted } from "vue";
import UserItem from "../components/UserItem.vue";

const users = reactive([]);
const fetchedData = [
  // 서버에서 받아온 데이터
  { name: "김영희", age: 25, address: "서울시 강남구", isAdult: true },
  { name: "이철수", age: 17, address: "부산시 해운대구", isAdult: false },
  { name: "박민수", age: 30, address: "대전시 중구", isAdult: true },
  { name: "최지은", age: 19, address: "광주시 북구", isAdult: false },
  { name: "정우성", age: 45, address: "서울시 종로구", isAdult: true },
  { name: "한지민", age: 22, address: "경기도 수원시", isAdult: true },
  { name: "오세훈", age: 16, address: "인천시 계양구", isAdult: false },
  { name: "윤가은", age: 28, address: "울산시 남구", isAdult: true },
  { name: "배진수", age: 20, address: "대구시 수성구", isAdult: true },
  { name: "문지혜", age: 18, address: "제주시 애월읍", isAdult: false },
];

// 화면이 처음 나타나는 시점
onMounted(() => {
  // 서버로 데이터를 요청하고 데이터가 전달되면 아래의 동작을 수행한다.
  users.push(...fetchedData); // fetchedData가 users 배열에 한꺼번에 추가됨.
});
</script>

<template>
  <div class="container">
    <h2>회원 정보</h2>
    <UserItem v-for="user in users" :key="user.name" :user="user" />
  </div>
</template>

<style scoped>
.container {
  width: 500px;
  background-color: #ccc;
  border-radius: 8px;
  padding: 10px 10px;
}
</style>
