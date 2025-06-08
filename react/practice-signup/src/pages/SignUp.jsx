import React, { useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import styled from "styled-components";
import { UserContext } from "../stores/UserStore";

const Wrapper = styled.div`
  max-width: 400px;
  margin: 4rem auto;
  padding: 2rem;
  border: 1px solid #dee2e6;
  border-radius: 8px;
  background-color: #f8f9fa;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
`;

const Title = styled.div`
  font-size: 2rem;
  font-weight: bold;
  text-align: center;
  margin-bottom: 2rem;
  color: #343a40;
`;

const StyledInput = styled.input`
  display: block;
  width: 100%;
  margin: 0.75rem 0;
  padding: 0.75rem;
  font-size: 1rem;
  border: 1px solid #ced4da;
  border-radius: 4px;
  box-sizing: border-box;
  &:focus {
    border-color: #495057;
    outline: none;
  }
`;

const Button = styled.button`
  width: 100%;
  height: 50px;
  margin-top: 1rem;
  background-color: #228be6;
  color: white;
  font-size: 1rem;
  border: none;
  border-radius: 4px;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.2s ease;
  &:hover {
    background-color: #1971c2;
  }
`;

const SignUp = () => {
  const { setUserId, setPassword, setName } = useContext(UserContext);
  const navigate = useNavigate();

  const [email, setEmail] = useState("");
  const [passwordInput, setPasswordInput] = useState("");
  const [nameInput, setNameInput] = useState("");

  const handleSignUp = () => {
    setUserId(email);
    setPassword(passwordInput);
    setName(nameInput);
    alert("회원가입 정보가 저장되었습니다.");
    navigate("/");
  };

  return (
    <Wrapper>
      <Title>Sign Up</Title>
      <div>
        <StyledInput
          type="text"
          placeholder="Enter email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <StyledInput
          type="text"
          placeholder="Enter name"
          value={nameInput}
          onChange={(e) => setNameInput(e.target.value)}
        />
        <StyledInput
          type="password"
          placeholder="Enter password"
          value={passwordInput}
          onChange={(e) => setPasswordInput(e.target.value)}
        />
      </div>
      <div>
        <Button onClick={handleSignUp}>Sign Up</Button>
      </div>
    </Wrapper>
  );
};

export default SignUp;
