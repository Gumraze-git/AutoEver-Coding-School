<script setup>
import { ref, computed } from "vue";
import NewsCategory from "../components/NewsCategory.vue";
import NewsList from "../components/NewsList.vue";
import NewsItem from "../components/NewsItem.vue";

const allNews = [
  {
    title: "정치 뉴스 A",
    content: "정치 관련 내용입니다.",
    date: "2024-05-01",
    category: "정치",
  },
  {
    title: "경제 뉴스 A",
    content: "경제 관련 내용입니다.",
    date: "2024-05-02",
    category: "경제",
  },
  {
    title: "사회 뉴스 A",
    content: "사회 관련 내용입니다.",
    date: "2024-05-03",
    category: "사회",
  },
  {
    title: "문화 뉴스 A",
    content: "문화 관련 내용입니다.",
    date: "2024-05-04",
    category: "문화",
  },
  {
    title: "과학 뉴스 A",
    content: "과학 관련 내용입니다.",
    date: "2024-05-05",
    category: "과학",
  },
  {
    title: "정치 뉴스 B",
    content: "정치 뉴스 2건입니다.",
    date: "2024-05-06",
    category: "정치",
  },
  {
    title: "경제 뉴스 B",
    content: "경제 뉴스 2건입니다.",
    date: "2024-05-07",
    category: "경제",
  },
  {
    title: "사회 뉴스 B",
    content: "사회 뉴스 2건입니다.",
    date: "2024-05-08",
    category: "사회",
  },
  {
    title: "문화 뉴스 B",
    content: "문화 뉴스 2건입니다.",
    date: "2024-05-09",
    category: "문화",
  },
  {
    title: "과학 뉴스 B",
    content: "과학 뉴스 2건입니다.",
    date: "2024-05-10",
    category: "과학",
  },
  {
    title: "정치 뉴스 C",
    content: "정치 뉴스 3건입니다.",
    date: "2024-05-11",
    category: "정치",
  },
  {
    title: "경제 뉴스 C",
    content: "경제 뉴스 3건입니다.",
    date: "2024-05-12",
    category: "경제",
  },
  {
    title: "사회 뉴스 C",
    content: "사회 뉴스 3건입니다.",
    date: "2024-05-13",
    category: "사회",
  },
  {
    title: "문화 뉴스 C",
    content: "문화 뉴스 3건입니다.",
    date: "2024-05-14",
    category: "문화",
  },
  {
    title: "과학 뉴스 C",
    content: "과학 뉴스 3건입니다.",
    date: "2024-05-15",
    category: "과학",
  },
  {
    title: "정치 뉴스 D",
    content: "정치 뉴스 4건입니다.",
    date: "2024-05-16",
    category: "정치",
  },
  {
    title: "경제 뉴스 D",
    content: "경제 뉴스 4건입니다.",
    date: "2024-05-17",
    category: "경제",
  },
  {
    title: "사회 뉴스 D",
    content: "사회 뉴스 4건입니다.",
    date: "2024-05-18",
    category: "사회",
  },
  {
    title: "문화 뉴스 D",
    content: "문화 뉴스 4건입니다.",
    date: "2024-05-19",
    category: "문화",
  },
  {
    title: "과학 뉴스 D",
    content: "과학 뉴스 4건입니다.",
    date: "2024-05-20",
    category: "과학",
  },
];

const selected = ref("전체");

const selectCategory = (cate) => {
  selected.value = cate;
};

const filteredNews = computed(() => {
  return selected.value === "전체"
    ? allNews
    : allNews.filter((news) => news.category === selected.value);
});

const categoryList = computed(() => {
  const cats = allNews.map((news) => news.category);
  return ["전체", ...new Set(cats)];
});
</script>
<template>
  <div class="news-box">
    <NewsCategory :item="categoryList" @btn-state="selectCategory" />
    <NewsList :news="filteredNews" :category-selected="selected" />
  </div>
</template>

<style scoped>
.news-box {
  padding: 2rem;
  max-width: 700px;
  width: 100%;
  margin: 0 auto;
  background-color: #fdfdfd;
  border-radius: 12px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.06);
}
</style>
