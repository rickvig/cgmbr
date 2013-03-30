package com.endereco

import grails.converters.JSON

class CidadeController {

	def scaffold = Cidade

	def getCidadePorEstado = {
		Long estadoIdLong = Long.parseLong(params.estadoId)
		Estado estado = Estado.get(estadoIdLong)
		List cidadesList = Cidade.findAllByEstado(estado)
		
		def renderList = ""
		cidadesList.each{
			renderList += "<option value=\"${it.id}\">${it.nome}</option>"
		}
		render renderList
	}
}
