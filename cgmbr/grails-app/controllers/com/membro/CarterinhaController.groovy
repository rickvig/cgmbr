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
	
	def emiteCartoes = {
		
		def parser = "imprime-"
		def membrosIds = []
		def membroList = params.filterBy ? Membro.findAllByCargo(Cargo.findByNome(params.filterBy), params) : Membro.list(params) 
		
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
				println "Erro: ${e}"
				flash.message = e
				redirect(controller: 'membro', action: 'listPrint', params:[filterBy: params.filterBy])
			}
		} else {
			println "membrosIds: ${membrosIds}"
			flash.error = message(code: "carterinha.noselectPrint.message", args: [params.filterBy])
			redirect(controller: 'membro', action: 'listPrint', params:[filterBy: params.filterBy])
		}
		
	}
}
