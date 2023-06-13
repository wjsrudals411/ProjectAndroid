# ProjectAndroid

일반 로그인 버튼(btn_login)이 클릭되면, 입력된 아이디와 비밀번호를 서버로 전송하여 로그인을 시도합니다. 
서버 응답을 받으면 JSON 형식으로 응답을 파싱하고, 로그인이 성공하면 홈 화면(HomeActivity)으로 이동합니다. 로그인이 실패하면 실패 메시지를 토스트 메시지로 표시합니다.
(로그인, 회원가입 부분)
LoginRequest 클래스는 StringRequest를 상속하여 서버에 로그인 요청을 보내는 역할을 합니다. 
요청 메서드는 POST로 설정되어 있으며, getParams() 메서드를 오버라이드하여 전송할 데이터를 설정합니다.

이 PHP 코드는 사용자 인증을 처리하는 로그인 시스템을 구현하는 데 사용될 수 있습니다.
사용자 입력 받기: $_POST 슈퍼글로벌 변수를 사용하여 사용자로부터 userID와 userPassword를 받아옵니다. 이는 로그인 폼 등을 통해 사용자로부터 입력받은 값입니다.
이 코드는 주어진 userID와 userPassword를 사용하여 데이터베이스에서 일치하는 사용자를 찾고, 해당 사용자의 정보를 JSON 형식으로 반환합니다. 성공 여부와 사용자 정보는 response 배열에 저장됩니다.


(반려견 등록)
회원가입 버튼(btn_register)이 클릭되면 입력된 정보를 가져와서 서버로 전송합니다. 응답을 받으면 JSON 형식으로 응답을 파싱하고, 
회원가입이 성공하면 토스트 메시지를 통해 성공을 알리고 MainActivity로 이동합니다. 회원가입이 실패하면 실패 메시지를 토스트 메시지로 표시합니다.
자바 코드는 먼저 보여드린 로그인 부분과 거의 비슷하고 PHP부분만 Insert로 수정하고 JSON형식으로 반환하면 된다.

(PHPMyadmin부분)
반려견 정보를 입력하고 Insert가 된모습

(반려견을 만들고 난 후 서버 에서 데이터를 가져오는 부분)
이 코드는 서버에서 애완동물 목록을 가져와서 리스트로 표시하는 기능
그리고 Volley를 사용하여 서버에 데이터를 요청하는 JsonObjectRequest 객체를 생성합니다. 이 객체는 GET 방식으로 요청하며, 
서버 응답을 처리하는 Response.Listener와 에러 응답을 처리하는 Response.ErrorListener를 설정합니다.

서버 응답이 정상적으로 도착하면 JSON 데이터를 파싱하여 애완동물 정보를 가져옵니다. 
pets라는 키에 해당하는 JSON 배열을 가져와서 반복문을 통해 각 애완동물의 이름, 나이, 종류, 성별을 추출합니다. 그리고 이 정보를 petList라는 리스트에 추가합니다.

데이터를 모두 처리한 후, 리스트를 표시하기 위해 ArrayAdapter를 생성하여 리스트뷰에 설정합니다

(강아지 다이어리 부분)
PetList에서 setOnItemClickListener 부여하여 캘린더를 작성할 수 있게 해줌
calendarView에 날짜 선택 이벤트 리스너를 등록합니다. 날짜가 선택되면 해당 날짜의 다이어리 내용을 불러옵니다.
메뉴 기능과 다이어리 작성, 수정, 삭제 기능이 구현되어 있음.

(반려견 검사결과 부분)
반려견 등록부분과 동일함.
![dal](https://github.com/wjsrudals411/ProjectAndroid/assets/103473959/354eead6-ca67-4f44-99fc-dc456c6b31f2)


