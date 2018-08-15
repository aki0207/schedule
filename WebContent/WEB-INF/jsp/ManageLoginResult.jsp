<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	//セッションスコープからユーザー情報を取得
	User login_user = (User) session.getAttribute("loginManager");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>管理ログイン画面</h1>
	<%
		if (login_user != null) {
	%>

	<p>ログインに成功しました</p>
	<p>
		ようこそ管理ページへ
	</p>
	<a href="/schedule/ManageMain">ユーザー一覧へ</a>

	<%
		} else {
	%>

	<p>ログインに失敗しました</p>
	<a href="/schedule/ManageIndex.jsp">管理ログインページへ</a>

	<%
		}
	%>


</body>
</html>