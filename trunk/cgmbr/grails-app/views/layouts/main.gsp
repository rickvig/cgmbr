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
	<script type="text/javascript" src="../js/jQuery/jquery.maskedinput.js"/></script>
	<r:require module="jquery-ui"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
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
	</style>
	
</head>
<body>
	<div id="grailsLogo" role="banner">
		<img src="${resource(dir: 'images', file: 'logo_batista.png')}" alt="Grails" />
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
	<script>
		$(function() {
			$( "#radio" ).buttonset();
		});
	</script>
		
	<div id="radio">
		<a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
		<g:link controller="membro" action="create">Cadastro de Membros</g:link>
		
		<!-- listagem dos controladores!!!!  
		<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
			<g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
		</g:each>
		-->
	</div>
	<br />
	<g:layoutBody />
	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">
		<g:message code="spinner.alt" default="Loading&hellip;" />
	</div>
	<g:javascript library="application" />
	<r:layoutResources />
</body>
</html>