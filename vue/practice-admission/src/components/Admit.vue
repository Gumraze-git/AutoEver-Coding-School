<script setup>
import axios from "axios";
import { reactive, computed } from "vue";

// 정규 표현식
const emailReg = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
const passwordReg =
  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
const phoneReg = /^\d{2,3}-\d{3,4}-\d{4}$/;

// 이메일, 패스워드, 핸드폰, 버튼 객체
const member = reactive({
  name: "",
  email: "",
  password: "",
  passwordCheck: "",
  number: 0,
});

// 유효성 검사
const inspectEmail = computed(() => emailReg.test(member.email));
const inspectPassword = computed(() => passwordReg.test(member.password));
const inspectPasswordCheck = computed(
  () =>
    member.password === member.passwordCheck && member.passwordCheck.length > 1
);
const inspectPhone = computed(() => phoneReg.test(member.number));

// 버튼 활성화
const isFormValid = computed(
  () =>
    inspectEmail.value &&
    inspectPassword.value &&
    inspectPasswordCheck.value &&
    inspectPhone.value
);

const handleSubmit = async () => {
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
    } else {
      alert("회원 가입 실패");
    }
  } catch (err) {
    console.error(err);
    alert("가입 실패! 서버 오류 발생");
  }
};
</script>

<template>
  <main>
    <div class="container">
      <h2>회원가입 페이지</h2>
      <div class="input-box">
        <div class="input-inner">
          <input
            v-model="member.name"
            type="text"
            id="email"
            placeholder="NAME"
          />
          <span> </span>

          <input
            v-model="member.email"
            type="text"
            id="email"
            placeholder="EMAIL"
          />
          <span :style="{ color: inspectEmail ? 'green' : 'red' }">{{
            inspectEmail ? "사용 가능 합니다." : "사용 불가 합니다."
          }}</span>
        </div>
        <div class="input-inner">
          <input
            v-model="member.password"
            type="password"
            id="password"
            placeholder="PASSWORD"
          />
          <span :style="{ color: inspectPassword ? 'green' : 'red' }">{{
            inspectEmail ? "사용 가능 합니다." : "사용 불가 합니다."
          }}</span>
        </div>
        <div class="input-inner">
          <input
            v-model="member.passwordCheck"
            type="password"
            id="password"
            placeholder="PASSWORD CHECK"
          />
          <span :style="{ color: inspectPasswordCheck ? 'green' : 'red' }">{{
            inspectEmail ? "사용 가능 합니다." : "사용 불가 합니다."
          }}</span>
        </div>
        <div class="input-inner">
          <input
            v-model="member.number"
            type="text"
            id="phone"
            placeholder="NUMBER"
          />
          <span :style="{ color: inspectPhone ? 'green' : 'red' }">{{
            inspectEmail ? "사용 가능 합니다." : "사용 불가 합니다."
          }}</span>
        </div>
        <!-- <button
          :disabled="!isFormValid"
          @click="handleSubmit"
          class="admission"
        >
          ADMIT
        </button> -->
        <button :disabled="!isFormValid" class="admission">ADMIT</button>
      </div>
    </div>
  </main>
  <footer>
    <p>Manage cookies or opt out</p>
  </footer>
</template>
<style scoped>
* {
  box-sizing: border-box;
  font-family: "Inter", "Noto Sans KR", sans-serif, Helvetica;
}

body {
  margin: 0;
  height: 100vh;
  display: flex;
  flex-direction: column;
}

main {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100vw;
  height: calc(100vh - 80px);
}

.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
}

h2 {
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: normal;
  margin-top: 0;
  font-size: 30px;
}

.input-box {
  display: flex;
  flex-direction: column;
  gap: 10px;
}

input {
  width: 400px;
  height: 50px;
  border-radius: 8px;
  border: none;
  background-color: rgb(239, 237, 237);
  transform: border 0.3s ease;
  padding-left: 12px;
  font-weight: 500;
  font-size: 18px;
}

input::placeholder {
  position: relative;
  bottom: 12px;
  right: 3px;
  color: black;
  font-size: 16px;
}

input:hover {
  border: 1px solid black;
}

.input-inner {
  display: grid;
  grid-template-columns: 400px;
  grid-template-rows: 50px 15px;
}

.input-inner > span {
  justify-self: end;
  color: red;
  font-size: 14px;
}

.admission {
  width: 400px;
  height: 50px;
  border: none;
  background-color: black;
  color: white;
  font-size: 18px;
  font-weight: 500;
  border-radius: 8px;
  margin-top: 20px;
  margin-bottom: 100px;
}

.admission:disabled {
  background-color: grey;
}

.ankers {
  display: flex;
  flex-direction: column;
}

.links {
  display: flex;
  padding-top: 20px;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

footer {
  width: 100%;
  display: flex;
  justify-content: center;
  color: grey;
  margin-top: 60px;
}
</style>
