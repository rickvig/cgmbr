<%@page import="com.congregacao.Congregacao"%>
<%@page import="com.membro.Membro"%>
<%@page import="java.util.Calendar"%>

<script type="text/javascript">
	$(document).ready(function(){
		$("#cpf").mask("999.999.999-99");
	});
</script>

<g:set var="year" value="${Calendar.getInstance().get(Calendar.YEAR)}" />

<g:if test="${membroInstance.id}">
	<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'status', 'error')} required">
		<label for="status">
			<g:message code="membro.status.label" default="Status" />
			<span class="required-indicator">*</span>
		</label>
		<g:select name="status" from="${membroInstance.constraints.status.inList}" required="" value="${membroInstance?.status}"
			valueMessagePrefix="membro.status" />
	</div>
</g:if>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="membro.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" required="" value="${membroInstance?.nome}" />
</div>

<div>
	<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'nomePai', 'error')} ">
		<label for="nomePai">
			<g:message code="membro.nomePai.label" default="Nome Pai" />

		</label>
		<g:textField name="nomePai" value="${membroInstance?.nomePai}" />
	</div>

	<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'nomeMae', 'error')} ">
		<label for="nomeMae">
			<g:message code="membro.nomeMae.label" default="Nome Mae" />

		</label>
		<g:textField name="nomeMae" value="${membroInstance?.nomeMae}" />
	</div>
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'dataDeNascimento', 'error')} required">
	<label for="dataDeNascimento">
		<g:message code="membro.dataDeNascimento.label" default="Data De Nascimento" />
		<span class="required-indicator">*</span>
	</label>

	<g:datePicker name="dataDeNascimento" precision="day" value="${membroInstance?.dataDeNascimento}" years="${1900..year}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'RG', 'error')}">
	<label for="RG">
		<g:message code="membro.RG.label" default="RG" />
	</label>
	<g:textField name="RG" value="${membroInstance?.RG}" maxlength="12"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'CPF', 'error')}">
	<label for="CPF">
		<g:message code="membro.CPF.label" default="CPF"/>
	</label>
	<input type="text" id="cpf" name="CPF" value="${membroInstance?.CPF}" maxlength="14"/>
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'telefoneResidencial', 'error')} ">
	<label for="telefoneResidencial">
		<g:message code="membro.telefoneResidencial.label" default="Telefone Residencial" />

	</label>
	<g:textField name="telefoneResidencial" value="${membroInstance?.telefoneResidencial}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'telefoneCelular', 'error')} ">
	<label for="telefoneCelular">
		<g:message code="membro.telefoneCelular.label" default="Telefone Celular" />
	</label>
	<g:textField name="telefoneCelular" value="${membroInstance?.telefoneCelular}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'telefoneComercial', 'error')} ">
	<label for="telefoneComercial">
		<g:message code="membro.telefoneComercial.label" default="Telefone Comercial" />

	</label>
	<g:textField name="telefoneComercial" value="${membroInstance?.telefoneComercial}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'email', 'error')} ">
	<label for="email">
		<g:message code="membro.email.label" default="Email" />

	</label>
	<g:field type="email" name="email" value="${membroInstance?.email}" />
</div>

<fieldset class="group">
	<legend>Endere&ccedil;o do Membro.</legend>
	<g:render template="/endereco/formEnderecoMembro"></g:render>
	<input type="hidden" name="membroEndereco" value="${membroInstance?.endereco?.id}" />
</fieldset>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'naturalidade', 'error')} ">
	<label for="naturalidade">
		<g:message code="membro.naturalidade.label" default="Naturalidade" />

	</label>
	<g:textField name="naturalidade" value="${membroInstance?.naturalidade}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'estadoCivil', 'error')} required">
	<label for="estadoCivil">
		<g:message code="membro.estadoCivil.label" default="Estado Civil" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="estadoCivil" from="${membroInstance.constraints.estadoCivil.inList}" required="" value="${membroInstance?.estadoCivil}"
		valueMessagePrefix="membro.estadoCivil" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'dataDeBatismo', 'error')} ">
	<label for="dataDeBatismo">
		<g:message code="membro.dataDeBatismo.label" default="Data De Batismo/Consagração" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dataDeBatismo" required="" precision="day" value="${membroInstance?.dataDeBatismo}" default="none" noSelection="['': '']" years="${year..1900}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'congregacao', 'error')} ">
	<label for="congregacao">
		<g:message code="membro.congregacao.label" default="Congregacao" />

	</label>
	<g:select id="congregacao" name="congregacao.id" from="${com.congregacao.Congregacao.list()}" required="" 
			value="${membroInstance?.congregacao?.id}" 
			optionKey="id"
	/>
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'cargo', 'error')} required">
	<label for="cargo">
		<g:message code="membro.cargo.label" default="Cargo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cargo" name="cargo.id" from="${com.membro.Cargo.list()}" required="" 
			value="${membroInstance?.cargo?.id}" 
			optionKey="id"
		/>
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'foto', 'error')} required">
	<label for="foto">
		<g:message code="membro.foto.label" default="Foto" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="foto" name="foto" />
</div>





