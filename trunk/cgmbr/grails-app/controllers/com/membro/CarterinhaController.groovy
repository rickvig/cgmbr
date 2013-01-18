package com.membro

class CarterinhaController {

	def scaffold = Carterinha

	def membroService

	def emiteCartao = {
		def membroInstance = Membro.get(params.id)
		def carterinhaDeMembro
		
		println "CarterinhaController - emiteCartao : EMITINDO CARTERINHA..."
		
		try {
			carterinhaDeMembro = membroService.criaCartaoDeMembro(membroInstance, request)
		} catch (Exception e) {
			flash.message = e
		}
		response.outputStream << carterinhaDeMembro
	}
}
