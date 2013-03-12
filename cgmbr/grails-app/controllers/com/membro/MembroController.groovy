package com.membro

import org.springframework.dao.DataIntegrityViolationException

class MembroController {

	def scaffold = Membro

	def enderecoService
	def fotoService
	def membroService


	def listFilterBy() {

		params.max = Math.min(params.max ? params.int('max') : 10, 100)

		try {
			def membroList = membroService.membrosPorGrupoCargo(params.filterBy)
			[membroInstanceList: membroList, membroInstanceTotal: membroList.size(), filterBy: params.filterBy]
		} catch (Exception e) {
			redirect(action: "list", params: params)
		}

	}

	def save() {
		def membroInstance = new Membro(params)

		try {
			membroInstance.endereco = enderecoService.saveEndereco(params)
		} catch (Exception e) {
			flash.error = e
		}

		if (!membroInstance.save(flush: true)) {
			render(view: "create", model: [membroInstance: membroInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'membro.label', default: 'Membro'),
			membroInstance.id
		])
		redirect(action: "show", id: membroInstance.id)
	}

	def update() {
		def membroInstance = Membro.get(params.id)
		if (!membroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "list")
			return
		}

		membroInstance.endereco = enderecoService.saveEndereco(params)
		if (params.version) {
			def version = params.version.toLong()
			if (membroInstance.version > version) {
				membroInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'membro.label', default: 'Membro')]
						as Object[],
						"Another user has updated this Membro while you were editing")
				render(view: "edit", model: [membroInstance: membroInstance])
				return
			}
		}

		membroInstance.properties = params

		if (!membroInstance.save(flush: true)) {
			render(view: "edit", model: [membroInstance: membroInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'membro.label', default: 'Membro'),
			membroInstance.id
		])
		redirect(action: "show", id: membroInstance.id)
	}

	def getFoto = {
		def membroInstance = Membro.get(params.id)
		byte[] image = membroInstance.foto
		response.outputStream << image
	}
}
