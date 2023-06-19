<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${user.id}/admin/basic">기본설정</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${user.id}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${user.id}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			<div id="admin-content">
			
				<table id="admin-cate-list">
				
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>
			      			<!-- <th>카테고리분류</th> -->
			      		</tr>
		      		</thead>
		      		
		      		<tbody id="cateList">
		      			<!-- 리스트 영역 -->
		      			
						<!-- 리스트 영역 -->
					</tbody>
					
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="cateName" type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input id="description" type="text" name="desc"></td>
			      		<td style="display: none;">
			      			<input type="hidden" id="blogId" value="${myBlog.id}" >
			      		</td>
		      		</tr>
		      	</table>
			
				<div id="btnArea">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	</div>
	<!-- //wrap -->
</body>

<script type="text/javascript">
$(document).ready(function() {
	
	var id = $("#blogId").val();
	//리스트 불러오기
	cateList(id);
	
	//리스트 cateList
	function cateList(id) {
		//통신
		$.ajax({
			url : "${pageContext.request.contextPath}/categoryList",
			type : "GET",
			/* contentType : "application/json", */
			data: {id : id},
			
			dataType : "json",
			success : function(jsonResult) {
				/*성공시 처리해야될 코드 작성*/
				var categoryVO = jsonResult.data;
				console.log(categoryVO);
				for(var i=0; i<jsonResult.data.length; i++){
					//등록폼 비우기
					$("#cateName").val("");
					$("#description").val("");
					//var cnt = i + 1;
					render(jsonResult.data[i], "down");
				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	}
	
	//categoryInsert
	$("#btnAddCate").on("click", function() {
		//데이터 추출
		var id = $("#blogId").val();
		var name = $("#cateName").val();
		var description = $("#description").val();
		var categoryVO = {
				id : id,
				cateName : name,
				description : description
				//cateCnt : cateCnt
				
		}
		var str = JSON.stringify(categoryVO);
		
		$.ajax({
			url : "${pageContext.request.contextPath}/categoryInsert",
			type : "post",
			contentType : "application/json",
			data : str,//JSON.stringify(guestVO),
			
			dataType : "json",
			success : function(jsonResult) {
				console.log("출력");
				console.log(jsonResult.data);
				if (jsonResult.result == "success") {
					render(jsonResult.data, "up"); //리스트 추가
					location.reload();
					//등록폼 비우기
					$("#cateName").val("");
					$("#description").val("");
				} else {
					//오류처리
				}
						/*성공시 처리해야될 코드 작성*/
				},
				error : function(XHR, status, error) {
					//$("#idCheckMsg").css("color", "blue").html(id + " 사용가능");
				}
			});
	});
	
	//deleteCategory
	$("#cateList").on("click", ".btnCateDel", function () {
		var cateNo = $(this).data("cateno");
		var id = $("#blogId").val();
		console.log(cateNo);
		var categoryVO = {
				id : id,
				cateNo : cateNo,
		}
		 
		$.ajax({
			url : "${pageContext.request.contextPath}/deleteCategory",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(categoryVO),
			
			dataType : "json",
			success : function(jsonResult) {
				console.log(jsonResult.data);
				if (jsonResult.result == "success") {
					//cateList(id);
					//$("#cate-" + cateNo).remove();
					location.reload();
				} else {
					//오류처리
				}
						//성공시 처리해야될 코드 작성
				},
				error : function(XHR, status, error) {
					//$("#idCheckMsg").css("color", "blue").html(id + " 사용가능");
				}
			}); 
	});
	
	
	//리스트 그리기
	function render(categoryVO, dir) {
		if(categoryVO !== null){
			var str = "";
			console.log(categoryVO);
			str += '<tr>'
			str += '	<td>' + categoryVO.cateCnt + '</td>'
			str += '	<td>' + categoryVO.cateName + '</td>'
			str += '	<td>' + categoryVO.postCnt + '</td>'
			str += '	<td>' + categoryVO.description + '</td>'
			str += '    <td class="text-center">'
			str += '		<img class="btnCateDel" src="${pageContext.request.contextPath}/assets/images/delete.jpg" data-cateno="' + categoryVO.cateNo + '">'
			str += '    </td>'
			str += '	<td id="cate-'+ categoryVO.cateNo + '" style="display: none;">'
			str += '</tr>'	
				
			if(dir == 'up'){
				$("#cateList").prepend(str);
			}else if(dir == 'down'){
				$("#cateList").append(str);		
			}else{
				console.error("방향오류");
			}
		}
	}

});






</script>
</html>