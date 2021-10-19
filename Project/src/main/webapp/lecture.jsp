<%@page import="com.model.MemberVO"%>
<%@page import="com.model.LectureVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=euc-kr"
    pageEncoding="euc-kr"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="euc-kr">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <title>���Ǹ�ƺ���</title>
    <script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="table.css">
</head>
	<!--�ΰ�-->
	<header>
		<nav class="navbar">
               <div class="navbar_logo">
                   <i class="fas fa-graduation-cap"></i>
                   <a href="main.jsp">I-Study</a>
               </div>
               <ul class="navbar_menu">
                   <a href="main.jsp"><li>Ȩ</li></a>
                   <a href="LectureSearchService?search_words="><li>����</li></a>
                   <a href="StudySearchService?search_words="><li>���͵�</li></a>
               </ul>
               <ul class="navbar_account">
                   <%MemberVO vo = (MemberVO)session.getAttribute("Member"); %>
                   <%if(vo == null){ %>
                       <a href="login.jsp"><li>�α���</li></a>
                       <a href="join.jsp"><li>ȸ������</li></a>
                   <%}else{ %>
                       <a href="Lecture_MainpageService"><li>���� ����</li></a>
                       <a href="Study_MypageView"><li>���� ���͵�</li></a>
                       <a href="logout.jsp"><li>�α׾ƿ�</li></a>
                   <%}%>
               </ul>
               <a href="#" class="navbar_toggleBtn">
                   <i class="fas fa-bars"></i>
               </a>
           </nav>
	</header>
	<div style="text-align: left; margin: 0%" class="title"></div>
<body class="background">
    <h1 class="link"><b>Lecture</b></h1>
    <form class="searchForm" action="LectureSearchService">
        <div class="searchOut">
            <div class="search">
                <input type="text" placeholder="���� �˻�" name="search_words" class="searchInput" autocomplete="off">
                <button class="searchBtn" type="submit" name="click">�˻�</button>
            </div>
        </div>
    </form>
	<div class="articleBoard">
	<% ArrayList<LectureVO> list = (ArrayList<LectureVO>)session.getAttribute("Lecture"); %>

                <table class="article" ><!-- �ݺ����� �̿��Ͽ� ���̺��� ���� �Ͽ����ϴ�. ���߿� �����ͺ��̽����� �÷����� ������ �����ͼ� �ٿ����� ��. -->
                <tr>
                    <th class="cat">ī�װ�</th>
                    <th class="name">���Ǹ�</th>
                    <th class="teach">�����</th>
                    <th class="count">���¼�</th>
                    <th class="price">����</th>
                    <th class="point">����</th>
                    <th class="review">�ı�</th>
                    <th class="review">���Ǽ���</th>
                    <!-- <th>URL</th> -->

                </tr>
        <%-- <%for(int i = 0; i<list.size() ;i++){ %> --%>
        <!-- 50���� �̰��� -->
        <%int num = 0; %>
        <% // �����Ͱ� 50���� ����������� �����߻� -> 50���� �ȳ����� ������� ��ü�ϰ� �ٲ� %>
        <%if (list.size()>=50){ num = 50; } else {num = list.size();} %>
        <%for(int i = 0; i<num ;i++){ %>
        <% 	LectureVO vo2 = list.get(i); 
			String lecture_name = vo2.getLecture_name();
			String lecture_teach = vo2.getLecture_teach();
			String lecture_count = vo2.getLecture_count();
			int lecture_price = vo2.getLecture_price();
			double lecture_point = vo2.getLecture_point();
			String lecture_review = vo2.getLecture_review();
			String lecture_url = vo2.getLecture_url();
			String lecture_cat = vo2.getLecture_cat();
			%>
            <tr class="boardList">
            	   <td class="cat"><%=lecture_cat%></td>
                   <td class="name"><a href="<%=lecture_url%>"><%=lecture_name%></a></td>
                   <td class="teach"><%=lecture_teach %></td>
				   <td class="count"><%=lecture_count %></td>
                   <td class="price"><%=lecture_price%></td>
                   <td class="point"><%=lecture_point%></td>
                   <td class="review"><a href="review.jsp?lecture_no=<%=vo2.getLecture_no() %>">������</a></td>
                   <td class="review"><a href="Course_Insert?lecture_no=<%=vo2.getLecture_no() %>">����</a></td>
                   <%-- <td class="review"><a href="lectureJoinSuccess.jsp?lecture_no=<%=vo.getLecture_no() %>">����</a></td> --%>

                   <%--�ı������ <td class="review"><%=lecture_review%></td>--%>
                  <%--  <td><%=lecture_url%></td> --%>
            </tr>
            <%} %>
           
        </table>
        <div class="pages">
        <%
        String words = (String)session.getAttribute("words");
        for(int a =1; a<11;a++){ 
        	
        %>
        <a href="LectureSearchService?pages=<%=a%>&search_words=<%=words%>"><%=a %></a>
        <%} %>
        </div>
    </div>
    <button class="gobackBtn" onclick="document.location.href='main.jsp'"
    style="width: 80px; height: 25px; font-size: 15px; display: block; margin: 30px auto;">Ȩ����</button>
    <div class="foot"></div>
</body>
</html>