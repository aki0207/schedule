
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>スケジュール追加</title>
</head>
<body>
<h1><font color = "#00800">スケジュール追加</font></h1>
<form action = "/schedule/AddSchedule" method = "post">
スケジュールの日・時間:<input type = "text" name = "date"><br>
スケジュールの内容&nbsp;&nbsp;&nbsp;&nbsp;:<input type = "text" name = "schedule"><br>
<input type = "submit" value = "追加">
</form>

<p>マイページトップへ</p>
<a href="/schedule/Main">戻る</a>

</body>
</html>