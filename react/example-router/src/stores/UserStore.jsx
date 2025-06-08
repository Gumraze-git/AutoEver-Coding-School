// createContext: Context 객체 생성
// useState: 컴포넌트 내에서 상태를 선언함.
import { createContext, useState } from "react";

// UserContext: Context 객체를 생성하여 전역 데이터 저장소를 만든다.
export const UserContext = createContext(null);

// 함수형 컴포넌트 선언
// UserStore
// - props: 컴포넌트가 호출 될 때, 부모 컴포넌트로부터 전달받은 속상 값들을 객체 형태로 받는 매개변수이다.
export const UserStore = (props) => {
  // userId: 현재 값, setUserId: 값을 바꾸는 함수
  const [userId, setUserId] = useState("");
  // password: 현재 값, setPassword: 값을 바꾸는 함수
  const [password, setPassword] = useState("");

  return (
    // UserContext.provider: Context의 공급자(provider) 역할을 한다.
    // value에 담긴 데이터를 하위 컴포넌트들이 어디서든 접근할 수 있도록 공급한다.
    <UserContext.Provider
      value={{
        userId,
        setUserId,
        password,
        setPassword,
      }}
    >
      {props.children}
    </UserContext.Provider>
  );
};
