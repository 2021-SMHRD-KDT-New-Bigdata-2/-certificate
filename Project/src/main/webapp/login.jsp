<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="main.css">
</head>
<body>
	<form action="LoginService" method="post">
		<div class="loginDiv" style="margin-top: 50px;margin-bottom: 50px">
			<h1 class="loginlogo">login</h1>
		</div>
        <table id="logintable">
            <tr>
                <td class="loginDiv">���̵�</td>
                <td class="loginDiv"><input type="text" class="in" name="id"></td>
            </tr>
            <tr>
                <td class="loginDiv">��й�ȣ</td>
                <td class="loginDiv"><input type="password" class="in" name="pw"></td>
            </tr>
            <tr>
                <td colspan="2" class="findid">
                    <div style="float:left; text-align:center; margin-left:40px;"><a href="#">���̵�ã��</a></div>
                    <div style="float:left; text-align:center; margin-left:40px;"><a href="#">��й�ȣã��</a></div>
                </td>
            </tr>
        </table>
		<div ></div>
		<div class="loginDiv" style="margin-top: 30px;">
			<input type="submit" class="in" value="�α���">
		</div>
		<div >
			
			
		</div>
	</form>
</body>
</html>