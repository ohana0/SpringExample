<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 입력</title>
</head>
<body>
	<form method="post" action="/jsp/user/add">
		<label>이름</label><input type="text" name="name">
		<label>생년월일</label><input type="text" name="birthday">
		<label>이메일</label><input type="text" name="email">
		<label>자기소개</label><textarea rows="5" cols="50" name="introduce"></textarea>
		<button type="submit">추가</button>
	</form>
</body>
</html>