package com.membro

class CarterinhaController {

    def scaffold = Carterinha
	
	def membroService
	
	def emiteCartao = {
		def membroInstance = Membro.get(params.id)
		
		def carterinhaDeMembro = membroService.criaCartaoDeMembro(membroInstance, request)
		
		response.outputStream << carterinhaDeMembro
		//render "<pre>${membroInstance}</pre>"
	}
}
