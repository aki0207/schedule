
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>

<meta charset=UTF-8">
<title>スケジュール管理</title>
</head>
<body>
	<h1>
		<font color="#00800">スケジュール管理</font>
	</h1>
	<form action="/schedule/Login" method="post">
		ユーザーID:<input type="text" name="id"><br> パスワード:<input
			type="text" name="pass"><br> <input type="submit"
			value="ログイン">
	</form>

	<p>ユーザー関連はこちら</p>
	<a href="/schedule/RegisterInputForm.jsp">登録へ</a>
	<a href="/schedule/ManageIndex.jsp">管理画面へ</a>
</body>
</html>