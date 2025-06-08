import { useState } from "react";

const EventInput = () => {
  const [message, setMessage] = useState("안녕하세요");
  const changeMsg = (event) => {
    setMessage(event.target.value);
  };

  return (
    <>
      <input placeholder="인사말 입력" onChange={changeMsg} value={message} />
      <h2>입력 받은 메시지: {message}</h2>
    </>
  );
};

export default EventInput;
