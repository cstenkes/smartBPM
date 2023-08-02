<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="table">
	<img src="img/bg-th-left.gif" width="8" height="7" alt="" class="left" />
	<img src="img/bg-th-right.gif" width="7" height="7" alt="" class="right" />
	<s:form action="userAdmin/login" validate="true" theme="smartbpm" cssClass="listing form" label="Login" >
			<tr>
				<th class="full" colspan="2">Login</th>
			</tr>
			<s:textfield id="name" label="User name" theme="smartbpm" labelposition="2" name="selectedUser.name" tdFirstClass="first" tdLastClass="last" cssClass="text"  />
			<s:password id="password" label="Password" theme="smartbpm" name="selectedUser.password" tdFirstClass="first" trClass="bg" tdLastClass="last" cssClass="text" />
    		<s:submit value="Go" align="center"  theme="smartbpm" cssStyle="text"/>
	</s:form>
</div>
