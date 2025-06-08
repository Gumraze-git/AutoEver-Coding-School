// useState: 상태(state) 관리 Hook
// 컴포넌트에 상태 변수를 추가한다. 기존에는 클래스형 컴포넌트에서만 상태를 가질 수 있었지만, useState 덕분에 함수형 컴포넌트에서도 상태를 관리 할 수 있게 되었다.

// useEffect: 부수 효과(effect) 처리 Hook
// 컴포넌트가 렌더링된 이후 실행되는 부수 효과(side effect)를 처리한다.
import { useState, useEffect } from "react";
import "./App.css";

const fetchData = [
  { id: 1, name: "john", age: 25 },
  { id: 2, name: "Jane", age: 30 },
  { id: 3, name: "Tom", age: 28 },
];

const TableMap = () => {
  const [members, setMembers] = useState([]);

  useEffect(() => {
    // 비동기 통신 호출 후 await로 대기, 데이터가 수신되면 상태 변경
    console.log("마운트 이후 useEffect() 호출");
    setMembers(fetchData);
  }, []); // [] 의존성 배열, 비어 있으면 마운트 시점에 호출 된다. onMounted()와 동일함.

  const memberSelect = (member) => {
    console.log(member);
  };

  return (
    <table>
      <tr>
        <th>ID</th>
        <th>이름</th>
        <th>나이</th>
      </tr>
      {members &&
        members.map((member) => (
          <tr key={member.id} onClick={() => memberSelect(member.name)}>
            <td>{member.id}</td>
            <td>{member.name}</td>
            <td>{member.age}</td>
          </tr>
        ))}
    </table>
  );
};

export default TableMap;
