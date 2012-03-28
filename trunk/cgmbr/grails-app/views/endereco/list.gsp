
<%@ page import="com.endereco.Endereco" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'endereco.label', default: 'Endereco')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-endereco" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-endereco" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="endereco.pais.label" default="Pais" /></th>
					
						<th><g:message code="endereco.estado.label" default="Estado" /></th>
					
						<th><g:message code="endereco.cidade.label" default="Cidade" /></th>
					
						<g:sortableColumn property="cep" title="${message(code: 'endereco.cep.label', default: 'Cep')}" />
					
						<g:sortableColumn property="rua" title="${message(code: 'endereco.rua.label', default: 'Rua')}" />
					
						<g:sortableColumn property="bairro" title="${message(code: 'endereco.bairro.label', default: 'Bairro')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${enderecoInstanceList}" status="i" var="enderecoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${enderecoInstance.id}">${fieldValue(bean: enderecoInstance, field: "pais")}</g:link></td>
					
						<td>${fieldValue(bean: enderecoInstance, field: "estado")}</td>
					
						<td>${fieldValue(bean: enderecoInstance, field: "cidade")}</td>
					
						<td>${fieldValue(bean: enderecoInstance, field: "cep")}</td>
					
						<td>${fieldValue(bean: enderecoInstance, field: "rua")}</td>
					
						<td>${fieldValue(bean: enderecoInstance, field: "bairro")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${enderecoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
