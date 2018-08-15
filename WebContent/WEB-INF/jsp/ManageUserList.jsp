<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.UserSchedule"%>
<%
	//セッションスコープからユーザー情報を取得
	UserSchedule user_name_list = (UserSchedule) session.getAttribute("userNameList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>ユーザー一覧画面</title>
</head>
<body>
	<h1>ユーザー一覧</h1>

	<%
		if (user_name_list != null) {
	%>

	<p>有効なユーザー</p>

	<p>
		<%
			for (int i = 0; i < user_name_list.returnSize(user_name_list); i++) {
		%>
		<%=user_name_list.getName(i)%>
	</p>


	<%
		}
	%>

	<%
		} else {
	%>


	<p>誰一人としてユーザーが存在しません…</p>

	<%
		}
	%>

	</p>

	<p>ユーザーを…</p>

	<br>
	<a href="/schedule/UpdateUser.jsp">編集する</a>
	<a href="/schedule/DeleteUser.jsp">削除する</a>
	<br>


	<p>ログアウトしちゃう？</p>
	<a href="/schedule/ManageIndex.jsp">ぐっばいろぐあうと</a>










</body>
</html>