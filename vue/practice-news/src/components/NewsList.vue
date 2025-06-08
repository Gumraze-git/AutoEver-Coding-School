<script setup>
import NewsItem from "./NewsItem.vue";

const props = defineProps({
  news: Array,
  categorySelected: String,
});
</script>

<template>
  <div class="contents-box">
    <div class="contents" v-for="(item, index) in news" :key="item.title">
      <NewsItem :item="item" />
    </div>
  </div>
</template>

<style scoped>
.contents-box {
  box-sizing: border-box;
  background-color: #f5f5f5;
  width: 100%;
  padding: 24px;
  padding-bottom: 12px;
  margin-top: 16px;
  border-radius: 10px;
  flex-wrap: wrap;
  max-height: 450px;
  overflow-y: auto;
}

.contents {
  padding: 16px;
  border-radius: 10px;
  background-color: #fff;
  border: 1px solid #e0e0e0;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
  margin-bottom: 16px;
  transition: transform 0.2s ease, box-shadow 0.2s ease;
}

.contents:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
}
</style>
