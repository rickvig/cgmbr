package com.membro

class CarterinhaController {

	def scaffold = Carterinha

	def membroService

	def emiteCartao = {
		def membroInstance = Membro.get(params.id)
		def carterinhaDeMembro
		
		try {
			carterinhaDeMembro = membroService.criaCartaoDeMembro(membroInstance, request)
		} catch (Exception e) {
			flash.message = e.cause.message
		}
		response.outputStream << carterinhaDeMembro
	}
}
