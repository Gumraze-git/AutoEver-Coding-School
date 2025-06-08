// 두 개의 주사위를 굴려서 같은 값이 나오면 무인도 탈출

const prompt = require("prompt-sync")();

/* let result = [];

for (let i = 0; i < 2; i++) {
  const randomValue = parseInt(Math.random() * 6) + 1
  result.push(randomValue)
}
console.log(result)

if (result[0] == result[1]) {
  console.log("무인도에서 탈출 했습니다.")
} else {
  console.log("탈출에 실패했습니다.")
} */

// 객체의 키 값 기분 순회
const person = {
  name: "안유진",
  age: 23,
  isAdult: true
}

for(const key in person) {
  console.log(person[key])
}