
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

<meta charset=UTF-8">
<title>管理画面</title>
</head>
<body>
	<h1>
		<font color="#00800">管理画面</font>
	</h1>
	<form action="/schedule/ManageLogin" method="post">
		ユーザーID:<input type="text" name="id"><br> パスワード:<input
			type="text" name="pass"><br> <input type="submit"
			value="ログイン">
	</form>

	<a href="/schedule/index.jsp">戻る</a>
</body>
</html>