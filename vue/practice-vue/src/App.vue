<script setup>
/* CardView 예제 */
/* import CardView from "./components/CardView.vue";
import { ref, reactive } from "vue";
const inputName = ref("");
const job = ref("");
const age = ref(0);
const member = reactive({
  name: "",
  job: "",
  age: 0,
}); */

/* InspectAdult 예제 */
/* import InspectAdult from "./components/InspectAdult.vue";
import { reactive } from "vue";

const users = reactive({
  list: [
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
  ],
}); */

/* UserCard 예제 */
/* import UserCard from "./pages/UserCard.vue"; */

/* Emit 예제 */
/* import ChildComponent from "./components/ChildComponent.vue";
import { ref } from "vue";

const message = ref("");
const handle = (payload) => {
  message.value = payload;
}; */

/* 이벤트 핸들러 예제 */
/* import EventRef from "./components/EventRef.vue"; */

/* 이벤트 핸들러 예제 2 */
/* import EventHandler from "./components/EventHandler.vue"; */

/* 셀렉트 박스 예제 */
// import SelectBox from "./components/SelectBox.vue";

/* 라디오 버튼 예제 */
/* import RadioBtn from "./components/RadioBtn.vue"; */

/* v-for를 이용한 배열 반복 렌더링 */
/* import ArrayRandom from "./components/ArrayRandom.vue"; */

/* 반응형 todo list */
import ReactiveTodo from "./components/ReactiveTodo.vue";
</script>

<template>
  <!-- CardView 예제 -->
  <!-- 아래와 같이 작성도 가능하다. -->
  <!-- <CardView name="장원영" job="프론트엔드 개발자" age="22" /> -->
  <!-- <input v-model="inputName" placeholder="이름 입력" /><br />
  <input v-model="job" placeholder="직업 입력" /><br />
  <input v-model.number="age" placeholder="나이" /><br />
  <CardView :name="inputName" :job="job" :age="age" /> -->

  <!-- 객체(reactive) 자체를 넘기는 것도 가능하다. -->
  <!-- <CardView :user="member" /> -->

  <!-- InspectAdult 예제 -->
  <!-- <InspectAdult :user="users" /> -->

  <!-- UserCard 예제 -->
  <!-- <UserCard /> -->

  <!-- emit 예제 -->
  <!-- <h2>부모 컴포넌트</h2>
  <p>자식에게 받은 메시지: {{ message }}</p>
  <ChildComponent @send-message="handle" /> -->

  <!-- 이벤트 핸들러 예제 -->
  <!-- <EventRef /> -->

  <!-- 이벤트 핸들러 예제 2 -->
  <!-- <EventHandler /> -->

  <!-- 셀렉트 박스 예제 -->
  <!-- <SelectBox /> -->

  <!-- 라디오 버튼 예제 -->
  <!-- <RadioBtn /> -->

  <!-- v-for를 이용한 배열 반복 렌더링 -->
  <!-- <ArrayRandom /> -->

  <!-- 반응형 todo list -->
  <ReactiveTodo />
</template>

<style scoped></style>
