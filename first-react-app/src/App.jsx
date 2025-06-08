import "./App.css";
import Members from "./Members";
import Say from "./Say";
import EventInput from "./EventInput";
import TableMap from "./Table";
import NameCard from "./nameCard";
import Info from "./info";
import Clock from "./Clock";
import Counter from "./Counter";
import Average from "./average";
import RefDom from "./RefDom";
import ExampleRef from "./ExampleRef";

function App() {
  return (
    <>
      <h1>App.js 입니다</h1>
      {/* <Members name="안유진" age={23} addr="대전" isAduit="true"></Members>
      <Members name="장원영" age={23} addr="인천" isAduit="true"></Members>
      <Members name="이서" age={19} addr="서울" isAduit="false"></Members> */}
      {/* <Say></Say>
      <EventInput></EventInput>
      <TableMap></TableMap> */}
      {/* <NameCard /> */}
      {/* <Info /> */}
      {/* <Clock /> */}
      {/* <Counter /> */}
      {/* <RefDom /> */}
      <ExampleRef />
    </>
  );
}

export default App;
