import { useState } from "react";

const Say = () => {
  // message: 메시지를 읽는 변수, setMessage: 메시지를 변경하는 함수(렌더링 발생)
  const [messgage, setMessage] = useState("");
  const onClickEnter = () => setMessage("안녕하세요.");
  const onClickLeave = () => setMessage("안녕히가세요.");

  // 마찬가지로 color는 변수, setColor는 변수를 변경하는 함수
  const [color, setColor] = useState("black");
  return (
    <>
      {/* onClickEnter에 소괄호`()`가 없는 이유는 등록이기 때문이다. */}
      <button onClick={onClickEnter}>입장</button>
      <button onClick={onClickLeave}>퇴장</button>

      {/* 변수 이름과 key값(color)가 일치하면 다음과 같이 선언해도 된다. */}
      <h1 style={{ color }}>{messgage}</h1>

      <button style={{ color: "red" }} onClick={() => setColor("red")}>
        빨간색
      </button>
      <button style={{ color: "green" }} onClick={() => setColor("green")}>
        초록색
      </button>
      <button style={{ color: "blue" }} onClick={() => setColor("blue")}>
        파란색
      </button>
    </>
  );
};

export default Say;
