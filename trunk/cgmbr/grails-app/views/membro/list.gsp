
<%@ page import="com.membro.Membro" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'membro.label', default: 'Membro')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-membro" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-membro" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'membro.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'membro.status.label', default: 'Status')}" />
					
						<g:sortableColumn property="dataDeNascimento" title="${message(code: 'membro.dataDeNascimento.label', default: 'Data De Nascimento')}" />
					
						<g:sortableColumn property="email" title="${message(code: 'membro.email.label', default: 'Email')}" />
					
						<g:sortableColumn property="RG" title="${message(code: 'membro.CPF.label', default: 'CPF')}" />
						
						<g:sortableColumn property="congregacao" title="${message(code: 'membro.congregacao.label', default: 'Congregação')}" />
						
						<g:sortableColumn property="Cargo" title="${message(code: 'membro.cargo.label', default: 'Cargo')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${membroInstanceList}" status="i" var="membroInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${membroInstance.id}">${fieldValue(bean: membroInstance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: membroInstance, field: "status")}</td>
					
						<td><g:formatDate format="dd/MM/yyyy" date="${membroInstance.dataDeNascimento}" /></td>
						
						<td>${fieldValue(bean: membroInstance, field: "email")}</td>
					
						<td>${fieldValue(bean: membroInstance, field: "CPF")}</td>
						
						<td>${fieldValue(bean: membroInstance, field: "congregacao")}</td>
						
						<td>${fieldValue(bean: membroInstance, field: "cargo")}</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${membroInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
