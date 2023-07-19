<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add_user</title>
</head>
<body>
	<h1>사용자 추가</h1>
	
	<label>이름</label><input type="text" name="name" id="nameInput"><br>
	<label>생년월일</label><input type="text" name="birthday" id="birthdayInput"><br>
	<label>이메일</label><input type="text" name="email" id="emailInput"><br>
	<label>자기소개</label><br><textarea rows="5" cols="50" name="introduce" id="introuceInput"></textarea><br>
	<button type="button" id="addBtn">추가</button>
	
	<script>
	    $(document).ready(function(){
			$("#addBtn").on("click",function(){
				//유효성검사
				let name = ${"#nameInput"}.val();
				let birthday= ${"#birthdayInput"}.val();
				let email = ${"#emailInput"}.val();
				let introduce = ${"#introduceInput"}.val();
				
				if(name == ""){
					alert("이름을 입력하세요.");
					return;
				}
				if(birthday == ""){
					alert("생년월일을 입력하세요.");
					return;
				}
				if(email == ""){
					alert("이메일을 입력하세요.");
					return;
				}
				if(introduce == ""){
					alert("소개를 입력하세요.");
					return;
				}
				
				$.ajax({
					type:"get"
					,url:"/ajax/user/add"
					,data:{"name":name
						,"birthday":birthday
						,"email":email
						,"introduce":introduce}
					,success:function(data){
						if(data.result == "success"){
							//리스트페이지로이동
							location.href="/ajax/user/list";
						}
						else{
							alert("추가 실패!")
						}
					}
					,error:function(){
						alert("추가에러!")
					}
					
				});
				
			})
				
			
	
	    });
	</script>
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</body>
</html>