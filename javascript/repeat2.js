// prompt 선언
const prompt = require("prompt-sync")();

// Data
let productList = [
  { name: "레쓰비", price: 700 },
  { name: "티오피", price: 1000 },
  { name: "비타500", price: 800 },
  { name: "포카리스웨트", price: 1000 },
  { name: "파워에이드", price: 1200 }
];

// 구매 가능한 제품 목록 출력
// 전통적인 for문 순회
// for .. of
// filter를 사용하는 방법

const input = Number(prompt("금액을 투입하여 주십시오"));
console.log(`투입 금액은 ${input}원 입니다.`)

// 전통적인 for문 방식
console.log("=====전통적인 for문 순회 방식=====");
console.log("구입 가능한 상품은 다음과 같습니다.")
for (let i = 0; i < productList.length; i++) {
  if (productList[i].price <= input) {
    console.log(`${productList[i].name}: \t${productList[i].price}원`); 
  }
}

// for .. of
console.log("=====for .. of 방식=====");
console.log("구입 가능한 상품은 다음과 같습니다.")
for (prod of productList) {
  if (prod.price <= input) {
    console.log(`${prod.name}: \t${prod.price}원`)
  }
}

// filter
console.log("=====filter=====");
console.log("구입 가능한 상품은 다음과 같습니다.")
productList
  .filter((e) => e.price <= input)
  .forEach((e) => console.log(`${e.name}: \t${e.price}`))


// Math.random(): 0 ~ 1 미만의 실수값 생성
// Math.random(): 


