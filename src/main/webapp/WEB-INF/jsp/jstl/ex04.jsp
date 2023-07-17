<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 함수 라이브러리</title>
</head>
<body>
	<c:set var="string1" value="No pain. No gain./"/>
	
	<h4>길이: ${fn:length(string1) }</h4>
	
	<h4>No가 존재하는지? ${fn:contains(string1,"No")} </h4>
	<h4>No로 시작하는지? ${fn:startsWith(string1,"No") }</h4>
	<h4>gain.으로 끝나는지? ${fn:endsWith(string1,"gain.") }</h4>
	
	<c:set var="string2" value="I love chicken"/>
	<h4>${fn:replace(string2,"chicken","bread") }</h4>
	<h4>${string2 }</h4>
	
	<h4>${fn:substring(string2,2,6) }</h4>
	
	<h4>${fn:split(string2," ")[2] }</h4>
	
	<c:set var="string3" value="             hello         "/>
	<textarea>${string3 }</textarea>
	<textarea>${fn:trim(string3) }</textarea>
	
</body>
</html>