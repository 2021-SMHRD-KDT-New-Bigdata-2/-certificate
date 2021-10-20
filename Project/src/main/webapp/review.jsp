<%@page import="com.model.MemberVO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.model.LectureDAO"%>
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
	<div style="text-align: left; margin: 0%" class="title">
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
	</div>
<body class="background">
    <h1 class="link"><b>Review</b></h1>
    <form class="searchForm" action="LectureSearchService">
    <%
    request.setCharacterEncoding("euc-kr");
    //�޾ƿ� lecture_no�� intŸ������ �����Ͽ� ����
    int lecture_no = Integer.parseInt(request.getParameter("lecture_no"));
    LectureDAO dao = new LectureDAO();
    String[] reviewlist = dao.Lecture_SelectReview(lecture_no);
    %>
 
    </form>
	<div class="articleBoard">
	

                <table class="article" >
                <tr>
                    <th class="reviewtable">�ı�</th>
                </tr>
                <!-- ��������� �����ϱ� -->
					<%if(reviewlist!=null){ %>
	                <% for(int i=0; i < reviewlist.length; i++){%>
			        <tr>   
						<td><%=reviewlist[i] %></td>
			        </tr>
		         	<%}%>
		         	<%}else{ 
			  			//���䰡 ������� �˶� ���� 
			  			response.setContentType("text/html; charset=UTF-8");
			  			//PrintWriter out = response.getWriter();
			  			out.println("<script>alert('���䰡 �����ϴ�.'); location.href='lecture.jsp';</script>");
			  			out.flush();
		         	} %>
                </table>
    </div>
    <button class="gobackBtn" onclick="history.back()"
    style="width: 100px; height: 35px; font-size: 18px; display: block; margin: 30px auto;">�ڷΰ���</button>
    <div class="foot"></div>
</body>
</html>