<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <div class="top-bar">
         <s:url id="addUrl" action="add">
	        <s:param name="mode" value="new" />
	     </s:url>
 	     <s:a href="%{addUrl}"  targets="users" cssClass="button">Add new</s:a>
         <h1>Users</h1>
         <div class="breadcrumbs"><a href="#">Homepage</a> / <a href="#">Contents</a></div>
     </div><br />
	 <div class="select-bar">
                <s:form action="search">
		            <label>
   			            <input type="text" name="searchText" />
		            </label>
		            <label>
       		            <input type="submit" name="Submit" value="Search" />
		            </label>
                </s:form>
          </div>
	
	<br/>
	<s:if test="selectedUser==null || id != null">
	
	    <div class="table">
	         <img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
	         <img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
	         <s:form action="save" validate="true" theme="smartbpm" cssClass="listing form" label="Login" >
	                 <tr>
	                     <th class="full" colspan="2">Edit</th>
	                 </tr>
                     <input type="hidden" id="selectedUser.id" name="selectedUser.id" value="<s:property value="selectedUser.id" />" />
                     <s:textfield id="name" label="User Name" theme="smartbpm" labelposition="2" name="selectedUser.name" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
                     <s:password id="password" label="Password" theme="smartbpm" labelposition="2" name="selectedUser.password" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="firstName" label="First Name" theme="smartbpm" labelposition="2" name="selectedUser.firstName" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="lastName" label="Last Name" theme="smartbpm" labelposition="2" name="selectedUser.lastName" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="phone" label="Phone" theme="smartbpm" labelposition="2" name="selectedUser.phone" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="email" label="E-mail" theme="smartbpm" labelposition="2" name="selectedUser.email" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:submit value="Save" align="center"  theme="smartbpm" cssStyle="text"/>
	         </s:form>
	     </div>
	</s:if>
 	<br/><br/><br/><br/>
	<s:if test="users.size > 0">
		<div class="table">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />

		<table class="listing" cellpadding="0" cellspacing="0">
			<tr>
				<th>User</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Phone</th>
				<th>E-mail</th>
				<th>Actions</th>
			</tr>
			<s:iterator value="users" id="user" status="id">
			<tr class="<s:if test="#id.odd == true">bg</s:if><s:else></s:else>" id="row_<s:property value="id"/>">
					<td>
						<s:property value="name" />
					</td>
					<td>
						<s:property value="firstName" />
					</td>
					<td>
						<s:property value="lastName" />
					</td>
					<td>
						<s:property value="phone" />
					</td>
					<td>
						<s:property value="email" />
					</td>
					<td>
						<s:url id="removeUrl" action="remove">
							<s:param name="id" value="id" />
						</s:url>
                        <s:url id="editUrl" action="edit">
                            <s:param name="id" value="id" />
                        </s:url>
						<s:a href="%{removeUrl}" targets="users"><img src="img/hr.gif" width="16" height="16" alt="remove"/></s:a>
                        &nbsp;
                        <s:a href="%{editUrl}" targets="users"><img src="img/edit-icon.gif" width="16" height="16" alt="edit"/></s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<div class="select">
			<strong>Other Pages: </strong>
			<select>
				<option>1</option>
			</select>
		</div>
	  </div>
	</s:if>