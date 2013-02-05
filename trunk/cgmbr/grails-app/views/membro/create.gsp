<%@ page import="com.membro.Membro"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'membro.label', default: 'Membro')}" />
<title>
	<g:message code="default.new.label" args="[entityName]" />
</title>
</head>
<body>
	<a href="#create-membro" class="skip" tabindex="-1">
		<g:message code="default.link.skip.label" default="Skip to content&hellip;" />
	</a>
<%--	<div class="nav" role="navigation">--%>
<%--		<ul>--%>
<%--			<li>--%>
<%--				<g:link class="list" action="list">--%>
<%--					<g:message code="default.list.label" args="[entityName]" />--%>
<%--				</g:link>--%>
<%--			</li>--%>
<%--		</ul>--%>
<%--	</div>--%>
	<div id="create-membro" class="content scaffold-create" role="main">
		<h1>
			<g:message code="default.new.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${membroInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${membroInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>>
						<g:message error="${error}" />
					</li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form action="save" enctype="multipart/form-data">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
