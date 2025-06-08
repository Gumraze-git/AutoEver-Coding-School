<template>
  <ul>
    <li v-for="user in users" :key="user.id">
      <p>이름: {{ user.userName }}</p>
      <p>이메일: {{ user.email }}</p>
    </li>
  </ul>
</template>

<script setup>
const users = [
  { id: 1, userName: "지훈", email: "a@a.com" },
  { id: 2, userName: "민수", email: "b@b.com" },
  { id: 3, userName: "서연", email: "c@c.com" },
  { id: 4, userName: "현우", email: "d@d.com" },
  { id: 5, userName: "수빈", email: "e@e.com" },
  { id: 6, userName: "예진", email: "f@f.com" },
  { id: 7, userName: "도윤", email: "g@g.com" },
];
</script>

<style scoped>
li {
  list-style: none;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  margin-bottom: 16px;
  padding: 16px;
  border-radius: 8px;
  background: #fff;
}

p {
  margin: 0;
}
</style>
