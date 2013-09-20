package com.app

class ControlesController {

    //def scaffold = ControlesController
	
	def index = {
		
		List controlesIndisponiveis = ["auth", "controles", "congregacao", "cargo", "carterinha", "endereco", "membro", "jasper"] 
		
		def controles = grailsApplication.controllerClasses.sort { it.fullName }
		
		Map controlesMap = [:]
		controles.each{
			if(!controlesIndisponiveis.contains(it.logicalPropertyName)) 
			controlesMap.put(it.logicalPropertyName, it.name)
		}
		
		[controles:controlesMap]
	}
}
