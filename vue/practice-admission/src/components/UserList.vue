<script setup>
import { ref, onMounted } from "vue";
import axios from "axios";
import UserItem from "./UserItem.vue";

const userList = ref([]);

const getUserList = async () => {
  try {
    const response = await axios.get("http://222.117.237.119:8111/users/list");
    userList.value = response.data;
    console.log(response.data);
  } catch (error) {
    console.error("데이터 요청 중 오류 발생", error);
  }
};

onMounted(() => {
  getUserList();
});
</script>

<template>
  <div>
    <ul>
      <UserItem v-for="(user, index) in userList" :key="index" :user="user" />
    </ul>
  </div>
</template>

<style scoped></style>
