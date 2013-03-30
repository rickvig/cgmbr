
<%@ page import="com.acesso.ShiroRole" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'controles.label', default: 'Controles')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<ul class="property-list">
			<g:each var="c" in="${controles}">
				<li class="fielscontain">
					<g:link controller="${c.key}" action="create">
						Cadastrar ${c.value}
					</g:link>
				</li>
			</g:each>
		</ul>
	</body>
</html>
