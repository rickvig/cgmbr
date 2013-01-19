package com.membro

import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat;
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef

class CarterinhaService {

   boolean transactional = true
   
   static final NOME_REPORT_MEMBRO = "report_carterinha_membro.jrxml"
   static final NOME_REPORT_MINISTRO = "report_carterinha_ministro.jrxml"

	def jasperService

	def criaCartaoDeMembro(Membro membro, def request) {
		if(!membro){
			println "| não existe membro para gerar carterinha."
			throw new Exception("Erro no fechamemto de Avaliações+.")
		} else{

			//TODO verificar a possibilidade de reabrir a msm carterinha
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
				println "| erros: "+carterinha.errors
				throw new Exception("Erro ao salver carterinha, "+carterinha.errors)
			}

			def reportDef
			if(membro.cargo.toString() == Cargo.MINISTRO){
				reportDef = new JasperReportDef(name:NOME_REPORT_MINISTRO, fileFormat:JasperExportFormat.PDF_FORMAT
												, reportData: new ArrayList(), parameters: ["CODIGO_ID" : membro.id])
			} else{
				reportDef = new JasperReportDef(name:NOME_REPORT_MEMBRO, fileFormat:JasperExportFormat.PDF_FORMAT
												, reportData: new ArrayList(), parameters: ["CODIGO_ID" : membro.id])
			}
			
			def reportMySql
			def reportPdf
			try {
				reportPdf = jasperService.generateReport(reportDef)
				reportMySql = new ByteArrayInputStream(reportPdf.toByteArray())
			} catch (Exception e) {
				println "| erros: "
				e.printStackTrace()
				throw new Exception(e)
			}
			
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
