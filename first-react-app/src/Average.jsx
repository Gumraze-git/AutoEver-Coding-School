import { useState, useMemo } from "react";

const getAverage = (numbers) => {
  console.log("평균값 계산 중...");

  if (numbers.length === 0) return 0;
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};

const Average = () => {
  const [list, setList] = useState([]);
  const [number, setNumber] = useState([]);
  const onChange = (e) => {
    setNumber(e.target.value);
  };

  const inInsert = () => {
    const nextList = list.concat(parseInt(number));
    setList(nextList);
    setNumber("");
  };

  const avg = useMemo(() => getAverage(list), [list]); // list가 갱신 될 떄, avg가 갱신
  return (
    <>
      <input value={number} onChange={onChange} />
      <button onClick={inInsert}>등록</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <p>평균값 {avg}</p>
    </>
  );
};

export default Average;
