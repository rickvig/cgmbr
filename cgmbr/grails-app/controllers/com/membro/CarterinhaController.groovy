package com.membro

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

class CarterinhaController {

	def scaffold = Carterinha

	def membroService
	def carterinhaService

	def emiteCartao = {
		def membroInstance = Membro.get(params.id)
		
		try {
			def carterinhaDeMembro = carterinhaService.criaCartaoDeMembro(membroInstance, request)
			response.outputStream << carterinhaDeMembro
		} catch (Exception e) {
			flash.message = e
			redirect(controller: 'membro', action: 'show', params:[id: membroInstance.id])
		}
	}
	
	def emiteCartoes = {
		
		def parser = "imprime-"
		def membrosIds = []
		def membroList = []
		try {
			membroList = membroService.membrosPorGrupoCargo(params.filterBy)
		} catch (Exception e) {
			flash.error = "Erro ao consultar ${params.filterBy} [${e}]"
		} 
		
		membroList.each{
			def key = parser+""+it.id
			if((params.containsKey(key)) && (params.get(key) == "on")) {
				membrosIds.add(it.id) 
			}
		}
		if(!membrosIds.isEmpty()){
			try {
				def carterinhaDeMembro = carterinhaService.criaCartaoDeMembro(params.filterBy, membrosIds, request)
				response.outputStream << carterinhaDeMembro
			} catch (Exception e) {
				//println "Erro: ${e}"
				flash.error = "Erro ao gerar carterinhas [${e}]"
				redirect(controller: 'membro', action: 'listFilterBy', params:[filterBy: params.filterBy])
			}
		} else {
			//println "membrosIds: ${membrosIds}"
			flash.error = message(code: "carterinha.noselectPrint.message", args: [params.filterBy])
			redirect(controller: 'membro', action: 'listFilterBy', params:[filterBy: params.filterBy])
		}
		
	}
}
