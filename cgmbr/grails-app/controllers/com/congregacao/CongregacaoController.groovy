package com.congregacao

class CongregacaoController {

    def scaffold = Congregacao
	
	def enderecoService
	
	def save() {
		def congrecacaoInstance = new Congregacao(params)

		try {
			congrecacaoInstance.endereco = enderecoService.saveEndereco(params)
		} catch (Exception e) {
			flash.error = e.printStackTrace()
			render(view: "edit", model: [congrecacaoInstance: congrecacaoInstance])
			return
		}

		if (!congrecacaoInstance.save(flush: true)) {
			render(view: "create", model: [congrecacaoInstance: congrecacaoInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'congregacao.label', default: 'Congregacao'),
			congrecacaoInstance.id
		])
		redirect(action: "show", id: congrecacaoInstance.id)
	}
	
	def update() {
		def congrecacaoInstance = Congregacao.get(params.id)
		if (!congrecacaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "list")
			return
		}
		try {
			congrecacaoInstance.endereco = enderecoService.saveEndereco(params)
		} catch (Exception e) {
			flash.error = e.printStackTrace()
			render(view: "edit", model: [congrecacaoInstance: congrecacaoInstance])
			return
		}
		if (params.version) {
			def version = params.version.toLong()
			if (congrecacaoInstance.version > version) {
				congrecacaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'membro.label', default: 'Membro')]
						as Object[],
						"Another user has updated this Membro while you were editing")
				render(view: "edit", model: [congrecacaoInstance: congrecacaoInstance])
				return
			}
		}
		congrecacaoInstance.properties = params
		if (!congrecacaoInstance.save(flush: true)) {
			render(view: "edit", model: [congrecacaoInstance: congrecacaoInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'congregacao.label', default: 'Congregacao'),
			congrecacaoInstance.id
		])
		redirect(action: "show", id: congrecacaoInstance.id)
	}
}
