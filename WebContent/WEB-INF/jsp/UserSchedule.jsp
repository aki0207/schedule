<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.UserSchedule"%>
<%
	//セッションスコープからユーザー情報を取得
	UserSchedule user_schedule = (UserSchedule) session.getAttribute("user_schedule");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>スケジュール</title>
</head>
<body>
	<h1>スケジュール一覧</h1>

	<p>
		<%=user_schedule.getName()%>さんのスケジュール
	</p>

	<p>
		<%
			for (int i = 0; i < user_schedule.returnSize(user_schedule); i++) {
		%>


		<%=user_schedule.getDate(i)%>
				</p>
				
				<p>
					<%=user_schedule.getSchedule(i)%>
				</p>
			

		<%
						}
					%>
		


	</p>
	







</body>
</html>