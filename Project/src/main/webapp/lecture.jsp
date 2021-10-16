<%@page import="com.model.LectureVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>강의모아보기</title>
    <link rel="stylesheet" href="table.css">
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--로고-->
		<header>
			<h3><a href = "main.jsp">Studynet</a></h3>
		</header>
	</div>
<body class="background">
    <h1 class="link"><b>Lecture</b></h1>
    <form class="searchForm" action="LectureSearchService">
        <div class="searchOut">
            <div class="search">
                <input type="text" placeholder="강의 검색" name="search_words" class="searchInput" autocomplete="off">
                <button class="searchBtn" type="submit" name="click">검색</button>
            </div>
        </div>
    </form>
	<div class="articleBoard">
	<% ArrayList<LectureVO> list = (ArrayList<LectureVO>)session.getAttribute("Lecture"); %>

                <table class="article" ><!-- 반복문을 이용하여 테이블을 정의 하였습니다. 나중에 데이터베이스에서 컬럼명을 변수로 가져와서 붙여넣을 것. -->
                <tr>
                    <th class="cat">카테고리</th>
                    <th class="name">강의명</th>
                    <th class="teach">강사명</th>
                    <th class="price">가격</th>
                    <th class="point">평점</th>
                    <th class="review">후기</th>
                    <!-- <th>URL</th> -->

                </tr>
        <%for(int i = 0; i<list.size() ;i++){ %>
        <% 	LectureVO vo = list.get(i); 
			String lecture_name = vo.getLecture_name();
			String lecture_teach = vo.getLecture_teach();
			String lecture_count = vo.getLecture_count();
			int lecture_price = vo.getLecture_price();
			double lecture_point = vo.getLecture_point();
			String lecture_review = vo.getLecture_review();
			String lecture_url = vo.getLecture_url();
			String lecture_cat = vo.getLecture_cat();
			%>
            <tr class="boardList">
            		<td class="cat"><%=lecture_cat%></td>
                   <td class="name"><a href="<%=lecture_url%>"><%=lecture_name%></a></td>
                   <td class="teach"><%=lecture_teach %></td>

                   <td class="price"><%=lecture_price%></td>
                   <td class="point"><%=lecture_point%></td>
                   <td class="review"><a href="review.jsp?lecture_no=<%=vo.getLecture_no() %>">더보기</a></td>
                   <%--후기더보기 <td class="review"><%=lecture_review%></td>--%>
                  <%--  <td><%=lecture_url%></td> --%>
            </tr>
            <%} %>
           
        </table>
    </div>
    <div class="foot"></div>
</body>
</html>