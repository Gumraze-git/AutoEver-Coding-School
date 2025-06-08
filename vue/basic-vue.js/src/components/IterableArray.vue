<template>
  <ul>
    <li v-for="item in items" :key="item.id">{{ item.name }}</li>
  </ul>
</template>

<script setup>
const items = [
  { id: 1, name: "React" },
  { id: 2, name: "Vue" },
  { id: 3, name: "Python" },
];
</script>
