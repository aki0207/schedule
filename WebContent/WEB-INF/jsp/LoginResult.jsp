<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	//セッションスコープからユーザー情報を取得
	User login_user = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>スケジュール</title>
</head>
<body>
	<h1>スケジュール管理ログイン</h1>
	<%
		if (login_user != null) {
	%>

	<p>ログインに成功しました</p>
	<p>
		ようこそ<%=login_user.getName()%>さん
	</p>
	<a href="/schedule/Main">スケジュール確認へ</a>

	<%
		} else {
	%>

	<p>ログインに失敗しました</p>
	<a href="/schedule">Topへ</a>

	<%
		}
	%>


</body>
</html>