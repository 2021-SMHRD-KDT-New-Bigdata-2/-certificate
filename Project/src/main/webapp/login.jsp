<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
    	.in {
				margin: auto;
    			width:50%;
    		}
    	div{
    	text-align: center;
    		margin:auto;
    		width:50%;
    		padding:5px;
    	}
   		
    </style>
</head>
<body>
	<form action="LoginService" method="post">
		<div>
		<p>���̵�</p>
		</div>
		<div>
		<input type="text" class="in" name="id">
		</div>
		<div>
		<p>��й�ȣ</p>
		</div>
		<div>
		<input type="password" class="in" name="pw">
		</div>
		<div>
		</div>
		<div>
		<input type="submit" class="in" value="�α���">
		</div>
	</form>
</body>
</html>