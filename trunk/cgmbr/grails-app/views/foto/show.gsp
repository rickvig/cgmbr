
<%@ page import="com.membro.Foto"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'foto.label', default: 'Foto')}" />
<title>
	<g:message code="default.show.label" args="[entityName]" />
</title>
</head>
<body>
	<a href="#show-foto" class="skip" tabindex="-1">
		<g:message code="default.link.skip.label" default="Skip to content&hellip;" />
	</a>
	<div class="nav" role="navigation">
		<ul>
			<li>
				<g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link>
			</li>
			<li>
				<g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link>
			</li>
		</ul>
	</div>
	<div id="show-foto" class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<ol class="property-list foto">

			<g:if test="${fotoInstance?.myFile}">
				<li class="fieldcontain">
					<span id="myFile-label" class="property-label">
						<g:message code="foto.myFile.label" default="My File" />
						<img src="${createLink(controller:'foto', action:'image', id: fotoInstance.id)}"/>
					</span>
				</li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${fotoInstance?.id}" />
				<g:link class="edit" action="edit" id="${fotoInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
