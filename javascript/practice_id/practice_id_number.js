// 주민등록번호를 입력 받아 성별, 나이, 출력하기
/* 
new Date(): 운영체제로부터 날짜를 가져오는 내장 메서드
주민등록번호 입력 길이 체크
하이픈 포함 여부 체크(includes)
슬라이싱: slice(시작 인덱스, 종료 인덱스)
7번 인덱스가 1과 2면, 19xx년대 출생, 3과 4이면 20xx출생, 1과 3이면 남성, 2와 4면 여성
*/

/* let idNumber = prompt("주민등록번호를 입력하세요\n(예: 123456-1234567)") */
const prompt = require("prompt-sync")(); 
let idNumber = prompt("주민등록번호를 입력하세요");

// 입력 형식 검사
if (idNumber.includes("-") && idNumber.length === 14) {
  let birth = parseInt(idNumber.slice(0, 2));
  let gender = parseInt(idNumber[7]);
  let currentYear = new Date().getFullYear();

  // 나이
  let century = (gender === 1 || gender === 2) ? 1900 : 2000;
  let fullBirthYear = century + birth;
  let age = currentYear - fullBirthYear;

  // 성별
  let genderStr = (gender === 1 || gender === 3) ? "남성" : "여성";

  console.log(`출생년도: ${fullBirthYear}년`);
  console.log(`나이: ${age}세`);
  console.log(`성별: ${genderStr}`);
} else {
  console.log("형식에 맞게 다시 입력하세요");
}