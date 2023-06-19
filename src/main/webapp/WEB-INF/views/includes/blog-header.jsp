<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div id="header" class="clearfix">
		
			<c:choose>
	            <c:when test="${list.blog ne null}">
	                <!-- 맵 형식인 경우 -->
					<h1><a href="${pageContext.request.contextPath}/${list.blog.id}">${list.blog.blogTitle}</a></h1>
	                
	            </c:when>
	            <c:otherwise>
	                <!-- 객체 형식인 경우 -->
					<h1><a href="${pageContext.request.contextPath}/${myBlog.id}">${myBlog.blogTitle}</a></h1>
	                
	            </c:otherwise>
	        </c:choose>
		
		
			<ul class="clearfix">
				
				<c:choose>
					<c:when test="${!empty user.id}">
						<!-- 로그인 후 메뉴 -->
						<!-- 자신의 블로그일때만 관리 메뉴가 보인다. -->
						<li><a class="btn_s" href="${pageContext.request.contextPath}/${user.id}/admin/basic">내블로그 관리</a></li>
						<li><a class="btn_s" href="${pageContext.request.contextPath}/user/logOut">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<!-- 로그인 전 메뉴 -->
						<li><a class="btn_s" href="${pageContext.request.contextPath}/user/login">로그인</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
		<!-- //header -->
		