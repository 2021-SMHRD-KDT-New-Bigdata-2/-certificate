<%@page import="com.model.memberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>
    <!--������ ����-->
    <div style="text-align : left; margin:0%" class="title">
    <!--�ΰ�, ȸ������, �α���-->
    <header>
        <h3 class="aHead">Studynet</h3>
        <nav>
          <span><a class="aHead" href="#">ȸ������</a></span>
          <span><a class="aHead" href="#">�α���</a></span>
        </nav>
    </header>
        </div>
    <main>
        <!--�ΰ�, ȸ������, �α���-->
        <div id="main">
            <h1 class="mainTitle">����Ʈ �ô�, �ְ��� ����</h1><br>
            <p>�����</p>
        </div>

        <div class="info">
            <div>
                <table  style="margin: auto;">
                    <tr>
                        <th colspan="4"><a href="lecture.jsp" class="tableLink">Lecture</a>
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <a href="#" class="info">
                                �ΰ�����1
                            </a>
                        </td>
                        <td>
                            <a href="#" class="info">
                                �ΰ�����2
                            </a>
                        </td>
                        <td>
                            <a href="#" class="info">
                                �ΰ�����3
                            </a>
                        </td>
                        <td>
                            <a href="#" class="info">
                                �ΰ�����4
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
            <div>
                <table style="margin: auto;">
                    <tr>
                        <th colspan="4"><a href="study.jsp" class="tableLink">GroupStudy</a>
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <a href="#" class="info">
                                ���͵�����1
                            </a>
                        </td>
                        <td>
                            <a href="#" class="info">
                                ���͵�����2
                            </a>
                        </td>
                        <td>
                            <a href="#" class="info">
                                ���͵�����3
                            </a>
                        </td>
                        <td>
                            <a href="#" class="info">
                                ���͵�����4
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </main>   
</body>
</html>