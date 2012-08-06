<ol>
	<g:if test="${congregacaoInstance?.endereco?.pais}">
		<li class="fieldcontain">
			<span id="pais-label" class="property-label">
				<g:message code="endereco.pais.label" default="Pais:" />
			</span>
			<span class="property-value" aria-labelledby="pais-label">
					${congregacaoInstance?.endereco?.pais?.encodeAsHTML()}
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.estado}">
		<li class="fieldcontain">
			<span id="estado-label" class="property-label">
				<g:message code="endereco.estado.label" default="Estado:" />
			</span>
			<span class="property-value" aria-labelledby="estado-label">
					${congregacaoInstance?.endereco?.estado?.encodeAsHTML()}
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.cidade}">
		<li class="fieldcontain">
			<span id="cidade-label" class="property-label">
				<g:message code="endereco.cidade.label" default="Cidade:" />
			</span>
			<span class="property-value" aria-labelledby="cidade-label">
					${congregacaoInstance?.endereco?.cidade?.encodeAsHTML()}
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.cep}">
		<li class="fieldcontain">
			<span id="cep-label" class="property-label">
				<g:message code="endereco.cep.label" default="Cep:" />
			</span>
			<span class="property-value" aria-labelledby="cep-label">
				<g:fieldValue bean="${congregacaoInstance?.endereco}" field="cep" />
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.rua}">
		<li class="fieldcontain">
			<span id="rua-label" class="property-label">
				<g:message code="endereco.rua.label" default="Rua:" />
			</span>
			<span class="property-value" aria-labelledby="rua-label">
				<g:fieldValue bean="${congregacaoInstance?.endereco}" field="rua" />
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.bairro}">
		<li class="fieldcontain">
			<span id="bairro-label" class="property-label">
				<g:message code="endereco.bairro.label" default="Bairro:" />
			</span>
			<span class="property-value" aria-labelledby="bairro-label">
				<g:fieldValue bean="${congregacaoInstance?.endereco}" field="bairro" />
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.numero}">
		<li class="fieldcontain">
			<span id="numero-label" class="property-label">
				<g:message code="endereco.numero.label" default="Numero:" />
			</span>
			<span class="property-value" aria-labelledby="numero-label">
				<g:fieldValue bean="${congregacaoInstance?.endereco}" field="numero" />
			</span>
		</li>
	</g:if>

	<g:if test="${congregacaoInstance?.endereco?.complemento}">
		<li class="fieldcontain">
			<span id="complemento-label" class="property-label">
				<g:message code="endereco.complemento.label" default="Complemento:" />
			</span>
			<span class="property-value" aria-labelledby="complemento-label">
				<g:fieldValue bean="${congregacaoInstance?.endereco}"
					field="complemento" />
			</span>
		</li>
	</g:if>

</ol>