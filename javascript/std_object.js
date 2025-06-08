// string 객체
// 특정 문자열 포함 여부: includes(), indexOf()
const email = "galaxydh@naver.com"

if (!email.includes("@")) { // includes
  console.log("올바른 이메일을 입력하세요.")
} else {
  console.log(`이메일: ${email}`)
}

if (email.indexOf("@") === -1) {
  console.log("올바른 이메일 형식이 아닙니다.")
} else {
  console.log(`골뱅이의 위치는: ${email.indexOf("@")} 입니다.`)
}


// 슬라이싱
// slice(start, end)
let str = "Apple, Banana, Kiwi";
let res = str.slice(7, 13);
console.log(res)

// substring(start, end): 파라미터로 음수를 허용하지 않음.
let res2 = str.substring(1, 4)
console.log(res2);

// 문자열 결합
let text = "안녕하세요"
text += "오늘은"
text += " 날씨가 좋지 않네요."
console.log(text)

const text1 = "안녕하세요"
const text2 = text1.concat("오늘은 ")
const text3 = text2.concat("날씨가 좋지 않네요.")
console.log(text3)

// map
const numbers = [1, 2, 3, 4, 5, 6];

const squaredNumbers = numbers.map(function (number) {
  return number * number
})

console.log(squaredNumbers)

// forEach: ES5에서 도입, 배열의 각 요소에 대한 반복 수행
const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
nums.forEach((num => {
  console.log(num);
}))

// map(): ES5에서 도입 배열의 각 요소를 변형하여 새로운 배열을 만든다.
// React에서 map이 핵심임.
const doubled = numbers.map(num => num * 2)
console.log(doubled)

// filter(): ES5에서 도입. 조건에 맞는 요소만 추출하여 새로운 배열 생성.
const evenNum = nums.filter(num => num % 2 ===0)
console.log(evenNum)

// reduce(): ES6에서 도입. 
const sum = nums.reduce((a, b) => a + b, 0)
console.log(sum)


