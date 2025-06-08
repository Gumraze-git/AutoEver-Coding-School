// 전개 연산자
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

// concat으로 새로운 배열을 만들 수 있다.
const arr3 = arr1.concat(arr2)
console.log(arr3)

// 배열에서의 전개 연산자
const arr4 = [...arr1, ...arr2] // '...'은 펼친다라는 의미를 가진다.
console.log(arr4)

// 객체에서의 전개 연산자
const obj1 = {name: "장원영", age: 22}
const obj2 = {addr: "서울시 강남구", position: "센터"}

const obj3 = {...obj1, ...obj2, name: "안유진"} // 내부의 값은 유지하면서 특정한 값(name)만 변경할 수 있다.
console.log(obj3)

// 전개 연산자를 이용한 가변 인수 만들기
const sum = (...numbers) => {
  return numbers.reduce((a, b) => a + b, 0)
};

console.log(sum(1,23,2,4,2,52))
