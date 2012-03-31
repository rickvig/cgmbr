<%@ page import="com.acesso.ShiroUser" %>



<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="shiroUser.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${shiroUserInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'passwordHash', 'error')} ">
	<label for="passwordHash">
		<g:message code="shiroUser.passwordHash.label" default="Password Hash" />
		
	</label>
	<g:textField name="passwordHash" value="${shiroUserInstance?.passwordHash}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="shiroUser.permissions.label" default="Permissions" />
		
	</label>
	
</div>

<div class="fieldcontain ${hasErrors(bean: shiroUserInstance, field: 'roles', 'error')} ">
	<label for="roles">
		<g:message code="shiroUser.roles.label" default="Roles" />
		
	</label>
	<g:select name="roles" from="${com.acesso.ShiroRole.list()}" multiple="multiple" optionKey="id" size="5" value="${shiroUserInstance?.roles*.id}" class="many-to-many"/>
</div>

