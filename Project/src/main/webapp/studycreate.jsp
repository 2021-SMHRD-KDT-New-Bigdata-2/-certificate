<%@page import="com.model.MemberVO"%>
<%@page import="com.model.StudyVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<title>StudyCreation</title>
    <script src="https://kit.fontawesome.com/88d879a5c8.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="studycreate.css">
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
	
	
<body>
<!-- ���͵�����â ������ ��, ������ 'Study_CreatService'�� ������, ������������ �̵�-->
<h1 class="link"><b>MakeStudyGroup</b></h1>

    <div>
        <form action="Study_CreationService">
            <table class="tableBasic">
                <tr>
                    <td class="tableTh">���͵��</td>
                    <td class="tableTd"><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td class="tableTh">��������</td>
                    <td class="tableTd"><input type="date" name="begin"></td>
                </tr>
                <tr>
                    <td class="tableTh">��������</td>
                    <td class="tableTd"><input type="date" name="end"></td>
                </tr>
                <tr>
                    <td class="tableTh">���͵����</td>
                    <td class="tableTd"><input type="text" name="sub"></td>
                </tr>
                <tr>
                    <td class="tableTh">���</td>
                    <td class="tableTd"><input type="text" name="place"></td>
                </tr>
                <tr>
                    <td class="tableTh">����</td>
                    <td class="tableTd"><select name="week" id="mm" class="sel" aria-label="��" style="height:25px; width:50px; font-size: 16px;">
                                        <option value="��">��</option>
                                        <option value="ȭ">ȭ</option>
                                        <option value="��">��</option>
                                        <option value="��">��</option>
                                        <option value="��">��</option>
                                        <option value="��">��</option>
                                        <option value="��">��</option>
                                        </select></td>
                </tr>
                <tr>
                    <td class="tableTh">�ð�</td>
                    <td class="tableTd"><input type="text" name="time"></td>
                </tr>
                <tr>
                    <td colspan="2">
                    <button type="submit" class="mkBtn">�����</button>
                            <button type="button" class="gobackBtn" onclick="history.back()"
    style="width: 75px; height: 30px; display: inline-block; margin: 10px auto; border: 0px; background: #495057; color: #e9ecef; outline: none;">�ڷΰ���</button>
                    </td>
                    
                </tr>
            </table>
        </form>

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