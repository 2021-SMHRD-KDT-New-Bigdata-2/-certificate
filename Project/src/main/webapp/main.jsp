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
    <div style="text-align : left;" class="title">
    <header>
        <h3>Studynet</h3>
        <nav>
          <span><a href="#">ȸ������</a></span>
          <span><a href="#">�α���</a></span>
        </nav>
    </header>
    <main>
        <p>���ͳ� ���� ����Ʈ�Դϴ�.<br>�ȳ��ϼ���. ���� ���ͳ� ���Ǹ� �� �ܾ���� �𸣰ڳ׿� ����</p>
        <!--���� ���̺��� ������ ��¦ �ű�� �; margin--->
        <!--�ΰ������� ���͵� �����ִ� div-->

    </div>
        <div class="info" style="margin-left: 100px;">
            <div style="width:50%;float:left;">
            <!-- table �ΰ��� ���� ������ ��ġ��Ű�� ���� 
            div�±�(style="width:50%;float:left;")�� �����(���� div�� float left, ������-right)
            �� �ȿ� table�±׸� ����
            -->
                <table>
                    <tr>
                        <th colspan="2">Lecture
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <!--��ư���� �� ���ΰ� �ƴϸ� a�±׷� �� ���ΰ�-->
                            <a href="#">
                                �ΰ�����1
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                �ΰ�����2
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                �ΰ�����3
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                �ΰ�����4
                            </a>
                        </td>
                    </tr>
                </table>
            </div>
            <div style="width:50%;float:right;">
                <table>
                    <tr>
                        <th colspan="2">GroupStudy
                        </th>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                ���͵�����1
                            </a>
                        </td>
                        <td>
                            <a href="#">
                                ���͵�����2
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#">
                                ���͵�����3
                            </a>
                        </td>
                        <td>
                            <a href="#">
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