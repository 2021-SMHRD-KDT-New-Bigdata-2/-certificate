<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Profileport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <title>ȸ������</title>
</head>
</head>
<style>

</style>
<body>
    <div id= "total">
        <center>
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
                            <h2>ȸ������</h2>
                            <p class="contxt">�Ʒ��� ��������� �Է����ּ���.</p>
                        </div>

                        <div class="Profile_content"> 
                            <div class="row_group">
                                <div class="Profile_row">
                                    <table>
                                        <tbody>
                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_id">
                                                        <label for="id">*���̵�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_id">
                                                        <input type="text" id="id" name="id" class="int" title="ID" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td colspan="2">
                                                    <!-- ����� �Է½� ���ڻ��� ����ٲ�� �����غ��� -->
                                                    <span class="step_url" style="color: red;">8��~12���� ����, ���� �������� �ۼ��ϼ���.</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_pwd">
                                                        <label for="pwd">*��й�ȣ</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_pwd" id="pwd1Img">
                                                        <input type="password" id="password" name="pwd" class="int" title="PASSWORD" maxlength="20" value="" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2">
                                                    <!-- ����� �Է½� ���ڻ��� ����ٲ�� �����غ��� -->
                                                    <span class="step_url" style="color: red;">8��~15���� ����, ����, Ư������ �������� �ۼ��ϼ���.</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_repwd">
                                                        <label for="repwd">*��й�ȣ ��Ȯ��</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_repwd" id="repwd1Img">
                                                        <input type="password" id="repassword" name="repwd" class="int" title="REPASSWORD" maxlength="20" value="" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td colspan="2">
                                                    <!-- ����� �Է½� ���ڻ��� ����ٲ�� �����غ��� -->
                                                    <span class="step_url" style="color: red;">��й�ȣ�� ���Է����ּ���.</span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_name">
                                                        <label for="name">*�̸�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_name">
                                                        <input type="text" id="name" name="name" class="int" title="NAME" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_YMD">
                                                        <label for="YMD">�������</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_yy">
                                                        <input type="text" id="yy" placeholder="��(4��)" aria-label="��" name="yy" class="int" title="YEAR" maxlength="4" style="height:20px; width:50px; font-size: 16px;">
                                                    </span>
                                                    <span class="ps_box int_mm">
                                                        <select id="mm" class="sel" aria-label="��" style="height:25px; width:50px; font-size: 16px;">
                                                            <option value>��</option>
                                                            <option value="01">1</option>
                                                            <option value="02">2</option>
                                                            <option value="03">3</option>
                                                            <option value="04">4</option>
                                                            <option value="05">5</option>
                                                            <option value="06">6</option>
                                                            <option value="07">7</option>
                                                            <option value="08">8</option>
                                                            <option value="09">9</option>
                                                            <option value="10">10</option>
                                                            <option value="11">11</option>
                                                            <option value="12">12</option>
                                                        </select>
                                                    </span>
                                                    <span class="ps_box int_dd">
                                                        <input type="text" id="dd" placeholder="��" aria-label="��" name="dd" class="int" title="DAY" maxlength="2" style="height:20px; width:50px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_sex">
                                                        <label for="sex">����</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_sex">
                                                        <select id="sex" class="sel" aria-label="����" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value>����</option>
                                                            <option value="��">��</option>
                                                            <option value="��">��</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_tel">
                                                        <label for="tel">��ȭ��ȣ</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_tel">
                                                        <input type="text" id="tel" name="tel" placeholder="000-0000-0000" class="int" title="TEL" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_address">
                                                        <label for="address">�ּ�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_address">
                                                        <input type="text" id="address" name="address" class="int" title="ADDRESS" maxlength="20" style="height:20px; width:200px; font-size: 16px;">
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_interest">
                                                        <label for="interest">���ɺо�</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_interest">
                                                        <select id="interest" class="sel" aria-label="���ɺо�" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value>���ɺо߸� �����ϼ���</option>
                                                            <option value="01">���ɺо�1</option>
                                                            <option value="02">���ɺо�2</option>
                                                            <option value="03">���ɺо�3</option>
                                                            <option value="04">���ɺо�4</option>
                                                            <option value="05">���ɺо�5</option>
                                                            <option value="06">���ɺо�6</option>
                                                            <option value="07">���ɺо�7</option>
                                                            <option value="08">���ɺо�8</option>
                                                            <option value="09">���ɺо�9</option>
                                                            <option value="10">���ɺо�10</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td width="100px">
                                                    <h3 class = "Join_job">
                                                        <label for="job">����</label>
                                                    </h3>
                                                </td>
                                                <td>
                                                    <span class="ps_box int_job">
                                                        <select id="job" class="sel" aria-label="����" style="height:30px; width:200px; font-size: 16px;">
                                                            <option value>������ �����ϼ���</option>
                                                            <option value="01">����1</option>
                                                            <option value="02">����2</option>
                                                            <option value="03">����3</option>
                                                            <option value="04">����4</option>
                                                            <option value="05">����5</option>
                                                            <option value="06">����6</option>
                                                            <option value="07">����7</option>
                                                            <option value="08">����8</option>
                                                            <option value="09">����9</option>
                                                            <option value="10">����10</option>
                                                        </select>
                                                    </span>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>

                                <div>&nbsp;</div>

                                <!-- ���� ��� �̱��� -->
                                <button style="height:50px; width:300px; font-size: 24px;">�����ϱ�</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </center> 
        </div>
    </div>  
</body>
</html>