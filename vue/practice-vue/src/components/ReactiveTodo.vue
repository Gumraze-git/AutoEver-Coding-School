<script setup>
import { ref, watch } from "vue";

const stored = localStorage.getItem("users");
const storedNextId = localStorage.getItem("nextId");

const users = ref(
  stored
    ? JSON.parse(stored)
    : [
        { id: 1, todo: "HTML" },
        { id: 2, todo: "CSS" },
        { id: 3, todo: "JavaScript" },
        { id: 4, todo: "Vue" },
        { id: 5, todo: "React" },
      ]
);

const nextId = ref(
  storedNextId ? Number(storedNextId) : users.value.length + 1
);

const inputText = ref("");

const addToDo = () => {
  if (!inputText.value.trim()) return;
  users.value.push({ id: nextId.value++, todo: inputText.value });
  inputText.value = "";
};

const deleteTodo = (id) => {
  users.value = users.value.filter((user) => user.id !== id);
};

watch(
  users,
  (newVal) => {
    localStorage.setItem("users", JSON.stringify(newVal));
  },
  { deep: true }
);

watch(nextId, (val) => {
  localStorage.setItem("nextId", val.toString());
});
</script>

<template>
  <input v-model="inputText" />
  <button @click="addToDo">추가</button>

  <ul>
    <li v-for="user in users" :key="user.id">
      {{ user.todo }}
      <button @click="deleteTodo(user.id)">삭제</button>
    </li>
  </ul>
</template>

<style scoped></style>
