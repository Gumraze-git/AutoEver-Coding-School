import axios from "axios";

// 커스텀 인스턴스 생성
const axiosInstance = axios.create({
  // baseURL: 모든 요청의 기본 주소가 된다.
  baseURL: "http://222.117.237.119:8111",
});

// 요청 인터셉터
// 모든 요청 전에 실행된다.
axiosInstance.interceptors.request.use((config) => {
  // localStorage에서 JWT 토큰을 읽어와 요청 헤더에 추가한다.
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

// 응답 인터셉터
// 모든 응답 후에 실행된다.
// 정상 응답은 그대로 통과시키고 오류 발생 시, 처리한다.
axiosInstance.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      alert("로그인이 필요합니다.");
      router.push("/login"); // SPA 방식으로 이동
    }
    return Promise.reject(error);
  }
);

export default axiosInstance;
