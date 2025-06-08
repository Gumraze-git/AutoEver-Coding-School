// JSON 데이터
const jsonData = `
[
    {
        "name": "안유진",
        "age": 20,
        "isStudent": false,
        "courses": ["음악", "댄스", "연기"],
        "address": {
            "city": "서울",
            "zipcode": "12345"
        }
    },
    {
        "name": "가을",
        "age": 20,
        "isStudent": false,
        "courses": ["음악", "댄스", "연기"],
        "address": {
            "city": "서울",
            "zipcode": "12345"
        }
    },
    {
        "name": "레이",
        "age": 19,
        "isStudent": true,
        "courses": ["음악", "일본어", "연기"],
        "address": {
            "city": "서울",
            "zipcode": "12345"
        }
    }
]
`;

// JSON 문자열을 JavaScript 객체로 변환 (역직렬화)
const jsonObject = JSON.parse(jsonData);
console.log("객체로 변환된 데이터:", jsonObject);

// JavaScript 객체를 JSON 문자열로 변환 (직렬화)
const jsonString = JSON.stringify(jsonObject, null, 4);
console.log("다시 JSON으로 변환된 데이터:", jsonString);

// HTML에 출력할 부모 요소 선택
const container = document.getElementById('container');

// map을 이용해 JSON 객체 데이터를 HTML 형식으로 변환
const htmlContent = jsonObject.map(person => `
    <div class="person">
        <h2>${person.name}</h2>
        <p>나이: ${person.age}</p>
        <p>학생 여부: ${person.isStudent ? "예" : "아니오"}</p>
        <p>과목: ${person.courses.join(", ")}</p>
        <p>주소: ${person.address.city}, 우편번호: ${person.address.zipcode}</p>
    </div>
`).join('');

// HTML에 삽입
container.innerHTML = htmlContent;