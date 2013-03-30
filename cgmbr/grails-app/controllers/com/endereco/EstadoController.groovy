package com.endereco

class EstadoController {

    def scaffold = Estado
	
	def getEstadoPorPais = {
		Long paisIdLong = Long.parseLong(params.paisId)
		Pais pais = Pais.get(paisIdLong)
		List estadosList = Estado.findAllByPais(pais)
		
		def renderList = ""
		estadosList.each{
			renderList += "<option value=\"${it.id}\">${it}</option>"
		}
		render renderList
	}
}
