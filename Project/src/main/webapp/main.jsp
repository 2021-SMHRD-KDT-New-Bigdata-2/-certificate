<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
    <style>
  
    </style>
    
    <link rel="stylesheet" href="1cha.css">
</head>
<body>
    <header>
        <h3></h3>
        <nav>
          <span><a href="#">ȸ������</a></span>
          <span><a href="login.jsp">�α���</a></span>
        </nav>
    </header>
      
    <main>
        <div class="title">
            <h1>STUDYNET</h1>
        </div>
        <!--�ΰ������� ��Ÿ���� ���̺�-->
        <!-- table �ΰ��� ���� ������ ��ġ��Ű�� ���� 
            div�±�(style="width:50%;float:left;")�� �����(���� div�� float left, ������-right)
            �� �ȿ� table�±׸� ����
        -->
        <!--���� ���̺��� ������ ��¦ �ű�� �; margin--->
        <div style="width:50%;float:left;">
            <table>
                <tr>
                    <td>
                        <!--��ư���� �� ���ΰ� �ƴϸ� a�±׷� �� ���ΰ�-->
                        <a href="#">
                            �ΰ�����1
                        </a>
                    </td>
                    <td>
                        �ΰ�����2
                    </td>
                </tr>
                <tr>
                    <td>
                        �ΰ�����3
                    </td>
                    <td>
                        �ΰ�����4
                    </td>
                </tr>
            </table>
        </div>
        <div style="width:50%;float:right;">
            <table>
                <tr>
                    <td>
                        ���͵�����1
                    </td>
                    <td>
                        ���͵�����2
                    </td>
                </tr>
                <tr>
                    <td>
                        ���͵�����3
                    </td>
                    <td>
                        ���͵�����4
                    </td>
                </tr>
            </table>
        </div>
    </main>   
</body>
</html>