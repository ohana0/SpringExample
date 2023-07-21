<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add_user</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<h1>사용자 추가</h1>
	
	<label>이름</label><input type="text" name="name" id="nameInput"><br>
	<label>생년월일</label><input type="text" name="birthday" id="birthdayInput"><br>
	<label>이메일</label><input type="text" name="email" id="emailInput"><button type="button" id="duplicateBtn">중복확인</button><br>
	<label>자기소개</label><br><textarea rows="5" cols="50" name="introduce" id="introuceInput"></textarea><br>
	<button type="button" id="addBtn">추가</button>
	
	<script>
	    $(document).ready(function(){
	    	$("#duplicateBtn").on("click",function(){
	    		let email = $("#emailInput").val();
	    		if(email == ""){
	    			alert("이메일을 입력하세요");
	    			return;
	    		}
	    		
	    		$.ajax({
	    			type:"get"
	    			,url:"/ajax/user/email_confirm"
	    			,data:{"email":email}
	    			,success:function(data){
			    		if(data.isDuplicate){//중복됨 : data={"isDuplicate":true}
			    			
			    			alert("중복된이메일입니다");
			    			return;
			    		}
			    		else{//중복안됨 : data={"isDuplicate":false}
			    			alert("사용가능한 이메일입니다.");
	    					
			    		}
	    			
	    			}
	    			,error:function(){
	    				
	    				alert("중복확인 에러");
	    			}
	    		});
	    		
	    	});
			$("#addBtn").on("click",function(){
				alert();
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
							location.href ="/ajax/user/list";
						}
						else{
							alert("추가 실패!")
						}
					}
					,error:function(){
						alert("추가에러!")
					}
					
				});
				
			});
				
			
	
	    });
	</script>

</body>
</html>