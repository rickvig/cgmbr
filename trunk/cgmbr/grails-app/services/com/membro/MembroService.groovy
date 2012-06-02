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

			Carterinha carterinhaOld = Carterinha.findByMembro(membro)
			if(carterinhaOld){
				carterinhaOld.delete(flush: true)
			} 
		
			Carterinha carterinha = new Carterinha()
			carterinha.membro = membro
			carterinha.dataDeEmissao = new Date()

			if(membro.cargo.toString() != Cargo.MEMBRO){
				carterinha.dataDeValidade = new Date() + 365
			} else{
				carterinha.dataDeValidade = new Date() + 730
			}

			if(!carterinha.save(flush: true)){
				println "erros: "+carterinha.errors
				throw new Exception("", "Erro ao salver carterinha, "+carterinha.errors)
			}

			def reportDef
			if(membro.cargo.toString() == Cargo.MINISTRO){
				reportDef = new JasperReportDef(name:"report_carterinha_ministro_maior.jrxml", fileFormat:JasperExportFormat.PDF_FORMAT, reportData: new ArrayList(), parameters: ["CODIGO_ID" : membro.id])
			} else{
				reportDef = new JasperReportDef(name:"report_carterinha_membro_maior.jrxml", fileFormat:JasperExportFormat.PDF_FORMAT, reportData: new ArrayList(), parameters: ["CODIGO_ID" : membro.id])
			}
			def reportPdf = jasperService.generateReport(reportDef)
			def reportMySql = new ByteArrayInputStream(reportPdf.toByteArray())

			carterinha.tipoConteudo = JasperExportFormat.PDF_FORMAT
			carterinha.tamanhoArquivo = reportPdf.size()

			println "reportPdf OK: "
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
