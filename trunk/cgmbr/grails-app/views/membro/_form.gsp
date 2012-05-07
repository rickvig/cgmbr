<%@page import="com.congragacao.Congregacao"%>
<%@ page import="com.membro.Membro"%>

<%--<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>--%>
<%--<script type="text/javascript" src="http://jquery-joshbush.googlecode.com/files/jquery.maskedinput-1.2.1.pack.js"></script>--%>
<%--<script type="text/javascript">--%>
<%--	$(function() {--%>
<%--		$("#cpf").mask("999.999.999-99");--%>
<%----%>
<%--		// Contents of textboxes will be selected when receiving focus.--%>
<%--		$("input[type=text]").focus(function() {--%>
<%--			$(this).select();--%>
<%--		});--%>
<%--	});--%>
<%--</script>--%>

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

	<%--<script>--%>
	<%--	$(function() {--%>
<%--		var date = new Date();--%>
<%--		var yearAge = date.getFullYear()-100;--%>
<%--		var year = date.getFullYear();--%>
<%----%>
<%--		$( "#datepicker" ).datepicker({--%>
<%--			yearRange: yearAge+":"+year,//   "2000:2010",--%>
<%--			changeMonth: true,--%>
<%--			changeYear: true--%>
<%--		});--%>
<%--	});--%>
	<%--</script>--%>

	<%--	<input id="datepicker" type="date" value="${membroInstance?.dataDeNascimento}">--%>

	<g:datePicker name="dataDeNascimento" precision="day" value="${membroInstance?.dataDeNascimento}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'RG', 'error')} required">
	<label for="RG">
		<g:message code="membro.RG.label" default="RG" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="RG" required="" value="${membroInstance?.RG}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'CPF', 'error')} required">
	<label for="CPF">
		<g:message code="membro.CPF.label" default="CPF" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField id="cpf" name="CPF" required="" value="${membroInstance?.CPF}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'telefoneResidencial', 'error')} ">
	<label for="telefoneResidencial">
		<g:message code="membro.telefoneResidencial.label" default="Telefone Residencial" />

	</label>
	<g:textField name="telefoneResidencial" value="${membroInstance?.telefoneResidencial}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'telefoneComercial', 'error')} ">
	<label for="telefoneComercial">
		<g:message code="membro.telefoneComercial.label" default="Telefone Comercial" />

	</label>
	<g:textField name="telefoneComercial" value="${membroInstance?.telefoneComercial}" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'telefoneCelular', 'error')} ">
	<label for="telefoneCelular">
		<g:message code="membro.telefoneCelular.label" default="Telefone Celular" />

	</label>
	<g:textField name="telefoneCelular" value="${membroInstance?.telefoneCelular}" />
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
		<g:message code="membro.dataDeBatismo.label" default="Data De Batismo" />

	</label>
	<g:datePicker name="dataDeBatismo" precision="day" value="${membroInstance?.dataDeBatismo}" default="none" noSelection="['': '']" />
</div>

<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'congregacao', 'error')} ">
	<label for="congregacao">
		<g:message code="membro.congregacao.label" default="Congregacao" />

	</label>
	<g:select id="congregacao" name="congregacao.id" from="${com.congregacao.Congregacao.list()}" required="" 
			value="${membroInstance?.congregacao}" 
			optionKey="id"
	/>
</div>



<div class="fieldcontain ${hasErrors(bean: membroInstance, field: 'cargo', 'error')} required">
	<label for="cargo">
		<g:message code="membro.cargo.label" default="Cargo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cargo" name="cargo.id" from="${com.membro.Cargo.list()}" required="" 
			value="${membroInstance?.cargo}" 
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





