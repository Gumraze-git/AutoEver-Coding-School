/* 
반복문: 조건이 참인 동안 반복을 수행하는 구문
for, while, do-while문이 있음.
for문: for(초기값; 최종값; 증감값;), for .. in(키 값 순회), for .. of(iterable 객체 반복)
do-while: 
*/

const prompt = require("prompt-sync")()
/* let num = Number(prompt("정수 입력: ")) */

// 입력 받은 정수 범위의 합을 구하기
/* let sum = 0; // initial value */
/* while (num) {
  sum += num;
  num--;
}

console.log(sum) */


// for문
/* let sumTwo = 0;
for(let i = 1; i <= num; i++) {
  sumTwo += i;
}
console.log(sumTwo) */

// while문 사용 예제
/* let age = 0; // age를 전역 변수로 먼저 선언해야함.

while (true) {
  age = Number(prompt("나이를 입력하세요: ")); // 블록 안에서 선언되면 블록이 끝나면 소멸되어버림.
  if (age >= 0 && age <=200) break;
  console.log("나이를 잘 못 입력 하셨습니다.")
}
console.log(`당신의 나이는 ${age}입니다.`)

 */

// for문
const cars = ["모델 Y", "G80", "그랜저", "산타페", "코나"]

for (let car in cars) {
  if (car == 0) continue // 첫 번째 건너뛰기
  console.log(car)
}

for (let car of cars.slice(1)) { // 첫 번째 건너뛰기
  console.log(car)
}