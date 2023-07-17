<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL core</h1>
	<h3>변수만들기</h3>
	<%-- int number1 = 100; --%>
	<c:set var="number1" value="100"/>
	<%-- int number2=200 --%>
	<c:set var="number2">200</c:set>
	
	<h4>숫자1: ${number1 }</h4>
	<h4>숫자2: ${number2 }</h4>
	
	<h3>변수 출력하기</h3>
	<h4>숫자1: <c:out value="100"/></h4>
	<h4>숫자2: <c:out value="${number1 }"/></h4>
	
	<%-- <script> alert("안녕")</script> --%>
	<c:out value="<script> alert('안녕')</script>" escapeXml="true"/>
	
	<h3>조건문</h3>
	
	<%--if(true){ --%>
	<c:if test="true">
		<h4>참이다 포함!</h4>
	</c:if>
	
	<%-- if(number1>50){ --%>
	<c:if test="${number1 > 50}">
	
		<h4>number1이 50보다크네</h4>
	</c:if>
	
	<%-- if(number1==100){ --%>
	<c:if test="${number1 eq 100 }">
		<h4>number1이 100이네!</h4>
	</c:if>
	
	<%-- if(number1!=100){ --%>
	<c:if test="${number1 ne 100 }">
		<h4>100과 같지않다!</h4>
	</c:if>
	
	<%-- if(number3 == null){ --%>
	<c:if test="${empty number3 }">
	<%-- null, 변수가 없다, 리스트나 맵이 비어있다 --%>
		<h4>number3은 없다</h4>
	</c:if>
	
	<c:if test="${not empty number2 }">
		<h4>는 안비어있다</h4>
	</c:if>
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>