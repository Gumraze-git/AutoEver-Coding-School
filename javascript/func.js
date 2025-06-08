// 함수: 특정 작업을 반복하거나 재사용할 수 있도록 작성된 코드
// 함수는 끌어올림(hoisting)이 가능해서 함수를 아래에 선언해도 됨.
// 함수는 호출을 해야 실행이 된다.

console.log(sum(1, 3))
console.log(sum(1.1, 2.2))
console.log(sum(1.1, "3.1"))
console.log(sum("아이브", "안유진"))

function sum(num1, num2) {
  return num1 + num2
}

// 함수 표현식
const mul = function(a, b) {
  return a * b;
}

console.log(mul(5, 3))

// 화살표 함수: 간결한 표현에 유리, 콜백 함수에서 익명의 함수를 사용하는 경우 주로 활용
const div = (a, b) => a / b;

// 즉시 실행 함수: 호출이 없어도 실행되는 함수
(function() {
  console.log("즉시 실행 함수 입니다.")
})();

// 기본값 할당
function summation(a, b, c = 300) {
  return a + b + c
}

console.log(summation(100, 200))

// callback 함수는 비동기 처리와 아주 밀접한 관계가 있다.
// 특히, app 개발 시 아주 중요하다.
// 버튼을 누르는 UI를 만들텐데 항상 이것들이 callback함수(비동기)이다.
// 왜냐하면 언제 사용자가 버튼을 누를지 모르기 때문이다.

/* BigInt.addEventListner("click", 콜백함수{}) */ // 이러한 형태로 사용자 이벤트 처리를 할 수 있다.
// 서버와 통신 시, axios 기반의 비동기 통신(async/ await)를 사용할 것임.
// 파일 입출력 시: 속도 차이가 발생함.
// 의도적으로 지연이 필요한 경우에도 사용

function birdSing() {
  console.log("bird's are singing")
}

function catCry() {
  console.log("고양이가 웁니다.")
}

function dogDance() {
  console.log("강아지가 웁니다.")
}

function checkAnimalMood(mood) {
  if (mood === "happy") birdSing();
  else if (mood === "sad") catCry();
  else dogDance();
}

// 위 함수를 callback으로 변환
function checkAnimalMoodCallBack(mood, happyAction, sadAction) {
  if (mood === "happy") happyAction();
  else if(mood === "sad") sadAction();
}

checkAnimalMoodCallBack(
  "happy",
  () => {
    console.log("아무것도 안함");
  },
   birdSing); // 소괄호로 닫지 않은 함수는 등록만 됨. 호출이 되는 것이 아님.


// callback 타이머
/* function buyToy(item, price, quantity, callback) {
    console.log("🧒 아이가 '" + item + "' 장난감을 " + quantity + "개 골라서 엄마에게 가져갔습니다.");
    setTimeout(function () {
        console.log("💰 계산이 필요합니다.");
        let total = price * quantity;
        callback(total);
    }, 2000);
}

function pay(total) {
    console.log("엄마: '지불할 금액은 " + total + "원입니다.'");
    console.log("🧒 아이: '와! 고마워요, 엄마!' 🎉");
}

buyToy("공룡 장난감", 3000, 3, pay); */

function Counter() {
  let count = 0;
  
  return {
    // 두 개의 내부 함수(increment, decrement). 즉, 메서드.
    increment: function() {
      count++;
      console.log(count);
    },

    decrement: function() {
      count--;
      console.log(count)
    }
  };
}

const myCounter = Counter(); //counter 객체 생성
myCounter.increment();
myCounter.increment();
myCounter.increment();
myCounter.increment();
myCounter.increment();
myCounter.decrement();
myCounter.decrement();
myCounter.decrement();
myCounter.decrement();


// 반복문과 재귀호출
