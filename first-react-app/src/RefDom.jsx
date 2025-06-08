import React, { useRef } from "react";
// React에서는 ref를 사용하여 DOM 요소나 React 컴포넌트 인스턴스에 직접 접근할 수 있다.
// ref는 React.createRef() 또는 useRef() 훅을 통해 생성된다.

function RefDom() {
  // 함수형 컴포넌트 정의
  // inpurRef: ref 객체 생성 후 초기값을 null으로 설정
  const inputRef = useRef(null);

  // focusInput: 이벤트 핸들러 선언
  const focusInput = () => {
    // inputRef로 참조된 현재(current) DOM요소에 focus를 준다.
    inputRef.current.focus();
  };

  /* React가 input요소를 생성할 때, ref로 전달된 inputRef 객체의 .current 속성에 DOM 요소를 자동으로 할당하게 한다. */

  return (
    <div>
      {/* input 필드가 inputRef를 참조한다. */}
      <input ref={inputRef} type="text" />

      {/* 버튼을 클릭 시, focusInput 함수가 실행되어 input 필드에 포커스를 준다. */}
      <button onClick={focusInput}>Focus Input</button>
    </div>
  );
}

export default RefDom;
