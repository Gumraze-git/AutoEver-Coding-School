import { useState, useEffect } from "react";

const Clock = () => {
  // new Date()는 JS가 운영체제로부터 현재 시간을 가져온다.
  const [time, setTime] = useState(new Date());

  useEffect(() => {
    const interval = setInterval(() => {
      setTime(new Date());
    }, 1000);
  }, []); // 마운트 될 때마다 실행

  return (
    <>
      <h2>현재시간</h2>
      <h2>{time.toLocaleTimeString()}</h2>
    </>
  );
};

export default Clock;
