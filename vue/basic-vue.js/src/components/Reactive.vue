<script setup>
// vue 모듈에서 reative 패키지를 가져옴. 이를 구조분해라고 함
import { reactive } from "vue";

const member = reactive({
  // reactive로 감싸주면 아래 값들이 바뀌면 re-rendering을 해줌.
  name: "Wonyoung Jang",
  age: 22,
  addr: "Seoul",
  position: "center",
});
</script>

<template>
  <div>
    <h2>사용자 정보</h2>
    <p>이름 {{ member.name }}</p>
    <p>나이 {{ member.age }}</p>
    <p>주소 {{ member.addr }}</p>
    <p>위치 {{ member.center }}</p>

    <!-- input의 값이 들어오면 렌더링이 발생함. -->
    <input v-model="member.name" placeholder="이름 입력" />
    <br />
    <input type="number" v-model="member.age" placeholder="나이 입력" />
    <br />
    <input v-model="member.addr" placeholder="주소 입력" />
    <br />
    <input v-model="member.position" placeholder="위치 입력" />
  </div>
</template>
