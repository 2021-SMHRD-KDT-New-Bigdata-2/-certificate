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
<body class="background">
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
    <div class="articleBoard">
                <table class="article" ><!-- �ݺ����� �̿��Ͽ� ���̺��� ���� �Ͽ����ϴ�. ���߿� �����ͺ��̽����� �÷����� ������ �����ͼ� �ٿ����� ��. -->
                <tr>
                    <th>���Ǹ�</th>
                    <th>�����</th>
                    <th>��������������Ʈ</th>
                    <th>�� ���Ǽ�</th>
                    <th>����</th>
                    <th>����</th>
                    <th>�ı�</th>
                    <th>URL</th>
                    <th>ī�װ�</th>
                </tr>
        <%for(int i = 0; i<12;i++){ %>
            <tr class="boardList">
                   <td>���Ǹ�<%=i+1 %></td>
                   <td>�����</td>
                   <td>��������������Ʈ</td>
                   <td>�� ���Ǽ�</td>
                   <td>����</td>
                   <td>����</td>
                   <td>�ı�</td>
                   <td>URL</td>
                   <td>ī�װ�</td>
            </tr>
            <%} %>
           
        </table>
    </div>
</body>
</html>