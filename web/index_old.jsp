<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<jsp:include page="pages/htmlHeader.jsp"/>
	<body>
	<div id="main">
	<jsp:include page="pages/mainMenu.jsp"/>
	<div id="middle">
		<jsp:include page="pages/leftMenu.jsp"/>
		<div id="center-column">
			<br/><br/><br/><br/><br/><br/>
			<jsp:include page="pages/login.jsp"/>
		</div>
		<jsp:include page="pages/info.jsp"/>
	</div>
	<jsp:include page="pages/footer.jsp"/>
</div>
</body>
</html>