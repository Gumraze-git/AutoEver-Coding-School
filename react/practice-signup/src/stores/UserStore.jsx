import { useEffect, useState } from "react";
import { createContext } from "react";

export const UserContext = createContext(null);

// 함수형 컴포넌트 선언
// UserStore
// - props: 컴포넌트가 호출 될 때, 부모 컴포넌트로부터 전달받은 속상 값들을 객체 형태로 받는 매개변수이다.
const UserStore = (props) => {
  // 1. localStorage에서 초기값 불러오기
  // userId: 현재 값, setUserId: 값을 바꾸는 함수
  const [userId, setUserId] = useState(
    () => localStorage.getItem("userId") || ""
  );
  // password: 현재 값, setPassword: 값을 바꾸는 함수
  const [password, setPassword] = useState(
    () => localStorage.getItem("password") || ""
  );

  const [name, setName] = useState(() => localStorage.getItem("name") || "");

  // 2. userId 및 password가 변경 될 때, localStroage에 저장
  useEffect(() => {
    if (userId) {
      localStorage.setItem("userId", userId);
    } else {
      localStorage.clear("userId");
    }
  }, [userId]);

  useEffect(() => {
    if (password) {
      localStorage.setItem("password", password);
    } else {
      localStorage.clear("password");
    }
  }, [password]);

  useEffect(() => {
    if (name) {
      localStorage.setItem("name", name);
    } else {
      localStorage.clear("name");
    }
  }, [name]);

  return (
    // UserContext.provider: Context의 공급자(provider) 역할을 한다.
    // value에 담긴 데이터를 하위 컴포넌트들이 어디서든 접근할 수 있도록 공급한다.
    <UserContext.Provider
      value={{
        userId,
        setUserId,
        password,
        setPassword,
        name,
        setName,
      }}
    >
      {props.children}
    </UserContext.Provider>
  );
};

export default UserStore;
