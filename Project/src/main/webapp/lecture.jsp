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
    <title>���Ǹ�ƺ���</title>
    <link rel="stylesheet" href="table.css">
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--�ΰ�-->
		<header>
			<h3><a href = "main.jsp">I.Study</a></h3>
		</header>
	</div>
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
				   <td class="count"><%=lecture_count %></td>
                   <td class="price"><%=lecture_price%></td>
                   <td class="point"><%=lecture_point%></td>
                   <td class="review"><a href="review.jsp?lecture_no=<%=vo.getLecture_no() %>">������</a></td>
                   <td class="review"><a href="Course_Insert?lecture_no=<%=vo.getLecture_no() %>">����</a></td>
                   <%-- <td class="review"><a href="lectureJoinSuccess.jsp?lecture_no=<%=vo.getLecture_no() %>">����</a></td> --%>

                   <%--�ı������ <td class="review"><%=lecture_review%></td>--%>
                  <%--  <td><%=lecture_url%></td> --%>
            </tr>
            <%} %>
           
        </table>
        <div class="pages">
        <%
        
        for(int a =1; a<11;a++){ 
        	
        %>
        <a href="LectureSearchService?pages=<%=a%>&search_words="><%=a %></a>
        <%} %>
        </div>
    </div>
    <div class="foot"></div>
</body>
</html>