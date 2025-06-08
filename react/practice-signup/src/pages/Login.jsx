import React, { useContext, useState } from "react";
import styled from "styled-components";
import { Link, useNavigate } from "react-router-dom";
import { UserContext } from "../stores/UserStore";

// 전체 컨테이너 스타일
const Wrapper = styled.div`
  padding: 2rem;
  max-width: 400px;
  margin: 5rem auto;
  background-color: #f8f9fa;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
`;

// 타이틀 스타일
const Title = styled.div`
  font-size: 2rem;
  font-weight: bold;
  text-align: center;
  margin-bottom: 2rem;
  color: #343a40;
`;

// 입력창 스타일
const InputBox = styled.input`
  display: block;
  width: 90%;
  padding: 0.75rem;
  margin-bottom: 1rem;
  border: 1px solid #ced4da;
  border-radius: 4px;
  font-size: 1rem;
  &:focus {
    border-color: #495057;
    outline: none;
  }
`;

// 버튼 스타일
const Button = styled.button`
  display: block;
  width: 100%;
  padding: 0.75rem;
  background-color: #007bff;
  color: white;
  font-size: 1rem;
  font-weight: bold;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  text-align: center;
  &:hover {
    background-color: #0056b3;
  }
  &:focus {
    outline: none;
    box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.5);
  }
`;

const Sign = styled(Link)`
  display: block;
  margin-top: 1rem;
  text-align: center;
  color: #007bff;
  text-decoration: none;
  font-weight: bold;

  &:hover {
    text-decoration: underline;
  }
`;

const Login = () => {
  const { userId, password } = useContext(UserContext);
  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [passwordInput, setPasswordInput] = useState("");

  const handleLogin = () => {
    const validation = userId === email && password === passwordInput;
    if (validation) {
      alert("로그인 성공");
      navigate("/home");
    } else {
      alert("이메일 또는 비밀번호가 올바르지 않습니다");
    }
  };

  return (
    <Wrapper>
      <Title>Login</Title>
      <div>
        <InputBox
          type="text"
          placeholder="Enter email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <InputBox
          type="password"
          placeholder="Enter password"
          value={passwordInput}
          onChange={(e) => setPasswordInput(e.target.value)}
        />
      </div>
      <div>
        <Button onClick={handleLogin}>Login</Button>
      </div>
      <div>
        <Sign to="/sign">Sign Up</Sign>
      </div>
    </Wrapper>
  );
};

export default Login;
