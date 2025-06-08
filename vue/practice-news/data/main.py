from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from bs4 import BeautifulSoup
import time

# Chrome 설정
# 크롬 브라우저 실행 시 사용할 환경 설정 옵션 객체를 생성
options = Options()

# 객체에 대한 실행 설정 추가
options.add_argument("--headless") # 브라우저 화면 없이 백그라운드에서 실행
options.add_argument("--no-sandbox") # 샌드박스 보안 기능 비활성화
options.add_argument("--disable-dev-shm-usage") # 공유 메모리 파일 시스템 사용 비활성화

# 백그라운드에서 크롬 브라우저 실행
driver = webdriver.Chrome(options=options)

# url 주소
url = "https://news.naver.com/"

# 백그라운드에서 페이지 열기
driver.get(url)

# 렌더링 대기를 하는 이유:
# 대부분의 웹 사이트는 JS로 콘텐츠를 동적으로 생성하기 때문에 
# url 주소의 페이지를 여는 순간 전체 HTML 코드가 완성되지 않음
time.sleep(2)

# 페이지 소스(html) 가져오기
html = driver.page_source

# HTML 파싱 = HTML 구조를 탐색하고 필요한 요소들을 추출하기 위한 작업
soup = BeautifulSoup(html, "html.parser")

# 뉴스 컨텐츠가 있는 div 선택
target_div = soup.select_one("div.press_edit_news._nudge_wrap._CURATION_CARD")


print(target_div.prettify())

# 브라우저 닫기
driver.quit()
