<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>

</head>
<body>
	<div id="center-content">
		<!-- 메인 해더 -->
		<c:import url="/WEB-INF/views/includes/main-header.jsp"></c:import>
		<div>		
			<form id="joinForm" method="post" action="${pageContext.request.contextPath}/user/join">
				<table >
			      	<colgroup>
						<col style="width: 100px;">
						<col style="width: 170px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td><label for="txtId">아이디</label></td>
		      			<td><input id="txtId" type="text" name="id" placeholder="아이디를 입력하세요" required></td>
		      			<td><button id="btnIdCheck" type="button">아이디체크</button></td>
		      		</tr>
		      		<tr>
		      			<td></td>
		      			<td id="tdMsg" colspan="2" align="center"></td>
		      		</tr> 
		      		<tr>
		      			<td><label for="txtPassword">패스워드</label> </td>
		      			<td><input id="txtPassword" type="password" name="password"  value="" placeholder="패스워드를 입력하세요"></td>   
		      			<td></td>  			
		      		</tr> 
		      		<tr>
		      			<td><label for="txtUserName">이름</label> </td>
		      			<td><input id="txtUserName" type="text" name="userName"  value="" placeholder="이름을 입력하세요"></td>   
		      			<td></td>  			
		      		</tr>  
		      		<tr>
		      			<td><span>약관동의</span> </td>
		      			<td colspan="3">
		      				<input id="chkAgree" type="checkbox" name="agree" value="">
		      				<label for="chkAgree">서비스 약관에 동의합니다.</label>
		      			</td>   
		      		</tr>   		
		      	</table>
	      		<div id="btnArea">
					<button id="btnJoin" class="btn" type="submit" >회원가입</button>
				</div>
			</form>
		</div>
		<br><br>
		<!-- 메인 푸터  자리-->
		<c:import url="/WEB-INF/views/includes/main-footer.jsp"></c:import>
	</div>
</body>

<script type="text/javascript">
$("#btnJoin").on("click", function () {
	var id = $("#txtId").val();
	if(id.length < 1){
		alert("id 없음");
		return false;
	}
	var pwd = $("#txtPassword").val();
	if(id.length < 1){
		alert("Password 없음");
		return false;
	}
	var name = $("#txtUserName").val();
	if(name.length < 1){
		alert("Name 없음");
		return false;
	}
	var agree = $("#chkAgree").is(":checked");
	console.log(agree);
	if(agree == false){
		alert("약관에 동의해주세요.");
		return false;
	}
	return true;
});

$("#btnIdCheck").on("click", function() {
	//ID SAVE
	var id = $("#txtId").val();
	//입력 null check
	if(id === ""){
		alert("아이디를 입력하시오.");
		return false;
	}
	console.log("idCheck");
	console.log(id);
	//통신
	$.ajax({
		url : "${pageContext.request.contextPath}/user/idCheck",
		type : "post",
		/* contentType : "application/json", */
		data : {
			id : id
		},
		dataType : "json",
		success : function(jsonResult) {
			console.log(jsonResult);
			if (jsonResult.result == 'success') {
				if (jsonResult.data == true) {
					$("#tdMsg").css("color", "red").html(
							id + " 사용불가");
				} else {
					$("#tdMsg").css("color", "blue").html(
							id + " 사용가능");
				}
			}
			/*성공시 처리해야될 코드 작성*/
		},
		error : function(XHR, status, error) {
		}
	});
	
})
</script>
</html>