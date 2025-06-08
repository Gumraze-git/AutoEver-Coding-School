// 변수 이름: camelCase
let userName = "안유진";
let _score = 100;
let $value = 50;
/* let 1val = 1; */ // 숫자가 앞에 오는 것은 허용되지 않음

// 변수와 상수
// let: 변수 선언 시 사용, 블록 스코프, ES6(최신 문법임)
// const: 상수 선언 시 사용, 재할당 불가
// var: 예전 방식, 사용 금지, 호이스팅이 일어남

console.log(temp);
var temp = 100;
// undefined가 출력되며, 에러가 발생하지 않음.
// var은 변수가 선언되면 var temp만 최상단에 올려서 실행함.
// 따라서 아래와 같은 코드와 동일함.
var temp
console.log(temp)
temp = 100;


// 템플릿 문자열: ES6에서 추가된 문법
// 문자열
const name = "장원영";
/* const age = 22; */
const addr = "서울시 강남구 역삼동"

// JS는 문자열을 출력할 때, 큰 따옴표와 작은 따옴표를 구분하지 않음. 그리고 백틱도 가능함.
/* console.log(`이름: ${name}\n나이: ${age}\n주소: ${addr}`) */

// 숫자형(number): 정수와 실수형을 포함해서 숫자형으로 취급
console.log(0.1 + 0.2);

// 논리형(boolean): 참과 거짓으로 값을 표현
console.log(Boolean(10));     // true
console.log(Boolean(0));      // false
console.log(Boolean(""));     // false
console.log(Boolean(" "));    // true
console.log(Boolean(0.0001)); // true
console.log(Boolean(undefined)); // false
console.log(Boolean(null)); // false
console.log(Boolean(NaN)); // false

// 객체와 배열
// 배열(array): 동일한 데이터 타입이 연속된 공간에 저장되는 방식, 인덱스를 가지고 값을 찾는 방식
const arr1 = ["아이브", "안유진", 23, true, [100, 99, 56], ["대전시", "수원시", "서울시"], { "position": "리더"}];

// 배열 슬라이싱
console.log(arr1)
console.log(arr1[1])
console.log(arr1[5][0])
console.log(arr1[5][0][1])
console.log(arr1[6]["position"])

// 객체: key-value로 구성되어 있는 형태
const person = {
  name: "민지",
  addr: {
    city: "서울시",
    gu: "강남구",
    dong: "역삼동" 
  }
};

console.log(person)
console.log(person.name)
console.log(person.addr)
console.log(person.addr.city)

// 객체는 객체 타입임: 객체 타입은 참조 타입으로 주소를 참조하는 타입이다.
const person1 = person; // 주소에 대한 참조 복사
person1.name = "하니"
person1.addr.city = "태국"
console.log(person.name)
console.log(person1.name)

// 연산자(operator): 변수나 값에 대해 계산, 비교, 논리 연산 등을 수행하는 기호 또는 구문
// 연산사의 종류: 산술, 대입, 증감, 비교, 논리, 3항, 비트, 전개
let a = 10
let b = 4

console.log(a ** 3)
// 몫 계산
console.log(parseInt(a / b)) // 몫을 구하기 위해서 정수로 형 변환
console.log(Math.floor(a / b)) // 몫을 구하기 위해서 소수점 이하를 날림.

// 증감 연산자
console.log(++a)
console.log(++a)

// 대입 연산자
let c = 10;
console.log(c += 2); // 복합 대입 연산자
console.log(c -= 2); // 10
console.log(c *= 2); // 20
console.log(c /= 2); // 10
console.log(c %= 2); // 0

// 비교 연산자
console.log(100 == "100"); // 결과: true
console.log(100 === "100") // 동등 비교 연산자(값, 타입)을 사용하면 false가 나온다.

// 3항 연산자
const age = 18;
console.log(`당신은 ${age > 19 ? "성인" : "미성년자"}입니다.`)

// 형변환: 정해진 타입을 다른 타입으로 변경하는 것
// 형변환은 묵시적 형 변환과 명시적 형 변환이 있다.

const rst = 100 + 3.14
console.log(typeof rst) // number 타입(정수, 실수)로 출력된다.
console.log(10 + 10 + "10"); // 10 + 10 = 20, 20 + "10"으로 문자열로 변환되어 2010이 출력된다. 이를 묵시적 형변환이라 한다.

