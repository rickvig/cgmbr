<%@ page import="com.acesso.ShiroRole" %>
<%@ page import="com.congregacao.Congregacao" %>

<div class="fieldcontain ${hasErrors(bean: shiroRoleInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="shiroRole.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${shiroRoleInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: shiroRoleInstance, field: 'permissions', 'error')} ">
	<label for="permissions">
		<g:message code="shiroRole.permissions.label" default="Permissions" />
	</label>
	<g:textField name="permissions" required="" value="${shiroRoleInstance?.permissions}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: shiroRoleInstance, field: 'congregacoes', 'error')} ">
	<label for="users">
		<g:message code="shiroRole.congregacao.label" default="Congregaçoes" />
	</label>
	<g:select name="congregacoes" from="${Congregacao.list()}" optionKey="id" optionValue="nome" multiple="true"/>
</div>

