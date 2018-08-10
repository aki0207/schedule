
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>スケジュール編集</title>
</head>
<body>
<h1><font color = "#00800">スケジュール編集ページです</font></h1>
<form action = "/schedule/UpdateSchedule" method = "post">
編集するスケジュールの時間を入力してください:<input type = "text" name = "date"><br>
スケジュールの変更内容を入力してください:<input type = "text" name = "schedule"><br>
<input type = "submit" value = "スケジュールの更新">
</form>

<p>ユーザー登録はこちら</p>
<a href="/schedule/RegisterInputForm.jsp">登録へ</a>

</body>
</html>