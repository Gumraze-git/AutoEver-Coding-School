<script setup>
import { ref } from "vue";
import BaseInput from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import BaseCard from "../components/base/BaseCard.vue";
import { useThemeStore } from "@/stores/theme";
import { useUserStore } from "@/stores/userInfo";

const userStore = useUserStore();
const themeStore = useThemeStore();
const setColor = themeStore.setColor;
const colors = ["orange", "green", "lightgrey", "grey", "royalblue"];
const searchValue = ref("");
</script>
<template>
  <div class="flex flex-col justify-center content-center">
    <div v-if="userStore.name" class="flex flex-col justify-center mb-[20px]">
      <h2 class="flex justify-center mb-[30px] text-2xl font-bold">
        {{ userStore.name }}님 반갑습니다.
      </h2>
      <div v-if="userStore.name" class="flex justify-center">
        <BaseCard :user="userStore" />
      </div>
    </div>

    <div class="flex justify-center mb-4 border-t-4 pt-10">
      <h2 class="text-3xl font-bold">프로필 검색</h2>
    </div>
    <div class="flex flex-col mb-10 justify-center">
      <div class="flex justify-center">
        <BaseInput
          v-model="searchValue"
          class="h-[50px]"
          placeHolder="Search Profile"
        />
        <BaseButton
          class="w-[70px] ml-[5px] h-[50px] text-opacity-80"
          input="Search"
        ></BaseButton>
      </div>
      <h3>test 입니다, :{{ searchValue }}</h3>
    </div>
    <div class="flex justify-center border-t-4">
      <div class="p-6 space-y-6">
        <h1 class="text-xl font-bold">🎨 테마 색상 선택</h1>
        <div class="flex gap-3 flex-wrap">
          <button
            v-for="c in colors"
            :key="c"
            @click="setColor(c)"
            :style="{ backgroundColor: c }"
            class="px-4 py-2 rounded text-white font-bold shadow"
          >
            {{ c }}
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
