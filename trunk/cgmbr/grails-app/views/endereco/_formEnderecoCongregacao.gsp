<%@ page import="com.endereco.Endereco"%>

<script>

	function getCidadadePorEstado(){
		var estadoId = jQuery('#estado').val()

		if(estadoId){
			$.ajax({
				url: '${createLink([controller: 'cidade', action: 'getCidadePorEstado'])}'
				,type: 'POST'
				,data: { 'estadoId':estadoId }
				,success : function(data){
					//$('body').html(data);
					//location.reload(true);
				}
				,error : function(data){
	
				}	 
			});
		} else{
			alert("Selecione um estado.")
		}
		
	}

</script>


<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'pais', 'error')} required">
	<label for="pais">
		<g:message code="endereco.pais.label" default="Pais" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pais" name="pais.id" from="${com.endereco.Pais.list()}" optionKey="id" required="" value="${congregacaoInstance?.endereco?.pais?.id}"
		class="many-to-one" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'estado', 'error')} required">
	<label for="estado">
		<g:message code="endereco.estado.label" default="Estado" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="estado" 
			name="estado.id" 
			from="${com.endereco.Estado.list()}" 
			optionKey="id" 
			required=""
			value="${congregacaoInstance?.endereco?.estado?.id}" 
			onchange="getCidadadePorEstado();"
			class="many-to-one" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'cidade', 'error')} required">
	<label for="cidade">
		<g:message code="endereco.cidade.label" default="Cidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="cidade" 
			name="cidade.id" 
			from="${com.endereco.Cidade.list()}" 
			optionKey="id" 
			required=""
			value="${congregacaoInstance?.endereco?.cidade?.id}" 
			class="many-to-one" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'cep', 'error')} ">
	<label for="cep">
		<g:message code="endereco.cep.label" default="Cep" />

	</label>
	<g:textField name="cep" value="${congregacaoInstance?.endereco?.cep}" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'rua', 'error')} required">
	<label for="rua">
		<g:message code="endereco.rua.label" default="Rua" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rua" required="" value="${congregacaoInstance?.endereco?.rua}" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'bairro', 'error')} required">
	<label for="bairro">
		<g:message code="endereco.bairro.label" default="Bairro" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bairro" required="" value="${congregacaoInstance?.endereco?.bairro}" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'numero', 'error')} required">
	<label for="numero">
		<g:message code="endereco.numero.label" default="Numero" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="numero" required="" value="${congregacaoInstance?.endereco?.numero}" />
</div>

<div class="fieldcontain ${hasErrors(bean: congregacaoInstance?.endereco, field: 'complemento', 'error')} ">
	<label for="complemento">
		<g:message code="endereco.complemento.label" default="Complemento" />

	</label>
	<g:textField name="complemento" value="${congregacaoInstance?.endereco?.complemento}" />
</div>

