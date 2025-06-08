import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import SignUp from "./pages/SignUp";
import UserStore from "./stores/UserStore";
import Login from "./pages/Login";
import Home from "./pages/Home";
import Profile from "./pages/Profile";

function App() {
  return (
    <UserStore>
      <Router>
        <Routes>
          <Route path="/" element={<Login></Login>}></Route>
          <Route path="/sign" element={<SignUp></SignUp>}></Route>
          <Route path="/home" element={<Home></Home>}>
            <Route path="profile" element={<Profile />}></Route>
          </Route>
        </Routes>
      </Router>
    </UserStore>
  );
}

export default App;
