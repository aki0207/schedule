<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Execution"%>

<%
	//セッションスコープからsql実行履歴を取得
	Execution executionsql = (Execution) session.getAttribute("executionsql");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>ユーザー削除完了結果</title>
</head>
<body>

	<%
		if (executionsql != null) {
	%>
	<p>ユーザーの削除が完了しました</p>
	
	<!-- 判定が終われば用済み -->
	<%
		session.removeAttribute("executionsql");
	%>


	<a href="/schedule/ManageMain">ユーザー一覧画面へ</a>
	
	<%
		} else {
	%>
	
	<p>ユーザーの削除に失敗しました。指定のユーザーは存在しません。</p>
	
	<a href="/schedule/ManageUserList.jsp">管理画面トップへ</a>
	<a href="/schedule/DeleteUser.jsp">再度削除を試みる</a>>
	
	<%
		}
	%>


</body>
</html>