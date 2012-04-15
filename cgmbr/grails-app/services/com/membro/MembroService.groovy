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
			Map params = new HashMap()
			//def report = getFileParhReport(request)
			
			params.put("CODIGO_ID", membro.id)
			params.put("NOME", membro.nome)
			params.put("NOME_PAI", membro.nomePai)
			params.put("NOME_MAE", membro.nomeMae)
			params.put("DATA_NASC", membro.dataDeNascimento)
			params.put("NATURALIDADE", membro.naturalidade)
			params.put("CARGO", membro.cargo)
			params.put("ESTADO_CIVIL", membro.estadoCivil)
			params.put("DATA_BATISMO", membro.dataDeBatismo)
			params.put("DATA_EMISSAO", membro.dataDeEmissao)
			params.put("DATA_VALIDADE", membro.dataDeValidadeDoCartao)
			
			//def FOTO_MEMBRO = new ByteArrayInputStream()
			params.put("FOTO_MEMBRO", membro.foto)
			
			//dados do endereço
			params.put("END_RUA", membro.endereco.rua)
			params.put("END_CIDADE", membro.endereco.cidade)
			params.put("END_ESTADO", membro.endereco.estado)
			params.put("NOME", membro.nome)
			
			println "params para report:"+params
			
			def reportDef = new JasperReportDef(name:"report_carterinha", fileFormat:JasperExportFormat.PDF_FORMAT, reportData: new ArrayList(), parameters: params )
			def reportPdf = jasperService.generateReport(reportDef)
			//TODO criar opcao para fazer download da carterinha
			//TODO modelagem da carterinha: conteudo, nome e tamanho, e gerar renderização da msm
			//TODO salvar a carterinha aqui.
			//def report2Db = new ByteArrayInputStream(reportPdf.toByteArray())
			
			println "reportPdf: "+reportPdf
			
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
