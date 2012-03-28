package com.endereco

class Cidade {

	static mapping = {
		//table 'Cidade'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}
	
	//static hasMany = [:]
	//or
	//static belongsTo = Estado
	
	Estado estado
	String nome
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
