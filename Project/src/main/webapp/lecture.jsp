<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="table.css">
</head>
<body>
    <h1><b>Lecture</b></h1>
    <table class="certificate" style="margin-top: 10px; margin-bottom: 30px;">
        <tr>
            <%for(int i =0, k = 0 ; i<4;i++){ %>
            
            	<td>
            		<%for(int j = 0; j<3; j++){ %>
            			<input type="radio" value="" name="certificate">�ڰ���<%=k+1 %><br>
            			<%k++; %>
            		<%} %>
            	</td>
            <%} %>
           
        </tr>
    </table>
    <div>
               <table><!-- �ݺ����� �̿��Ͽ� ���̺��� ���� �Ͽ����ϴ�. ���߿� �����ͺ��̽����� �÷����� ������ �����ͼ� �ٿ����� ��. -->

                <th>���Ǹ�</th>
                <th>���������ο�</th>
                <th>��������������Ʈ</th>
                <th>�Ѱ��Ǽ�</th>
                <th>�ѽð�</th>
                <th>�����Ⱓ</th>
                <th>�������</th>
        <%for(int i = 0; i<12;i++){ %>
            <tr>
                <td>���Ǹ�<%=i+1 %></td>
                <td>���������ο�</td>
                <td>��������������Ʈ</td>
                <td>�Ѱ��Ǽ�</td>
                <td>�ѽð�</td>
                <td>�����Ⱓ</td>
                <td>�������</td>
            </tr>
            <%} %>
           
        </table>
    </div>
</body>
</html>