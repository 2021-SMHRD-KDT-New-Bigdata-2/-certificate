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
                    <td colspan="2"><button type="submit" class="mkBtn">�����</button></td>
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