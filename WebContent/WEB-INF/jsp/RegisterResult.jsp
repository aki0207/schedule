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
<title>ユーザー登録</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<%
		if (login_user != null) {
	%>

	<p>登録が完了しました！</p>
	<p>
		ようこそ<%=login_user.getName()%>さん
	</p>
	<a href="/schedule/Main">スケジュール確認へ</a>

	<%
		} else {
	%>

	<p>既に使用されています。ログインをお試し下さい</p>
	<a href="/schedule">ログインへ</a>

	<%
		}
	%>


</body>
</html>