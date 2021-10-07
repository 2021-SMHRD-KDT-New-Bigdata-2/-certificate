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
    /*Ÿ��Ʋ�� ��Ʈ ����*/
    @import url('https://fonts.googleapis.com/css2?family=Sansita+Swashed:wght@800&display=swap');
    header {  
    height: 30px;
    padding: 1rem;
    color: white;
    font-weight: bold;
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin: 0;
    border-bottom: 1px solid black;
}
h1, p {
  margin: 0;
}
main {
  padding: 1rem;
  height: 100%;  
}
body {
  background: #EEE;
}
a { 
text-decoration:none;
color: black; 
} 
body, html {
  height: 200%;
}
.green_window {
	display: inline-block;
	width: 366px;
	border: 3px solid rgb(2, 0, 128);
    position: center;
}
.input_text {
	width: calc( 100% - 14px );
	margin: 6px 7px;
	border: 0;
	font-weight: bold;
	font-size: 16px;
	outline: none;
}
.sch_smit {
	width: 30px; height: 40px;
	margin: 0; border: 0;
	vertical-align: top;
	background: rgb(2, 0, 128);
	color: white;
	font-weight: bold;
	border-radius: 1px;
	cursor: pointer;
}
.sch_smit:hover {
	background: rgb(2, 0, 128);
}
*{
    box-sizing: border-box;
}
.parent{
    text-align: center;
}
.menu{
    float:left;
    width: 43%;
    height: 20%;
    background-color: blue;
    flex-direction : row ;
    flex-wrap : wrap ;
}
h1{
    font-family: Sansita Swashed;
    font-size: 100px;
    /*��Ʈ �׶��̼�->�̰� �ϰ� ����*/
    font-color: linear-gradient(to left, rgb(255, 77, 46), rgb(255, 155, 47));
}
.title{
    width: 100%;
    height: 400px; 
    line-height: 170px;
    /*study�� �߾����� ���������� ����*/
    vertical-align: middle;
    text-align: center;
    display:table-col;
}
table{
    width: 90%;
    height: 400px;
    border: 1px solid black;
    max-width:100%;
}
    </style>
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