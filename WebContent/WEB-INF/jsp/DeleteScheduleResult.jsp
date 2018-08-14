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
<title>スケジュール削除完了結果</title>
</head>
<body>

	<%
		if (executionsql != null) {
	%>
	<p>スケジュールの削除が完了しました</p>
	
	<!-- 判定が終われば用済み -->
	<%
		session.removeAttribute("executionsql");
	%>


	<a href="/schedule/Main">スケジュール確認へ</a>
	
	<%
		} else {
	%>
	
	<p>スケジュールの削除に失敗しました。時間指定が誤っているか、存在しない時間を指定しています。</p>
	
	<a href="/schedule/Main">マイページトップへ</a>
	<a href="/schedule/DeleteSchedule.jsp">再度削除を試みる</a>>
	
	<%
		}
	%>


</body>
</html>