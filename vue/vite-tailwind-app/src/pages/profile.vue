<script setup>
import { useRoute } from "vue-router";
const route = useRoute();
const username = route.params.username;
</script>

<template>
  <div>
    <h1>프로필 페이지</h1>
    <p>사용자명: {{ username }}</p>
  </div>
</template>
