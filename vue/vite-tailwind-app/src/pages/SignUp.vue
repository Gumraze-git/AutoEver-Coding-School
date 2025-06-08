<script setup>
import axios from "axios";
import { ref, watch, reactive, computed } from "vue";
import BaseInput from "../components/base/BaseInput.vue";
import Button from "../components/base/BaseButton.vue";
import { useRouter } from "vue-router";
import { useAuthApi } from "../api/auth";

// useAuthApi에서 2가지로 구조분해
const { signUp, exists } = useAuthApi();

// 정규 표현식
// const emailReg = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
// const passwordReg =
//   /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
// const phoneReg = /^\d{2,3}-\d{3,4}-\d{4}$/;

// 테스트용 정규 표현식
const emailReg = /.*/;
const passwordReg = /.*/;
const phoneReg = /.*/;

// 이메일, 패스워드, 핸드폰, 버튼 객체
const member = reactive({
  name: "",
  email: "",
  password: "",
  passwordCheck: "",
  number: 0,
});

const foundUser = ref(null);
const userList = ref([]);
const emailValidationStatus = ref(null);

const validateEmail = async (val) => {
  member.email = val;

  if (val === "") {
    emailValidationStatus.value = null;
    return;
  }

  // 1. 정규식 검사 먼저
  if (!emailReg.test(val)) {
    emailValidationStatus.value = "invalid";
    return;
  }

  // 2. 서버에 요청하여 중복 확인
  const submit = async () => {
    const response = await signUp(form.email, form.password, form.name);

    if (response.data) {
      router.push("/");
    } else {
      alert("회원 가입에 실패했습니다.");
    }
  };

  try {
    const response = await axios.get("http://222.117.237.119:8111/users/list");
    userList.value = response.data;

    foundUser.value = userList.value.find((user) => user.email === val);
    console.log("유저 리스트:", userList.value);
    console.log("찾은 유저:", foundUser.value);

    emailValidationStatus.value = foundUser.value ? "duplicate" : "valid";
  } catch (error) {
    console.error("데이터 요청 중 오류 발생", error);
    // 중복 확인 실패 시 invalid로 처리하거나 별도 상태 사용 가능
    emailValidationStatus.value = "invalid";
  }
};

// 유효성 검사
const inspectEmail = computed(() => {
  return emailReg.test(member.email) && !foundUser.value;
});
const inspectPassword = computed(() => passwordReg.test(member.password));
const inspectPasswordDubble = computed(
  () =>
    member.password === member.passwordCheck && member.passwordCheck.length > 1
);
const inspectPhone = computed(() => phoneReg.test(member.number));

// 버튼 활성화
const isFormValid = computed(
  () =>
    inspectEmail.value &&
    inspectPassword.value &&
    inspectPasswordDubble.value &&
    inspectPhone.value
);

/* const handleSubmit = async () => {
  try {
    const payload = {
      email: member.email,
      pwd: member.password,
      name: member.name,
    };
    const res = await axios.post(
      "http://222.117.237.119:8111/auth/signup",
      payload
    );
    if (res.data) {
      alert("회원 가입 성공");
      router.push("/login");
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
}; */
</script>

<template>
  <main class="flex justify-center items-center w-screen h-screen">
    <div class="flex flex-col justify-center items-center">
      <h2
        class="mb-4 flex justify-center items-center font-normal mt-0 text-[30px]"
      >
        회원가입 페이지
      </h2>
      <div class="flex flex-col">
        <BaseInput
          v-model="member.name"
          class="mb-4"
          type="text"
          id="name"
          placeHolder="NAME"
        />
        <BaseInput
          v-model="member.email"
          :validMessage="true"
          @update:model-value="validateEmail"
          :validDup="emailValidationStatus"
          type="text"
          id="email"
          placeHolder="EMAIL"
        />
        <BaseInput
          v-model="member.password"
          :validMessage="true"
          :validDup="inspectPassword"
          type="password"
          id="password"
          placeHolder="PASSWORD"
        />
        <BaseInput
          v-model="member.passwordCheck"
          :validMessage="true"
          :valid-dup="inspectPasswordDubble"
          type="password"
          id="passwordValidation"
          placeHolder="PASSWORD CHECK"
        />
        <BaseInput
          v-model="member.number"
          :validMessage="true"
          :validDup="inspectPhone"
          type="text"
          id="number"
          placeHolder="PHONE NUMBER"
        />
        <Button
          class="mt-4"
          :disabled="!isFormValid"
          :input="'ADMIT'"
          @click="handleSubmit"
        />
      </div>
    </div>
  </main>
</template>
<style scoped></style>
