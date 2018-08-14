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
<title>スケジュール更新結果画面</title>
</head>
<body>
	<h1>スケジュール更新結果</h1>

	<%
		if (executionsql != null) {
	%>

	<p>スケジュールの更新が完了しました</p>
	<!-- 判定が終われば用済み -->
	<%
		session.removeAttribute("executionsql");
	%>



	<a href="/schedule/Main">スケジュール確認へ</a>

	<%
		} else {
	%>


	<p>スケジュールの更新に失敗しました。指定の時間にスケジュールは存在しませんでした。</p>
	>

	<a href="/schedule/Main">マイページトップへ</a>
	<a href="/schedule/EditingSchedule.jsp">再度更新を試みる</a>>

	<%
		}
	%>



</body>
</html>