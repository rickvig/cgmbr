package com.endereco

class CidadeController {

	def scaffold = CidadeController


	def getCidadePorEstado = {
		println params.estadoId.class
		Long estadoIdLomg = Long.parseLong(params.estadoId)
		Estado estado = Estado.get(estadoIdLomg)
		List<Cidade> cidadesList = Cidade.findAllByEstado(estado)
		
		println "cidadesList: "+cidadesList
		
		cidadesList.each{
			render "<options>${it}</options>"
		}
		
//		render(tamplate:"formEnderecoMenbro", model:[cidadesList: cidadesList])
	}
}
