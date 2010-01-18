<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<tiles:importAttribute name="listMenuItems" />
<tiles:importAttribute name="selected" />

<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <tiles:insertAttribute name="htmlHeader"/>
<body>
	<div id="main">
		<div id="header">
			<a href="index2.jsp" class="logo"><img src="img/logo.gif" alt="Brevissimus Co. Smart BPM" /></a>
			<ul id="top-navigation">
			<c:forEach var="item" items="${listMenuItems}">
			  <c:if test="${item.value == selected}">
				  <li class="active"><span><span>${item.tooltip}</span></span><br/></li>
			  </c:if>
			  <c:if test="${item.value != selected}">
				<li><span><span><a href="${item.link}">${item.tooltip}</a></span></span></li>
			  </c:if>
			</c:forEach>
			</ul>
		</div>
		<div id="middle">
			<tiles:insertAttribute name="leftMenu"/>
			<div id="center-column">
				<tiles:insertAttribute name="content"/>
			</div>
			<tiles:insertAttribute name="info"/>
		</div>
		<tiles:insertAttribute name="footer"/>
	</div>
</body>
</html>