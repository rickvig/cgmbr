
<%@page import="com.membro.Cargo"%>
<%@ page import="com.membro.Membro"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'membro.label', default: 'Membro')} ${membroInstance?.id}" />
<title>
	<g:message code="default.show.label" args="[entityName]" />
</title>
</head>
<body>
	<a href="#show-membro" class="skip" tabindex="-1">
		<g:message code="default.link.skip.label" default="Skip to content&hellip;" />
	</a>
	<div class="nav" role="navigation">
		<ul>
			<li>
				<g:link  title="Emite carterinha de Membro para Impressão" class="report" controller="carterinha" action="emiteCartao" id="${membroInstance.id}" target="blank">
					<g:message code="default.emitiCartao.label" args="[entityName]" default="Emitir Cart&atilde;o de ${membroInstance.cargo.toString()}" />
				</g:link>
			</li>
		</ul>
	</div>
	<div id="show-membro" class="content scaffold-show" role="main">
		<h1>
			<g:message code="default.show.label" args="[entityName]" />
			<!-- Carterinha Emitida: <img src="cgmbr/web-app/images/skin/docok_24.png"/> -->
		</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>

		<ol class="property-list membro">
			<g:if test="${membroInstance?.foto}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"> <g:message code="membro.foto.label" default="Foto:" />
					</span> 
					<span class="property-value" aria-labelledby="status-label"> <!-- foto do membro 3x4 cm -> 84x114 px --> 
					<img width="84" height="114" src="${createLink(controller:'membro', action:'getFoto', id: membroInstance?.id)}" />
					</span>
				</li>
			</g:if>

			<g:if test="${membroInstance?.status}">
				<li class="fieldcontain">
					<span id="status-label" class="property-label"> <g:message code="membro.status.label" default="Status:" />
					</span> <span class="property-value" aria-labelledby="status-label"> <g:fieldValue bean="${membroInstance}" field="status" />
					</span>
				</li>
			</g:if>

			<g:if test="${membroInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"> <g:message code="membro.nome.label" default="Nome:" />
					</span> <span class="property-value" aria-labelledby="nome-label"> <g:fieldValue bean="${membroInstance}" field="nome" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.nomePai}">
				<li class="fieldcontain">
					<span id="nomePai-label" class="property-label"> <g:message code="membro.nomePai.label" default="Nome do Pai:" />
					</span> <span class="property-value" aria-labelledby="nomePai-label"> <g:fieldValue bean="${membroInstance}" field="nomePai" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.nomeMae}">
				<li class="fieldcontain">
					<span id="nomeMae-label" class="property-label"> <g:message code="membro.nomeMae.label" default="Nome da Mae:" />
					</span> <span class="property-value" aria-labelledby="nomeMae-label"> <g:fieldValue bean="${membroInstance}" field="nomeMae" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.dataDeNascimento}">
				<li class="fieldcontain">
					<span id="dataDeNascimento-label" class="property-label"> <g:message code="membro.dataDeNascimento.label" default="Data De Nascimento:" />
					</span> <span class="property-value" aria-labelledby="dataDeNascimento-label"> <g:formatDate format="dd/MM/yyyy"
							date="${membroInstance?.dataDeNascimento}" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.RG}">
				<li class="fieldcontain">
					<span id="RG-label" class="property-label"> <g:message code="membro.RG.label" default="RG:" />
					</span> <span class="property-value" aria-labelledby="RG-label"> <g:fieldValue bean="${membroInstance}" field="RG" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.CPF}">
				<li class="fieldcontain">
					<span id="CPF-label" class="property-label"> <g:message code="membro.CPF.label" default="CPF:" />
					</span> <span class="property-value" aria-labelledby="CPF-label"> <g:fieldValue bean="${membroInstance}" field="CPF" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.telefoneResidencial}">
				<li class="fieldcontain">
					<span id="telefoneResidencial-label" class="property-label"> <g:message code="membro.telefoneResidencial.label"
							default="Telefone Residencial:" />
					</span> <span class="property-value" aria-labelledby="telefoneResidencial-label"> <g:fieldValue bean="${membroInstance}"
							field="telefoneResidencial" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.telefoneComercial}">
				<li class="fieldcontain">
					<span id="telefoneComercial-label" class="property-label"> <g:message code="membro.telefoneComercial.label" default="Telefone Comercial:" />
					</span> <span class="property-value" aria-labelledby="telefoneComercial-label"> <g:fieldValue bean="${membroInstance}" field="telefoneComercial" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.telefoneCelular}">
				<li class="fieldcontain">
					<span id="telefoneCelular-label" class="property-label"> <g:message code="membro.telefoneCelular.label" default="Telefone Celular:" />
					</span> <span class="property-value" aria-labelledby="telefoneCelular-label"> <g:fieldValue bean="${membroInstance}" field="telefoneCelular" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"> <g:message code="membro.email.label" default="Email:" />
					</span> <span class="property-value" aria-labelledby="email-label"> <g:fieldValue bean="${membroInstance}" field="email" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.endereco}">
				<li class="fieldcontain">
					<span id="endereco-label" class="property-label"> <g:message code="membro.endereco.label" default="Endereco:" />
					</span> 
					<span class="property-value" aria-labelledby="endereco-label"> 
						<g:link controller="endereco" action="show"
							id="${membroInstance?.endereco?.id}">
							${membroInstance?.endereco?.encodeAsHTML()}
						</g:link>
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.naturalidade}">
				<li class="fieldcontain">
					<span id="naturalidade-label" class="property-label"> <g:message code="membro.naturalidade.label" default="Naturalidade:" />
					</span> <span class="property-value" aria-labelledby="naturalidade-label"> <g:fieldValue bean="${membroInstance}" field="naturalidade" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.estadoCivil}">
				<li class="fieldcontain">
					<span id="estadoCivil-label" class="property-label"> <g:message code="membro.estadoCivil.label" default="Estado Civil:" />
					</span> <span class="property-value" aria-labelledby="estadoCivil-label"> <g:fieldValue bean="${membroInstance}" field="estadoCivil" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.dataDeBatismo}">
				<li class="fieldcontain">
					<span id="dataDeBatismo-label" class="property-label"> <g:message code="membro.dataDeBatismo.label" default="Data De Batismo/Consagração:" />
					</span> <span class="property-value" aria-labelledby="dataDeBatismo-label"> <g:formatDate format="dd/MM/yyyy"
							date="${membroInstance?.dataDeBatismo}" />
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.congregacao}">
				<li class="fieldcontain">
					<span id="congregacao-label" class="property-label"> <g:message code="membro.congregacao.label" default="Congregacao:" />
					</span> 
					<span class="property-value" aria-labelledby="congregacao-label"> 
						<g:link controller="congregacao" action="show"
							id="${membroInstance?.congregacao?.id}">
							${membroInstance?.congregacao?.encodeAsHTML()}
						</g:link>
					</span>
				</li>
			</g:if>

			<g:if test="${membroInstance?.cargo}">
				<li class="fieldcontain">
					<span id="cargo-label" class="property-label"> <g:message code="membro.cargo.label" default="Cargo:" />
					</span> 
					<span class="property-value" aria-labelledby="cargo-label"> 
					<g:link controller="cargo" action="show"
							id="${membroInstance?.cargo?.id}">
							${membroInstance?.cargo?.encodeAsHTML()}
						</g:link>
					</span>

				</li>
			</g:if>

			<g:if test="${membroInstance?.dataDeInclusao}">
				<li class="fieldcontain">
					<span id="dataDeEmissao-label" class="property-label"> <g:message code="membro.dataDeInclusao.label" default="Data De Inclusão:" />
					</span> <span class="property-value" aria-labelledby="dataDeInclusao-label"> <g:formatDate format="dd/MM/yyyy"
							date="${membroInstance?.dataDeInclusao}" />
					</span>

				</li>
			</g:if>

		</ol>
		<g:form>
			<fieldset class="buttons">
				<g:hiddenField name="id" value="${membroInstance?.id}" />
				<g:link class="edit" action="edit" id="${membroInstance?.id}">
					<g:message code="default.button.edit.label" default="Edit" />
				</g:link>
				<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
					onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				<g:link title="Emite carterinha de Membro para Impressão" class="report" controller="carterinha" action="emiteCartao" id="${membroInstance.id}" target="blank">
					<g:message code="default.emitiCartao.label" args="[entityName]" default="Emitir Cart&atilde;o de Membro" />
				</g:link>
			</fieldset>
		</g:form>
	</div>
</body>
</html>
