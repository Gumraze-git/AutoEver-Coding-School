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
  <div
    class="flex items-center gap-3 w-[480px] min-h-[100px] bg-white rounded-xl shadow-md py-5 px-5 mb-[18px]"
  >
    <div
      class="border rounded-[8px] w-[82px] h-[82px] flex justify-center items-center text-[12px] text-[#888] font-medium shrink-0"
    >
      <h3>이미지 준비중</h3>
    </div>
    <div class="flex flex-col">
      <p class="flex text-[1.15rem] font-semibold text[#222] mb-1">
        {{ user.name }}
      </p>
      <p class="flex text-[0.96rem] text-[#666] mb-1">{{ user.email }}</p>
      <p class="flex text-[0.88rem] text-[#b0b0b0]">
        {{ dayjs(user.regDate).fromNow() }}
      </p>
    </div>
  </div>
</template>
