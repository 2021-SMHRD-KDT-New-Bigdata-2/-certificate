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
    <div class="foot"></div>
</body>
</html>