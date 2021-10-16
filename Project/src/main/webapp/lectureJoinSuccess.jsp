<%@page import="com.model.LectureDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>회원가입</title>
    <link rel="stylesheet" href="main.css">
</head>

<body class="title">
	<div class="linkTitle">
            <h1>
                <a href = "main.jsp" class = "h_logo">
                    <span> I.Study </span>
                </a>
            </h1>
	</div>
	<form action="LoginService" method="post">
		<div class="loginDiv">
			<h2 class="loginlogo">강의선택성공</h2>
		</div>
		<%
		request.setCharacterEncoding("euc-kr");
    	//받아온 lecture_no를 int타입으로 변경하여 저장
    	int lecture_no = Integer.parseInt(request.getParameter("lecture_no"));
    	LectureDAO dao = new LectureDAO();
    	//ArrayList<LectureVO>로 강의 정보를 출력해야 함
    	//강의명 가져옴
    	//String lecture_name = dao.Lecture_SelectMy(lecture_no);
		%>
         <table id="logintable">
            <tr>
            <td><h1>강의가 선택되었습니다.</h1></td>
            </tr>
            <tr>
                <td>
				<h1><!-- 여기에 표현식으로 강의명을 출력 -->가 나의 강좌로 선택되었습니다.</h1>
			</td>
            </tr>
            
        <tr colspan="2" class="findid"><td><a href="main.jsp">메인으로 돌아가기</a></td></tr>
 		 </table>
		<div ></div>
		
		<div >
		
		</div>
	</form>
		<div ></div>
		
		<div >
		
		</div>
	</form>
</body>
</html>