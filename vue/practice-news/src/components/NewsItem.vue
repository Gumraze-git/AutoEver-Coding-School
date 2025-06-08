<script setup>
const props = defineProps({
  item: Array,
});
</script>
<template>
  <div class="container">
    <div class="image-box">
      <p>Image 준비중</p>
    </div>
    <div class="contents-box">
      <div class="title">
        <h2>{{ item.title }}</h2>
        <p>{{ item.date }}</p>
      </div>
      <div class="contents">
        <p>{{ item.content }}</p>
      </div>
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
}

.contents-box {
  margin-left: 10px;
}

.image-box {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 200px;
  border: 1px solid rgba(0, 0, 0, 0.2);
  border-radius: 8px;
}

.title {
  display: flex;
  flex-direction: column;
  font-size: 14px;
  font-weight: 500;
  color: #333;
  margin-bottom: 8px;
  width: 100%;
}

.title h2,
p {
  display: flex;
  justify-content: left;
  padding-left: 8px;
}

.title h2 {
  font-size: 18px;
  font-weight: bold;
  margin: 0;
}

.title p {
  font-size: 12px;
  margin: 0;
}

.contents {
  font-size: 14px;
  line-height: 1.6;
  border-radius: 8px;
}

.contents p {
  margin: 0;
  color: #444;
}
</style>
