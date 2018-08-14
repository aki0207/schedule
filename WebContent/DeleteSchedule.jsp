
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>スケジュール削除</title>
</head>
<body>
<h1><font color = "#00800">スケジュール削除ページです</font></h1>
<form action = "/schedule/DeleteSchedule" method = "post">
削除するスケジュールの時間を入力してください:<input type = "text" name = "date"><br>
<input type = "submit" value = "スケジュールの削除">
</form>

<p>マイページトップへ</p>
<a href="/schedule/Main">戻る</a>


</body>
</html>