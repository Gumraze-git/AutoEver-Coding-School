import { useState } from "react";

// NameCardPrn: 자식요소로 nameCard 객체를 부모 컴포넌트(NameCard)로부터 props로 전달받음.
const NameCardPrn = ({ nameCard }) => {
  return (
    // 컴포넌트 출력 시작, 명함 정보를 p태그로 렌더링하며 nameCard 객체 속성을 직접 사용한다.
    <>
      <h3>명함 정보 출력</h3>
      <p>이름 : {nameCard.name}</p>
      <p>직책 : {nameCard.position}</p>
      <p>회사 : {nameCard.company}</p>
      <p>주소 : {nameCard.addr}</p>
      <p>메일 : {nameCard.email}</p>
      <p>전화 : {nameCard.phone}</p>
    </>
  );
};

// NameCard: 입력 및 상태 관리 컴포넌트, 부모 컴포넌트
const NameCard = () => {
  // nameCard: 명함 정보, setNameCard: 상태를 갱신하는 함수
  const [nameCard, setNameCard] = useState({
    name: "",
    position: "",
    company: "",
    addr: "",
    email: "",
  });

  // submit: 제출 여부를 나타내는 불리언 값, setSubmit: 상태를 갱신하는 함수(기본 값은 false)
  const [submit, setSubmit] = useState(false);

  // onChange: 모든 입력 필드를 하나의 함수로 처리하는 이벤트 핸들러
  /* 
  Params:
  - key: 업데이트할 상태 객체의 속성 이름
  - value: 해당 속성에 새로 설정할 값
  Notes:
  - event: 이벤트 객체
  - target: 이벤트가 발생한 HTML요소. ex) <input> 등
  - value: 해당 요소의 현재값
  - event.target.value: 사용자가 입력 필드에 입력한 실제값을 가져옴
  - ...nameCard: 기존 nameCard 객체의 모든 속성을 복사함
  - [key]: value: 계산된 속성명(computed property name) 문법으로, key 변수에 담긴 문자열을 객체의 속성 이름으로 사용한다.
  Example:
  - (e) => onChange("name", e.target.value): event가 발생하면, key("name")에 사용자 입력값(e.target.value)을 새 값으로 상태 변화를 한다.
   */
  const onChange = (key, value) => {
    // [key]: value는 계산된 속성명으로 동적으로 객체 필드를 설정함.
    setNameCard({ ...nameCard, [key]: value });
  };

  // 제출 버튼을 클릭시 submit의 상태를 true로 바꾸어 출력 영역이 렌더링 되도록 함.
  const onSubmit = () => {
    setSubmit(true);
  };

  // JSX 렌더링 영역
  return (
    // value외 onChange로 양방향 바인딩 구현
    <>
      <h1>회원 정보 가입</h1>
      <input
        type="text"
        placeholder="이름 입력"
        value={nameCard.name}
        onChange={(e) => onChange("name", e.target.value)}
      />
      <br />
      <input
        type="text"
        placeholder="직책 입력"
        value={nameCard.position}
        onChange={(e) => onChange("position", e.target.value)}
      />
      <br />
      <input
        type="text"
        placeholder="회사 입력"
        value={nameCard.company}
        onChange={(e) => onChange("company", e.target.value)}
      />
      <br />
      <input
        type="text"
        placeholder="주소 입력"
        value={nameCard.addr}
        onChange={(e) => onChange("addr", e.target.value)}
      />
      <br />
      <input
        type="email"
        placeholder="메일 입력"
        value={nameCard.email}
        onChange={(e) => onChange("email", e.target.value)}
      />
      <br />
      <input
        type="tel"
        placeholder="폰 입력"
        value={nameCard.phone}
        onChange={(e) => onChange("phone", e.target.value)}
      />
      <br />

      {/* 클릭이 이루어졌을 때(onClick) submit 상태를 true로 반환(onSubmit)함 */}
      <button onClick={onSubmit}>제출</button>

      {/* submit이 true일 때만 자식 컴포넌트(NameCardPrn)를 렌더링하여 입력값을 출력함
      nameCard 객체를 props로 전달함 */}

      {submit && <NameCardPrn nameCard={nameCard} />}
    </>
  );
};
export default NameCard;
