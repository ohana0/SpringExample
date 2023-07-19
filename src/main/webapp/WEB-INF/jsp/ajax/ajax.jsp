<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax테스트</title>

</head>
<body>
	<h1>Ajax테스트</h1>
	

	<button type="button" id="btn">버튼</button>
	
	<div id="nameDiv"></div>
	<div id="ageDiv"></div>





<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    $(document).ready(function(){
		$("#btn").on("click",function(){
			$.ajax({
				type:"get"
				,url:"/ajax/person"
				//,data:{"":""}
				,success:function(data){
					console.log(data.name);
					$("#nameDiv").text(data.name);
					$("#ageDiv").text(data.age)}
				,error:function(){
					alert("에러!!");
				}
			})
			
		});

    });
</script>
 
</body>
</html>