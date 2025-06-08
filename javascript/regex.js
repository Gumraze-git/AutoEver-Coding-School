// test(): 문자열에서 정규 표현식과 일치하는 부분이 있는지 확인하는 메서드

const regExp = /World/;
console.log(regExp.test("Hello World")); // true
console.log(regExp.test("Hello")); // false


// exec(): 문자열에서 정규 표현식과 일치하는 부분을 찾는 메서드
const regExp2 = /(\w+)\s(\w+)/;
const str = "Hello World";

// match(): 문자열에서 패턴에 일치하는 모든 결과를 배열로 변한
const phone = "010-1234-5678 010-5419-6417 010-234124-2222"
const regNum = phone.match(/\d{3}-\d{4}-\d{4}/g);

console.log(regNum)

// 웹 사이트 주소 찾기
const urlReg = /https?:\/\/[\w\-\.]+/g

const urls = "http://naver.com https://google.co.kr, http://figma.ko-kr"
const checkUrls = urls.match(urlReg)
console.log(checkUrls)


// 이메일 검사하기
