<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="1cha.css">
</head>
<body>
	<form action="LoginService" method="post">
		<div class="loginDiv">
			<h2>�α���</h2>
		</div>
		<div class="loginDiv">
			<p>���̵�</p>
		</div>
		<div class="loginDiv">
			<input type="text" class="in" name="id">
		</div>
		<div class="loginDiv">
			<p>��й�ȣ</p>
		</div>
		<div class="loginDiv">
			<input type="password" class="in" name="pw">
		</div>
		<div></div>
		<div class="loginDiv">
			<input type="submit" class="in" value="�α���">
		</div>
		<div class="loginDiv">
			<a href="#">���̵�ã��</a>
			<a href="#">��й�ȣã��</a>
		</div>
	</form>
</body>
</html>