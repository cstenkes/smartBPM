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
 	     <s:a href="%{addUrl}" targets="processes" cssClass="button">Add new</s:a>
         <h1>Processes</h1>
         <div class="breadcrumbs"><a href="#">Processes</a> / <a href="#">Contents</a></div>
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
	<s:if test="process==null || id != null">
	
	    <div class="table">
	         <img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
	         <img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
	         <s:form action="save" validate="true" theme="smartbpm" cssClass="listing form" label="Login" >
	                 <tr>
	                     <th class="full" colspan="2">Edit</th>
	                 </tr>
                     <input type="hidden" id="process.id" name="process.id" value="<s:property value="process.id" />" />
                     <s:textfield id="name" label="Name" theme="smartbpm" labelposition="2" name="process.name" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
                     <s:password id="description" label="Description" theme="smartbpm" labelposition="2" name="process.description" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="user.name" label="User Name for" theme="smartbpm" labelposition="2" name="process.user.name" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="processType" label="Process Type" theme="smartbpm" labelposition="2" name="process.processType" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:textfield id="node" label="Node" theme="smartbpm" labelposition="2" name="process.node.name" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
	                 <s:submit value="Save" align="center"  theme="smartbpm" cssStyle="text"/>
	         </s:form>
	     </div>
	</s:if>
 	<br/><br/><br/><br/>
	<s:if test="processes.size > 0">
		<div class="table">
		<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
		<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />

		<table class="listing" cellpadding="0" cellspacing="0">
			<tr>
				<th>Process Name</th>
				<th>Process Type</th>
				<th>Actual State</th>
				<th>User belongs to</th>
				<th>Actions</th>
			</tr>
			<s:iterator value="processes" id="process" status="id">
			<tr class="<s:if test="#id.odd == true">bg</s:if><s:else></s:else>" id="row_<s:property value="id"/>">
					<td>
						<s:property value="name" />
					</td>
					<td>
                        <s:property value="processType.name" />
					</td>
					<td>
                        <s:property value="actualNode.state.name" />
					</td>
					<td>
                        <s:property value="user.name" />
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
                <s:if test="nodes.size > 0">
                    <s:iterator value="nodes" id="node" status="node">
                    <tr>
                        <td>
                            &nbsp;<s:property value="state.id" />
                            <s:property value="state.name" />
                        </td>
                    </tr>
	                <s:if test="attributes.size > 0">
	                    <s:iterator value="attributes" id="attribute" status="attribute">
	                    <tr>
	                        <td>
	                        <s:property value="name" />:<s:property value="value" />
	                        </td>
	                    </tr>
                        </s:iterator>
                    </s:if>
                     <tr>
                         <td>&nbsp;
                         </td>
                     </tr>
                    
                    </s:iterator>
                </s:if>
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