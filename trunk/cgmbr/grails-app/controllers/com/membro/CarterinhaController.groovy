package com.membro

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
}
