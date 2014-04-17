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
		List membrosId = params.membrosId ?: []
		
		if (!membrosId.isEmpty()) {
			def ids = []
			membrosId.each { ids.add(Long.parseLong(it)) }
			try {
				def carterinhaDeMembro = carterinhaService.criaCartaoDeMembro(params.filterBy, ids, request)
				response.outputStream << carterinhaDeMembro
				
			} catch (Exception e) {
				flash.error = "Erro ao gerar carterinhas [${e}]"
				redirect(controller: 'membro', action: 'listFilterBy', params:[filterBy: params.filterBy])
			}
		} else {
			flash.error = message(code: "carterinha.noselectPrint.message", args: [params.filterBy])
			redirect(controller: 'membro', action: 'listFilterBy', params:[filterBy: params.filterBy])
		}
		
	}
}
