<script setup>
const props = defineProps({
  user: {
    type: Object,
    required: true,
  },
});
</script>

<template>
  <div>
    <h2>사용자 목록</h2>
    <div v-for="(user, index) in user.list" :key="index" class="user-card">
      <p>이름: {{ user.name }}</p>
      <p>나이: {{ user.age }}</p>
      <p>주소: {{ user.address }}</p>
      <p :class="user.isAdult ? 'is-adult' : 'is-minor'">
        성인 여부: {{ user.isAdult ? "성인" : "미성년자" }}
      </p>
    </div>
  </div>
</template>

<style scoped>
.user-card {
  border: 1px solid #ccc;
  border-radius: 8px;
  padding: 1rem;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
  background-color: #fff;
  transition: transform 0.2s;
}

.user-card:hover {
  transform: scale(1.02);
}

.user-card p {
  margin: 0.3rem 0;
  font-size: 14px;
}

.is-adult {
  color: green;
  font-weight: bold;
}

.is-minor {
  color: #d9534f;
  font-weight: bold;
}
</style>
