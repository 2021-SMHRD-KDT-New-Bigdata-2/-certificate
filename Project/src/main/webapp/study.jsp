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
    <title>���͵� ����</title>
    <link rel="stylesheet" href="table.css">
</head>
</head>
	<div style="text-align: left; margin: 0%" class="title">
		<!--�ΰ�-->
		<header>
			<h3><a href = "main.jsp">I-Study</a></h3>
		</header>
	</div>
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
        </div>
        <div class="create">
        	<button class="createBtn" name="createClick" type="button" onclick="location.href='studycreate.jsp' ">���͵𸸵��</button>
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
	        
        <% 	StudyVO vo = list.get(i); 
	        String study_name = vo.getStudy_name(); //���͵��
	        String study_begin = vo.getStudy_begin(); //��������
	        String study_end = vo.getStudy_end(); //��������
	        String study_sub = vo.getStudy_sub(); //���͵����
	        String study_place = vo.getStudy_place(); //���
	        String study_week = vo.getStudy_week(); //����
	        String study_time =vo.getStudy_time(); //�ð�
			
	        //�׽�Ʈ�� ����
	        int study_no = vo.getStudy_no();
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
	              <td><a href="Study_Join?<%=study_no %>">����</a></td> 
	            </tr>
	            <%} %>
	        </table>
	    </div>

    </div>
    <div class="foot"></div>
</body>
</html>