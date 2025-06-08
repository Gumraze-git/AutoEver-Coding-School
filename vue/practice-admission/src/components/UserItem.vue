<script setup>
import dayjs from "dayjs";
import relativeTime from "dayjs/plugin/relativeTime";
import "dayjs/locale/ko";

// 날짜 변환
dayjs.extend(relativeTime);
dayjs.locale("ko");

const props = defineProps({
  user: Object,
});
</script>

<template>
  <div class="container">
    <div class="image">
      <h3>이미지 준비중</h3>
    </div>
    <div>
      <p class="name">{{ user.name }}</p>
      <p class="email">{{ user.email }}</p>
      <p class="regDate">{{ dayjs(user.regDate).fromNow() }}</p>
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  align-items: center;
  gap: 20px;
  width: 420px;
  min-height: 100px;
  background: #fff;
  border-radius: 16px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.07);
  padding: 20px 28px;
  margin-bottom: 18px;
  transition: box-shadow 0.2s;
}

.container:hover {
  box-shadow: 0 4px 16px rgba(0, 0, 0, 0.12);
}

.image {
  background: linear-gradient(135deg, #f5f6fa 60%, #e1e8ed 100%);
  border-radius: 12px;
  width: 72px;
  height: 72px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 15px;
  color: #888;
  font-weight: 500;
  flex-shrink: 0;
}

.name {
  font-size: 1.15rem;
  font-weight: 600;
  color: #222;
  margin-bottom: 4px;
}

.email {
  font-size: 0.97rem;
  color: #666;
  margin-bottom: 4px;
}

.regDate {
  font-size: 0.88rem;
  color: #b0b0b0;
}

p {
  margin: 0;
}
</style>
