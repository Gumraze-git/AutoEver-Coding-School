// 정규 표현식
const emailReg = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
const passwordReg = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
const phoneReg = /^\d{2,3}-\d{3,4}-\d{4}$/;

// 버튼 감지
const admitBtn = document.querySelector("#admit")

// 이메일, 패스워드, 핸드폰, 버튼 객체
const email = document.querySelector("#email")
const password = document.querySelector("#password")
const phone = document.querySelector("#phone")
const btn = document.querySelector("#admit")

// 유효성 검사
const inspectEmail = emailReg.test(email.value)
const inspectPassword = passwordReg.test(password.value)
const inspectPhone = phoneReg.test(phone.value)


function isValueValid(input, inspector) {
  const span = input.nextElementSibling;
  if (inspector.test(input.value)) {
    span.innerText = "사용 가능 합니다."
    span.style.color = "green"
    input.style.backgroundColor = "#E0F2FE"
    return true
  } else {
    span.innerText = "사용 불가 합니다."    
    span.style.color = "red"
    return false
  }
}

function updateSubmitBtn() {
  const isEmailValid = isValueValid(email, emailReg);
  const isPasswordValid = isValueValid(password, passwordReg);
  const isPhoneValid = isValueValid(phone, phoneReg);

  btn.disabled = !(isEmailValid && isPasswordValid && isPhoneValid);
}

email.addEventListener("input", updateSubmitBtn);
password.addEventListener("input", updateSubmitBtn);
phone.addEventListener("input", updateSubmitBtn);