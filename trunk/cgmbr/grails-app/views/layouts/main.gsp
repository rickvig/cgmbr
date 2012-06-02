<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="en" class="no-js">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>
	<g:layoutTitle default="Grails" />
</title>
<g:javascript library="jquery" />


<r:require module="jquery-ui" />

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon_batista.png')}" type="image/x-icon">
<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">

<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'jquery-ui-1.8.18.custom.css')}" type="text/css">
<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">

<g:layoutHead />
<r:layoutResources />

<style type="text/css">
.textLogo {
	left: 9.7em;
	position: relative;
	top: -6.7em;
}

.textLogo h1 {
	color: white;
	font-size: 2em;
	font-weight: bold;
	margin: 0.8em 0.6em 0.3em;
}

marca-agua {
	background-color: red
}
</style>

</head>
<body>
	<shiro:isLoggedIn>
		<div class="userInfo">
			<p>
				Usu&aacute;rio: <strong><shiro:principal /><strong>
			</p>
			<div class="loginBtn">
				<g:link controller="auth" action="signOut">Sair</g:link>
			</div>
		</div>
	</shiro:isLoggedIn>
	
	<div id="grailsLogo" role="banner">
		<img src="${resource(dir: 'images', file: 'logo_batista.png')}" alt="Grails" />
<%--		<div class="marca-agua">--%>
<%--			<img src="${resource(dir: 'images', file: 'logo_batista.png')}" alt="Grails" />--%>
<%--		</div>--%>
		<div class="textLogo">
			<h1>SCGM - Sistema de Cadastro Geral de Membros</h1>
		</div>
		<div class="sysDate">
			Data:
			<g:formatDate format="${message(code: '${date.format.precision.day}', default: 'dd/MM/yyyy')}" date="${new Date()}" />
			- Vers&atilde;o:
			<g:meta name="app.version" />
		</div>
	</div>


	<shiro:isLoggedIn>
		<script>
			$(function() {
				$("#radio").buttonset();
			});
		</script>

		<div id="radio">
			<a class="home" href="${createLink(uri: '/')}">
				<g:message code="default.home.label" />
			</a>
			<g:link controller="membro" action="create">Cadastrar Membro</g:link>
			<g:link controller="membro" action="list">Listagem de Membros</g:link>
			<g:link controller="cargo" action="list">Cargos</g:link>
			<g:link controller="congregacao" action="list">Congrega&ccedil;&otilde;es</g:link>
		</div>
		<br />
		<g:layoutBody />
		<div class="footer" role="contentinfo">
			<a href="http://www.din.uem.br/~ra55761/"><pre>Desenvolvido Por Henrique Vignando [BSA]</pre></a>
		</div>
		<div id="spinner" class="spinner" style="display: none;">
			<g:message code="spinner.alt" default="Loading&hellip;" />
		</div>
		<g:javascript library="application" />
		<r:layoutResources />
	</shiro:isLoggedIn>

	<shiro:isNotLoggedIn>
		<div style="text-align: center; margin: 0pt auto; padding-top: 40px; padding-left: 200px">
			<script type="text/javascript">
				$(document).ready(function() {
					$('#username').focus();
				})
			</script>
			<g:form action="signIn" controller="auth" class="login shadow">
				<input type="hidden" name="targetUri" value="${targetUri}" />
				<p>
					<label class="tag required">Usu&aacute;rio:</label>
					<input type="text" name="username" id="username" value="${username}" />
				</p>
				<p>
					<label class="tag required">Senha:</label>
					<input type="password" name="password" value="" />
				</p>
				<p class="panelButton">
					<input type="submit" value="Entrar" />
				</p>
				<!-- 
				<p>
					<g:link controller="solicitacaoAcesso" action="create">
						Novo usu&acute;rio: Solicite seu acesso aqui</g:link>
				</p>
				 -->

				<g:if test="${flash.message}">
					<div class="errors">
						${flash.message}
					</div>
				</g:if>
			</g:form>
		</div>
	</shiro:isNotLoggedIn>

</body>
</html>