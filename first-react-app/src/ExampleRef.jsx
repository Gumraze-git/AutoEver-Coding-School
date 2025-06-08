// useEffect: 컴포넌트가 마운트된 후 실행되는 side-effect 함수
import React, { useRef, useEffect } from "react";

// ExampleRef: 함수형 컴포넌트 정의
function ExampleRef() {
  // myButtonRef: useRef 객체 생성
  const myButtonRef = useRef(null);

  // useEffect(() => { ... }, []): 컴포넌트가 처음 마운트될 때 실행, 의존성 없음, 이후 리렌더링 되어도 다시 실행되지 않는다.
  useEffect(() => {
    // myButtonRef.current: 해당 ref가 연결된 실제 DOM 요소 객체.
    // myButtonRef.current가 존재 할 때,
    if (myButtonRef.current) {
      // myButtonRef.current.innerText: HTML 요소의 텍스트 노드를 변경한다.
      myButtonRef.current.innerText = "CLICK!";
    }
  }, []);

  // 컴포넌트 내부 변수를 useRef를 사용하여 유지한다.
  // useRef로 생성된 객체는 컴포넌트가 다시 렌더링 되어도 값이 유지되며, 값 변경 시 리렌더링되지 않는다.
  // 즉, 상태 업데이트 없이 내부 값을 기억할 수 있다.
  const count = useRef(0);

  const handleClick = () => {
    count.current += 1;
    alert(`클릭 횟수: ${count.current}`);
  };

  return (
    <div>
      <button ref={myButtonRef} onClick={handleClick}>
        초기 상태
      </button>
    </div>
  );
}

export default ExampleRef;
