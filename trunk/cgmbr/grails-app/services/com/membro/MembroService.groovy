package com.membro



class MembroService {

	def membrosPorGrupoCargo(filterBy){
		def membros = []
		def membrosPorCargo = []
		def cargos = Cargo.findAllByGrupo(filterBy)

		try {
			cargos.each { membrosPorCargo.add(Membro.findAllByCargo(it)) }
			println "| LOG listFilterBy membrosPorCargo: ${membrosPorCargo}"
			membrosPorCargo.each { membrosCargos ->
				membrosCargos.each{ membros.add(it) }
			}
		} catch (Exception e) {
			println "| ERROS: ${e}"
			throw e
		}
		membros
	}
}
