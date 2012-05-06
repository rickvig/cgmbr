<%@ page import="com.congragacao.Congregacao"%>



<div class="fieldcontain ${hasErrors(bean: congregacaoInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="congregacao.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${congregacaoInstance?.nome}" />
</div>

<fieldset class="group">
	<legend>Endere&ccedil;o da Congrega&ccedil;&atilde;o.</legend>
	<g:render template="/endereco/formEnderecoCongregacao"></g:render>
	<input type="hidden" name="membroEndereco" value="${membroInstance?.endereco?.id}" />
</fieldset>

<!-- 
<div class="fieldcontain ${hasErrors(bean: congregacaoInstance, field: 'membros', 'error')} ">
	<label for="membros">
		<g:message code="congregacao.membros.label" default="Membros" />

	</label>

	<ul class="one-to-many">
		<g:each in="${congregacaoInstance?.membros?}" var="m">
			<li>
				<g:link controller="membro" action="show" id="${m.id}">
					${m?.encodeAsHTML()}
				</g:link>
			</li>
		</g:each>
		<li class="add">
			<g:link controller="membro" action="create" params="['congregacao.id': congregacaoInstance?.id]">
				${message(code: 'default.add.label', args: [message(code: 'membro.label', default: 'Membro')])}
			</g:link>
		</li>
	</ul>
</div>
-->

