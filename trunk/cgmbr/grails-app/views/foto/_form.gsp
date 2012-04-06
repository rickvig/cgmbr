<%@ page import="com.membro.Foto" %>



<div class="fieldcontain ${hasErrors(bean: fotoInstance, field: 'myFile', 'error')} required">
	<label for="myFile">
		<g:message code="foto.myFile.label" default="My File" />
		<span class="required-indicator">*</span>
	</label>
	<input type="file" id="myFile" name="myFile" />
</div>

