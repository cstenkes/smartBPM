<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
		
<tiles:importAttribute name="listMenuItems" />
<tiles:importAttribute name="selected" />

<div id="header">
	<a href="index2.jsp" class="logo"><img src="img/logo.gif" alt="" /></a>
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
