/* 자바스크립트는 원시 타입을 제외한 모든 값이 객체
객체 리터럴은 중괄호 {}로 생성, 속성과 값의 쌍으로 구성 */

const person = {
  title: "지구오락실",
  name: "안유진",
  age: 23,
  job: "IVE",
};

const member = {
  id: "jks2024",
  pwd: "sphb8250",
  addr: {
    home: "경기도 수원시",
    company: "서울시 금천구 가산동"
  },
  name: "정경수",
  func1: () => {
    console.log("함수 호출 입니다.")
  }
}

// 서버에서 데이터가 내려오면 다음과 같이 내려옴
const members = [
  {id: "ive1", pwd: "1234", addr: "suwon", name: "kim"},
  {id: "id3", pwd: "123452", addr: "seoul", name: "kwak"},
  {id: "id2", pwd: "sdf23", addr: "daejeon", name: "bottle"},
  {id: "id4", pwd: "sj2k3n", addr: "incheon", name: "wonji"},
  {id: "id5", pwd: "opiwefn1", addr: "seoul", name: "ji sung"},
  {id: "id6", pwd: "lmsd0", addr: "suwon", name: "baek"}
]

members.map(member => {
  console.log("아이디:" + members.id)
  console.log("비밀번호:" + members.pwd)
  console.log("주소:" + members.addr)
  console.log("이름:" + members.name)
  console.log(`${"-" * 10}`)
});
