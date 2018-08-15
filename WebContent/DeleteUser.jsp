
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>スケジュール削除</title>
</head>
<body>
<h1><font color = "#00800">ユーザー削除ページです</font></h1>
<form action = "/schedule/DeleteUser" method = "post">
削除するユーザー名を入力してください:<input type = "text" name = "name"><br>
<input type = "submit" value = "ユーザーの削除">
</form>

<p>管理画面トップへ</p>
<a href="/schedule/ManageUserList.jsp">戻る</a>


</body>
</html>