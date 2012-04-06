package com.membro

import org.springframework.dao.DataIntegrityViolationException

class FotoController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[fotoInstanceList: Foto.list(params), fotoInstanceTotal: Foto.count()]
	}

	def create() {
		[fotoInstance: new Foto(params)]
	}

	def save() {
		def fotoInstance = new Foto(params)
		if (!fotoInstance.save(flush: true)) {
			render(view: "create", model: [fotoInstance: fotoInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'foto.label', default: 'Foto'),
			fotoInstance.id
		])
		redirect(action: "show", id: fotoInstance.id)
	}

	def show() {
		def fotoInstance = Foto.get(params.id)
		if (!fotoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'foto.label', default: 'Foto'),
				params.id
			])
			redirect(action: "list")
			return
		}
		[fotoInstance: fotoInstance]
	}

	def edit() {
		def fotoInstance = Foto.get(params.id)
		if (!fotoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'foto.label', default: 'Foto'),
				params.id
			])
			redirect(action: "list")
			return
		}

		[fotoInstance: fotoInstance]
	}

	def update() {
		def fotoInstance = Foto.get(params.id)
		if (!fotoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'foto.label', default: 'Foto'),
				params.id
			])
			redirect(action: "list")
			return
		}

		if (params.version) {
			def version = params.version.toLong()
			if (fotoInstance.version > version) {
				fotoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'foto.label', default: 'Foto')]
						as Object[],
						"Another user has updated this Foto while you were editing")
				render(view: "edit", model: [fotoInstance: fotoInstance])
				return
			}
		}

		fotoInstance.properties = params

		if (!fotoInstance.save(flush: true)) {
			render(view: "edit", model: [fotoInstance: fotoInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'foto.label', default: 'Foto'),
			fotoInstance.id
		])
		redirect(action: "show", id: fotoInstance.id)
	}

	def delete() {
		def fotoInstance = Foto.get(params.id)
		if (!fotoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'foto.label', default: 'Foto'),
				params.id
			])
			redirect(action: "list")
			return
		}

		try {
			fotoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'foto.label', default: 'Foto'),
				params.id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'foto.label', default: 'Foto'),
				params.id
			])
			redirect(action: "show", id: params.id)
		}
	}

	def image= {
		def fotoInstance = Foto.get(params.id)
		byte[] image = fotoInstance.myFile
		response.outputStream << image
	}
}
