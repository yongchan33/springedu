<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 요청 url : http://localhost:9080/portfolio/rtest/11/{number} 메소드이름와 비슷-->
<!-- 요청파라미터 : 찾고자하는 사람의 번호 문자(4) 매개변수-->
<!-- 응답포맷 : 
	응답코드 2자리
	응답메세지:10자리
	응답데이터:이름10자리
					 나이3자리
					 
					 
					  -->

<!-- 데이터 포맷:json 반환값-->
<script>
	window.addEventListener("load", init);
	function init() {
		const findBtn = document.getElementById('findBtn');
		findBtn.addEventListener("click", find_f);
	}

	function find_f(event) {
		console.log(event.target.id);
		const num = document.getElementById('num').value;

		//AJAX 사용
		//1)XMLHTTPRequest 객체 생성
		const xhttp = new XMLHttpRequest();

		//2)서버응답 처리
		//readyState
		// 0 : open()가 호출되지 않은 상태
		// 1 : open()가 실행된 상태 server 연결됨
		// 2 : send()가 실행된 상태,  서버가 클라이언트 요청을 받았음.
		// 3 : 서버가 클라이언트 요청 처리중. 응답헤더는 수신했으나 바디가 수신중인 상태
		// 4 : 서버가 클라이언트의 요청을 완료했고 서버도 응답이 완료된상태
		xhttp.addEventListener("readystatechange", ajaxCall);
		function ajaxCall(event) {
			if (this.readyState == 4) {
				console.log(this.responseText);
				//json포맷 문자열 => 자바스크립트 ojb
				 // DOM parsing object
      parser = new DOMParser();

      // XML DOM object
      const xmlObject = parser.parseFromString(this.responseText , "text/xml");
			
				console.log(xmlObject[0]+"1번");
				//xml[0].getElementsByTagName('items')[0].nodeValue;

			
				

			}
		}
		//번호로 넘겨주기때문에 요청파라미터 안던져줘도댐.
		 		//3)요청 파라미터만들기(json포맷) { "tel": "010-1234-5678", "birth":"2020-07-01" }

		//4)서비스요청
		xhttp.open("GET", "http://api.visitkorea.or.kr/openapi/service/rest/KorService/searchKeyword?serviceKey=hnSwWkj%2Fc9S5kWK7cWgGIq0k6pdUHdzoJ%2FZIhPjl8VHXxnfGXFzUB3o8w7HuYyKZnwPjd7zT9NqZHjhoyQYF6A%3D%3D&MobileApp=AppTest&MobileOS=ETC&pageNo=1&numOfRows=10&listYN=Y&arrange=A&contentTypeId=12&areaCode=&sigunguCode=&cat1=&cat2=&cat3=&keyword=%EA%B0%95%EC%9B%90&");
		//GET방식에는 필용업음.
		/* 		xhttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded"); */
		xhttp.send(null);
	}
</script>
</head>
<body>
	<h3>사람을 찾습니다.</h3>
	<input type="text" name="num" id="num" />
	<button id="findBtn">찾기</button>
	<div id="errmsg"></div>
	<div id="name"></div>
	<div id="age"></div>
</body>
</html>