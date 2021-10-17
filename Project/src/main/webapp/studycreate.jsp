<%@page import="com.model.StudyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	
	
	
	<title>StudyCreation</title>
	<link rel="stylesheet" href="table.css">
</head>

	<div style="text-align: left; margin: 0%" class="title">
		<!--�ΰ�-->
		<header>
			<h3><a href = "main.jsp">I-Study</a></h3>
		</header>
	</div>
	
	
<body>
<!-- ���͵�����â ������ ��, ������ 'Study_CreatService'�� ������, ������������ �̵�-->
<h1 class="link"><b>StudyGroup</b></h1>
    <form class="studyCreate" action="Study_CreationService">
        <div class="searchOut">
            <div class="search">
                <input type="text" placeholder="���͵� �˻�" name="search_words" class="searchInput" autocomplete="off">
                <button class="createBtn" type="submit" name="click">�����</button>
            </div>
            <br>
            <br>
            <br>
            <br>
        </div>
    </form>
    
   		<div class="articleBoard">
	<% ArrayList<StudyVO> list = (ArrayList<StudyVO>)session.getAttribute("Study"); %>

                <table class="article" ><!-- �ݺ����� �̿��Ͽ� ���̺��� ���� �Ͽ����ϴ�. ���߿� �����ͺ��̽����� �÷����� ������ �����ͼ� �ٿ����� ��. -->
                <tr>
                    <th class="no">���͵� ��ȣ</th>
                    <th class="name">���͵��</th>
                    <th class="begin">������</th>
                    <th class="end">������</th>
                    <th class="sub">���͵� ����</th>
                    <th class="place">���</th>
                    <th class="week">����</th>
                    <th class="time">�ð�</th>
                    <th class="onoff">��/��������</th>
                    <!-- <th>URL</th> -->

                </tr>
        <%for(int i = 0; i<list.size() ;i++){ %>
        <% 	StudyVO vo = list.get(i); 
			int study_no = vo.getStudy_no();
			String study_name = vo.getStudy_name();
			String study_begin = vo.getStudy_begin();
			String study_end = vo.getStudy_end();
			String study_sub = vo.getStudy_sub();
			String study_place = vo.getStudy_place();
			String study_week = vo.getStudy_week();
			String study_time = vo.getStudy_time();
			String study_onoff = vo.getStudy_onoff();
			%>

			
            <tr class="boardList">
            	   <td class="no"><%=study_no%></td>
                   <td class="name"><%=study_name%></td>
                   <td class="begin"><%=study_begin %></td>
				   <td class="end"><%=study_end %></td>
                   <td class="sub"><%=study_sub%></td>
                   <td class="place"><%=study_place%></td>
                   <td class="week"><%=study_week%></td>
                   <td class="time"><%=study_time%>"></td>
                   <td class="onoff"><%=study_onoff%></td>
            </tr>
            <%} %>
           
        </table>
    </div>
<!-- <form class="" action="Study_CreationService">
���͵����� ���� form�� �ۼ��� �� �޾ƿ���
	String study_name = request.getParameter("name");	// ���͵��
	String study_begin = request.getParameter("begin");	// ��������
	String study_end = request.getParameter("end");	// ��������
	String study_sub = request.getParameter("sub");	// ���͵����
	String study_place = request.getParameter("place");	// ���
	String study_week = request.getParameter("week");	// ����
	String study_time = request.getParameter("time");	// �ð�
	String study_onoff = request.getParameter("onoff");	// ��/�������� ������ 
	private String SM_notice;	// ���������� ���⿡�ٰ� �ۼ��ؾ� ��
	Study_CreationService���� ���� ���� �̰��� �Է��� ���̺� �ʿ�
		
	
		<table>
		
		</table>
</form> -->
</body>
</html>