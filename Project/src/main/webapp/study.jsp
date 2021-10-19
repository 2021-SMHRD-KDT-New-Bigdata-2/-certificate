<%@page import="com.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.StudyVO"%>
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
	<title>���͵� ����</title>
	<script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="table.css">
</head>
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
	<div>
	    <h1 class="link"><b>Study</b></h1>
	    <div class="searchOut">
	    	<form class="searchForm" action="StudySearchService">
		        <div class="searchOut">
		            <div class="search">
		                <input type="text" placeholder="���͵� �˻�" name="search_words" class="searchInput" autocomplete="off">
		                <button class="searchBtn" type="submit" name="click">�˻�</button>
		            </div>
			        <div class="create">
			        	<button class="createBtn" name="createClick" type="button" onclick="location.href='studycreate.jsp' ">���͵𸸵��</button>
			        </div>
		        </div>
	        </form>
	        
	    </div>
	    <div class="articleBoard">
	    <% ArrayList<StudyVO> list = (ArrayList<StudyVO>)session.getAttribute("Study"); %>
	        <table class="article">
	            <tr>
	                <th>����</th>
	                <th>���͵��</th>
	                <th>��������</th>
	                <th>��������</th>
	                <th>���͵� ����</th>
	                <th>���</th>
	                <th>����(��ȭ�����)</th>
	                <th>�ð�(���νð� �ð�����)</th>
	                <th>���͵���</th>
	            </tr>
	            
	        <%for(int i = 0; i<list.size() ;i++){ %>
	        
        <% 	StudyVO vo2 = list.get(i); 
	        String study_name = vo2.getStudy_name(); //���͵��
	        String study_begin = vo2.getStudy_begin(); //��������
	        String study_end = vo2.getStudy_end(); //��������
	        String study_sub = vo2.getStudy_sub(); //���͵����
	        String study_place = vo2.getStudy_place(); //���
	        String study_week = vo2.getStudy_week(); //����
	        String study_time =vo2.getStudy_time(); //�ð�
			
	        //�׽�Ʈ�� ����
	        int study_no = vo2.getStudy_no();
			%><!-- �ݺ����� �̿��Ͽ� ���̺��� ���� �Ͽ����ϴ�. ���߿� �����ͺ��̽����� �÷����� ������ �����ͼ� �ٿ����� ��. -->
	            <tr class="boardList">
	                <td><%=i+1 %></td>
	                <td><%=study_name %></td>
	                <td><%=study_begin %></td>
	                <td><%=study_end %></td>
	                <td><%=study_sub %></td>
	                <td><%=study_place %></td>
	                <td><%=study_week %></td>
	                <td><%=study_time %></td>
	                
	                <!-- ���ɵ� Study_Join.java�� STUDY_NO�� ������ ��-->
	              <td class="select"><a href="Study_Join?study_no=<%=study_no %>">����</a></td> 
	            </tr>
	            <%} %>
	        </table>
	    </div>

    </div>
	<button class="gobackBtn" onclick="document.location.href='main.jsp'"
    style="width: 80px; height: 25px; font-size: 15px; display: block; margin: 30px auto;">Ȩ����</button>
    <div class="foot"></div>
</body>
</html>