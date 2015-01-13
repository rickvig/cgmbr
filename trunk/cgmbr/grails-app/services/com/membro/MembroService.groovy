package com.membro

import groovy.sql.Sql



class MembroService {
	
	def dataSource
	
	def membrosPorGrupoCargo(filterBy){
		def membros = []
		def membrosPorCargo = []
		def cargos = Cargo.findAllByGrupo(filterBy)

		try {
			cargos.each { membrosPorCargo.add(Membro.findAllByCargo(it)) }
			membrosPorCargo.each { membrosCargos ->
				membrosCargos.each{ membros.add(it) }
			}
		} catch (Exception e) {
			throw e
		}
		membros
	}

	def membrosPorGrupoCargoPaginate(grupo, max, offset){
		List membros = []
		def sql = new Sql(dataSource)
		def query = """
					select m.id as ID from membro as m, cargo as c 
					where m.cargo_id = c.id 
						and c.grupo = :grupo 
					order by m.id limit :max offset :offset;
					"""
		
		try {
			def resultQuery = sql.rows(query, [grupo: grupo, max: max, offset: offset])
			def ids = []
			resultQuery.each{ ids.add(it.ID) }
			
			membros = Membro.findAll("from Membro where id in (:ids)", [ids: ids])
		} catch (Exception e) {
			e.printStackTrace()
			throw e
		}
		membros
	}
	
	def membrosPorGrupoCargoTotal(grupo) {
		def sql = new Sql(dataSource)
		def query = "SELECT count(m.id) as TOTAL FROM membro as m, cargo as c where m.cargo_id = c.id and c.grupo = :grupo;"
		def resultQuery = sql.rows(query, [grupo: grupo])
		resultQuery.first().TOTAL
	}
}
