<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>ȸ������</title>
</head>
<style>

</style>
<body>
    <div id= "total">
        <div id = "header" class="Profile_membership" role = "banner">
            <h1>
                <a href = "main.html" class = "h_logo">
                    <span> ����Ʈ �̸� </span>
                </a>
            </h1>

            <form id = "Profile_form" method="post" action="">
                <div id= "container" role="main">
                    <div id = "content"> 
                        <div class="c_header"> 
                            <h2>ȸ����������</h2>
                            <p class="contxt">ȸ�������� ǥ���մϴ�.</p>
                        </div>
                        <div class="Profile_content"> 
                            <div class="row_group">
                                <div class="Profile_row">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="id">���̵�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_id">
                                                        <!-- value�� ȸ���������̺��� �޾ƿ;���, ����� Ʋ��´ܰ�� ������ ���� ������� -->
                                                        <div type="text" id="id" name="id" class="int" title="ID" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                            ���̵�1
                                                        </div>
                                                            <!-- <span class="step_url"></span> -->
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="name">�̸�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_name">
                                                        <div type="text" id="name" name="name" class="int" title="NAME" maxlength="20" style="height:20px; width:200px; font-size: 16px;" readonly>
                                                            �̸�1
                                                        </div>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="pswd">��й�ȣ</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_pass" id="pswd1Img">
                                                        <input type="password" id="password" name="pswd" class="int" title="PASSWORD" maxlength="20" value="333" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="tel">��ȭ��ȣ</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_tel" id="telImg">
                                                        <input type="text" id="tel" name="tel" class="int" title="TEL" maxlength="20" value="111-2222-3333" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="address">�ּ�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_addr" id="addrImg">
                                                        <input type="text" id="address" name="address" class="int" title="ADDRESS" maxlength="20" value="333" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="field">���ɺо�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_field" id="fieldImg">
                                                        <input type="text" id="field" name="field" class="int" title="FEILD" maxlength="20" value="IT" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Profile_title">
                                                        <label for="job">����</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_job" id="jobImg">
                                                        <input type="text" id="job" name="job" class="int" title="JOB" maxlength="20" value="����" style="height:20px; width:200px; font-size: 16px;" " readonly>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>     
                                </div>

                                <div>&nbsp;</div>

                                <!-- ���� ��� �̱��� -->
                                <button>����</button>
                                <button>���ư���</button>
                            </div>
                        </div>
                    </div>
                </div>


            </form>
        </div>


    </div>
</body>
</html>