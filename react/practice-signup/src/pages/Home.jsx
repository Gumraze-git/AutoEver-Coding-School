import React, { useContext } from "react";
import styled from "styled-components";
import { Outlet, useNavigate } from "react-router-dom";
import { UserContext } from "../stores/UserStore";

const HEADER_HEIGHT = "80px";

const Wrapper = styled.div`
  margin: 0 auto;
  display: flex;
  flex-direction: column;
  background: #f9fafb;
  font-family: "Segoe UI", Roboto, sans-serif;
  color: #212529;
  box-sizing: border-box;
  flex: 1;
  min-height: calc(100vh - ${HEADER_HEIGHT});
  padding-top: ${HEADER_HEIGHT};
`;

const Header = styled.header`
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: ${HEADER_HEIGHT};
  padding: 1rem 2rem;
  background: #ffffff;
  text-align: center;
  font-size: 2rem;
  font-weight: 700;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.05);
  z-index: 1000;
  display: flex;
  align-items: center;
  justify-content: space-between;
  box-sizing: border-box;
`;

const Hero = styled.section`
  height: 400px;
  background-size: cover;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  text-align: center;

  h1 {
    font-size: 3rem;
    margin: 0;
    font-weight: bold;
  }

  p {
    font-size: 1.25rem;
    margin-top: 1rem;
  }
`;

const Footer = styled.footer`
  padding: 1rem;
  text-align: center;
  font-size: 0.95rem;
  color: #6c757d;
  background: #f1f3f5;
  margin-top: auto;
`;

const Logo = styled.p`
  font-size: x-large;
  font-weight: bold;
  color: #007bff;
`;

const Name = styled.p`
  font-size: x-large;
  font-weight: 500;
  color: #495057;
`;

const Login = styled.p`
  font-size: x-large;
  font-weight: 500;
  color: #495057;
  cursor: pointer;
`;

const Logout = styled.button`
  background: none;
  border: none;
  padding: 0;
  margin: 0;
  font: inherit;
  color: inherit;
  cursor: pointer;
  font-size: x-large;
  font-weight: 500;
  color: #495057;
`;

const HeaderRight = styled.div`
  display: flex;
  gap: 5px;
`;

const Home = () => {
  const { name, setName, setUserId, setPassword } = useContext(UserContext);
  const navigate = useNavigate();

  const getName = () => {
    if (name) {
      return name;
    }
    return localStorage.getItem("name");
  };

  const UserName = getName();

  const handleLogout = () => {
    localStorage.removeItem("name");
    localStorage.removeItem("userId");
    localStorage.removeItem("password");

    setName("");
    setUserId("");
    setPassword("");

    alert("로그아웃 되었습니다.");
  };

  const handleLogin = () => {
    navigate("/");
  };

  return (
    <>
      <Header>
        <Logo>LOGO</Logo>
        <HeaderRight>
          {UserName ? (
            <>
              <Name>{name}</Name>
              <Logout onClick={handleLogout}>Logout</Logout>
            </>
          ) : (
            <Login onClick={handleLogin}>Login</Login>
          )}
        </HeaderRight>
      </Header>
      <Wrapper>
        <Hero>
          <h2>Welcome</h2>
        </Hero>
        <Outlet />
      </Wrapper>
      <Footer>&copy; 2025 Your Company. All rights reserved.</Footer>
    </>
  );
};

export default Home;
