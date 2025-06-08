const prompt = require("prompt-sync")();

let num = Number(prompt("정수 입력: "));

// if 조건문
if (num > 100) {
  console.log(`${num}은 100 초과입니다.`)
} else if(num === 100) {
  console.log(`${num}은 100과 동일합니다.`)
} else{
  console.log(`${num}은 100 미만입니다.`)
}

// swich 조건문: 조건식이 아니라 조건 값이 와야함.
let day = new Date().getDay();
console.log(day)

switch (day) {
  case 0:
    console.log("일요일")
    break;
  case 1:
    console.log("월요일")
    break;
  case 2:
    console.log("화요일")
    break;
  case 3:
    console.log("수요일")
    break;
  case 4:
    console.log("목요일")
    break;
  case 5:
    console.log("금요일")
    break;
  case 6:
    console.log("토요일")
    break;
  default:
    console.log("디폴트")
    break;
}

// 요일 출력과 같은 경우에는 배열을 이용하는 것이 더 간단함.
const dayStr = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"]
console.log(dayStr[day]);