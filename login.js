// 로그인 버튼 객체
const loginBtn = document.querySelector("#login")

// email, password 객체
const email = document.querySelector("#email")
const password = document.querySelector("#password")

// input 필드에 값이 있는 경우에만 버튼을 활성화
function checkInput() {
  loginBtn.disabled = !(email.value && password.value);
}

email.addEventListener("input", checkInput)
password.addEventListener("input", checkInput)


// 로그인 버튼 클릭 시, localStorage에서 값 검사.
// 1. ID가 일치하지 않는 경우 -> "ID가 일치하지 않거나, 회원 정보가 없습니다." 출력
// 2. Password가 일치하지 않는 경우 -> "비밀번호가 일치하지 않습니다." 출력
loginBtn.addEventListener("click", () => {
  const localEmail = localStorage.getItem("email")
  const localPassword = localStorage.getItem("password")
  
  if (!localEmail === email.value) {
    alert("이메일이 일치하지 않거나, 회원정보가 없습니다.")
    window.location.href = "login.html"; // 리디렉션 수행
  } else if (localEmail === email.value && !localPassword === password.value) {
    alert("비밀번호가 일치하지 않습니다.")
    window.location.href = "login.html"; // 리디렉션 수행
  } else {
    alert("성공적으로 로그인 되었습니다.")
    window.location.href = "index.html"; // 메인 페이지로 이동
  }
})