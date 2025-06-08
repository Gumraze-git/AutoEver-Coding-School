import "./App.css";
import Main from "./pages/Main";
import About from "./pages/About";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { UserStore } from "./stores/UserStore";
import News from "./pages/News";

function App() {
  return (
    /* UserStore내의 하위 컴포넌트들은 UserStore내의 정보를 반환할 수 있음. */
    <UserStore>
      <Router>
        <Routes>
          <Route path="/" element={<Main></Main>}>
            <Route></Route>
          </Route>
        </Routes>
      </Router>
    </UserStore>
  );
}

export default App;
