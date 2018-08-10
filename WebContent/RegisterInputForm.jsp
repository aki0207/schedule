
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h1><font color = "#00800">ユーザー登録ページ</font></h1>
<form action = "/schedule/Register" method = "post">
名前&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type = "text" name = "name"><br>
ユーザーID:<input type = "text" name = "id"><br>
パスワード:<input type = "text" name = "pass"><br>
<input type = "submit" value = "登録">


<a href="/schedule/">ログインページへ戻る</a>
</form>


</body>
</html>