package com.membro

import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat;
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef

class MembroService {

	boolean transactional = true

	def jasperService

	def criaCartaoDeMembro(Membro membro, def request) {
		if(!membro){
			//throws new Exception("", "")
			println "não existe membro para gerar carterinha."
		} else{

			Carterinha carterinha = new Carterinha()
			carterinha.membro = membro
			carterinha.dataDeEmissao = new Date()
			carterinha.dataDeValidade = new Date() + 1095

//			Map params = new HashMap()
//			//def report = getFileParhReport(request)
//
//			params.put("CODIGO_ID", membro.id)
//			params.put("NOME", membro.nome)
//			params.put("NOME_PAI", membro.nomePai)
//			params.put("NOME_MAE", membro.nomeMae)
//			params.put("DATA_NASC", membro.dataDeNascimento)
//			params.put("NATURALIDADE", membro.naturalidade)
//			params.put("CARGO", membro.cargo)
//			params.put("ESTADO_CIVIL", membro.estadoCivil)
//			params.put("DATA_BATISMO", membro.dataDeBatismo)
//			params.put("DATA_EMISSAO", carterinha.dataDeEmissao)
//			params.put("DATA_VALIDADE", carterinha.dataDeValidade)
//
//			//def FOTO_MEMBRO = new ByteArrayInputStream()
//			params.put("FOTO_MEMBRO", membro.foto)
//
//			//dados do endereço
//			params.put("END_RUA", membro.endereco.rua)
//			params.put("END_CIDADE", membro.endereco.cidade)
//			params.put("END_ESTADO", membro.endereco.estado)
//			params.put("NOME", membro.nome)

//			println "params para report:"+params.CODIGO_ID

			def reportDef = new JasperReportDef(name:"report_carterinha.jrxml", fileFormat:JasperExportFormat.PDF_FORMAT, reportData: new ArrayList(), parameters: ["CODIGO_ID" : membro.id])
			def reportPdf = jasperService.generateReport(reportDef)
			def reportMySql = new ByteArrayInputStream(reportPdf.toByteArray())

			println "reportMySql: "+reportMySql

			carterinha.tipoConteudo = JasperExportFormat.PDF_FORMAT
			carterinha.tamanhoArquivo = reportPdf.size()

			//carterinha.dados = reportMySql
//			reportMySql.each {
//				carterinha.dados.add(it)
//			}
			
			println "reportPdf: "+reportPdf
			return reportMySql

		}
	}

	private def getFileParhReport(request) {
		def path = request.getSession().getServletContext().getRealPath("/")
		def appReportDir = new File(path+"reports")

		appReportDir.eachFileMatch(~/.*jrxml/){
			println it
			return it
		}
		println "appReportDir: "+appReportDir
	}
}
