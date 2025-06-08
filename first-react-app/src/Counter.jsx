import { useReducer } from "react";

const reducer = (state, action) => {
  switch (action.type) {
    case "increment":
      return { value: state.value + 1 };
    case "decrement":
      return { value: state.value - 1 };
    default:
      return state;
  }
};

const Counter = () => {
  /* 
  state: 현재 상태
  dispatch: 상태를 변경하는 명령 함수
  reducer: 상태를 어떻게 바꿀지 정의한 함수
  initial({value:0}): 초기 상태 값
   */
  const [state, dispatch] = useReducer(reducer, { value: 0 });

  return (
    <>
      <p>현재 카운터: {state.value}</p>
      <button onClick={() => dispatch({ type: "increment" })}>증가</button>
      <button onClick={() => dispatch({ type: "decrement" })}>감소</button>
    </>
  );
};

export default Counter;
