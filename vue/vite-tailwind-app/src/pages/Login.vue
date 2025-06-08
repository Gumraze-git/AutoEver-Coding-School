<script setup>
import { ref } from "vue";
import axios from "axios";
import InputField from "../components/base/BaseInput.vue";
import BaseButton from "../components/base/BaseButton.vue";
import { useRoute, useRouter } from "vue-router";
import { useModalState } from "../stores/modal";

// 로그인 상태 관리
import { useUserStore } from "../stores/userInfo";
const userStore = useUserStore();
const modal = useModalState();

const email = ref("");
const password = ref("");
const userList = ref([]);
const router = useRouter();

const login = async () => {
  try {
    // 엑시오스를 통해 데이터 송신
    const response = await axios.get("http://222.117.237.119:8111/users/list");
    userList.value = response.data;

    // userList에서 입력된 데이터 find
    const foundUser = userList.value.find(
      (user) => user.email === email.value && user.pwd === password.value
    );
    console.log(`foundUser 데이터 확인: ${foundUser.value}`);

    // foundUser가 true
    if (foundUser) {
      // Modal 창 Open
      modal.Open({
        title: "로그인 성공",
        message: `${email.value}로 성공적으로 로그인 했습니다.`,
        buttons: [
          {
            label: "확인",
            onClick: () => {
              modal.Close();
              router.push("/home");
            },
          },
          {
            label: "취소",
            onClick: () => {
              modal.Close();
              router.push("/home");
            },
          },
        ],
      });

      // 사용자 이름, 이메일 localStorage에 저장
      userStore.setUserInfo({
        name: foundUser.name,
        email: foundUser.email,
      });
    } else {
      modal.Open({
        title: "로그인 실패",
        message: "로그인 실패: 이메일 또는 비밀번호가 틀렸습니다.",
        buttons: [
          {
            label: "확인",
            onClick: () => router.push(""),
          },
        ],
      });
    }
  } catch (error) {
    console.error("데이터 요청 중 오류 발생", error);
  }
};
</script>

<template>
  <div class="flex flex-col items-center justify-center min-h-screen">
    <h2 class="text-2xl font-semibold mb-6">Login</h2>
    <div>
      <InputField
        v-model="email"
        class="mb-4"
        type="text"
        id="name"
        placeHolder="NAME"
      />
      <InputField
        v-model="password"
        class="mb-4"
        type="password"
        id="password"
        placeHolder="PASSWORD"
      />
      <BaseButton @click="login" class="mt-0" :input="'LOGIN'"></BaseButton>
    </div>

    <div class="mt-4">
      <router-link to="/signup" class="text-blue-600 hover:underline"
        >Sign</router-link
      >
    </div>
  </div>
</template>
