package com.membro

import java.awt.Menu;

import org.springframework.dao.DataIntegrityViolationException

import com.endereco.Endereco;

class MembroController {

	def enderecoService
	def fotoService

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}

	def list() {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[membroInstanceList: Membro.list(params), membroInstanceTotal: Membro.count()]
	}

	def create() {
		[membroInstance: new Membro(params)]
	}

	def save() {

		params.each{ println "- params: "+it }

		def membroInstance = new Membro(params)
		//def fotoInstance = new Foto(params)
//
//		def uploadedFile = request.getFile('foto')
//		if(!uploadedFile.empty){
//			println "Class: ${uploadedFile.class}"
//			println "Name: ${uploadedFile.name}"
//			println "OriginalFileName: ${uploadedFile.originalFilename}"
//			println "Size: ${uploadedFile.size}"
//			println "ContentType: ${uploadedFile.contentType}"
//			println "Bytes: ${uploadedFile.bytes}"
//			println "Bytes Class: ${uploadedFile.bytes.class}"
//			
//		}
//		membroInstance.foto = uploadedFile.getBytes()
//		
//		println "membroInstance.foto: "+membroInstance.foto


		membroInstance.status = Membro.ATIVO
		membroInstance.dataDeEmissao = new Date()

		membroInstance.endereco = enderecoService.saveEndereco(params, membroInstance)

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

	def show() {
		def membroInstance = Membro.get(params.id)
		if (!membroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "list")
			return
		}

		[membroInstance: membroInstance]
	}

	def edit() {
		def membroInstance = Membro.get(params.id)
		if (!membroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "list")
			return
		}

		[membroInstance: membroInstance]
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

		membroInstance.endereco = enderecoService.saveEndereco(params, membroInstance)
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

	def delete() {
		def membroInstance = Membro.get(params.id)
		if (!membroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "list")
			return
		}

		try {
			membroInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'membro.label', default: 'Membro'),
				params.id
			])
			redirect(action: "show", id: params.id)
		}
	}
	
	def getFoto = {
		def membroInstance = Membro.get(params.id)
		byte[] image = membroInstance.foto
		response.outputStream << image
	}
	
}
