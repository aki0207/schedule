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
<title>スケジュール追加結果</title>
</head>
<body>

	<%
		if (executionsql != null) {
	%>

	<p>スケジュールの追加が完了しました</p>
	<!-- 判定が終われば用済み -->
	<%
		session.removeAttribute("executionsql");
	%>
	<a href="/schedule/Main">スケジュール確認へ</a>
	
	<%
		} else {
	%>


	<p>スケジュールの追加に失敗しました。指定された時間には既にスケジュールが存在しています。</p>
	<a href="/schedule/Main">マイページトップへ</a>
	<a href="/schedule/AddSchedule.jsp">再度更新を試みる</a>>

	<%
		}
	%>

</body>
</html>