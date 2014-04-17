
<%@page import="com.membro.Cargo"%>
<%@ page import="com.membro.Membro"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'membro.label', default: 'Membro')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>

<style type="text/css">
	td.align-center, th.align-center{
		text-align: center;	
	}
</style>

<g:javascript library="jquery" plugin="jquery" />

<script type="text/javascript">
	$("#checkAll").change(function() {
		$('.cb').attr("checked", $(this).is(':checked'));
	})
</script>

</head>
<body>
	<g:form method="post" controller="carterinha">
		<a href="#list-membro" class="skip" tabindex="-1"><g:message
				code="default.link.skip.label" default="Skip to content&hellip;" /></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" action="listFilterBy"
						params="${[filterBy: Cargo.MEMBRO]}">
						<g:message code="default.list.membro.label" args="[entityName]"
							default="Membros" />
					</g:link></li>
				<li><g:link class="list" action="listFilterBy"
						params="${[filterBy: Cargo.MINISTRO]}">
						<g:message code="default.list.ministro.label" args="[entityName]"
							default="Ministros" />
					</g:link></li>
			</ul>
		</div>
		<div id="list-membro" class="content scaffold-list" role="main">
			<h1>
				<g:message code="default.list.label" args="[entityName]" />
			</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">
					${flash.message}
				</div>
			</g:if>
			<g:if test="${flash.error}">
				<div class="errors" role="status">
					${flash.error}
				</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<th> ${message(code: 'membro.id.label', default: 'N°')} </th>

						<th> ${message(code: 'membro.nome.label', default: 'Nome')} </th>

						<th> ${message(code: 'membro.cargo.label', default: 'Cargo')} </th>

						<th> ${message(code: 'membro.congregacao.label', default: 'Congregação')} </th>

						<th> ${message(code: 'membro.status.label', default: 'Status')} </th>

						<th class="align-center">
							Imprimir Carterinha 
							<span>
								<input id="checkAll" type="checkbox" />
							</span>
						</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${membroInstanceList}" status="i" var="membroInstance">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td>
								${fieldValue(bean: membroInstance, field: "id")}
							</td>

							<td><g:link action="show" id="${membroInstance.id}">
									${fieldValue(bean: membroInstance, field: "nome")}
								</g:link></td>

							<td><g:link controller="cargo" action="show"
									id="${membroInstance.cargo.id}">
									${fieldValue(bean: membroInstance, field: "cargo")}
								</g:link></td>

							<td>
								${fieldValue(bean: membroInstance, field: "congregacao")}
							</td>

							<td>
								${fieldValue(bean: membroInstance, field: "status")}
							</td>

							<td class="align-center" ><g:checkBox class="cb" name="imprime-${membroInstance.id}" checked="false" /></td>
						</tr>
					</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${membroInstanceTotal}" action="listFilterBy" params="${[filterBy: filterBy]}"/>
			</div>
			<fieldset class="buttons">
				<input type="hidden" name="filterBy" value="${filterBy}">
				<g:actionSubmit class="report" action="emiteCartoes"
					value="${message(code: 'default.button.report.label', default: 'Imprimir Carterinhas')}"
					target="blank" />
			</fieldset>
		</div>
	</g:form>
</body>
</html>
