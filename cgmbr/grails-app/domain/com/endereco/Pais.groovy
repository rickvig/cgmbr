package com.endereco

class Pais {

	static mapping = {
		//table 'Pais'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}
	
	static hasMany = [estados: Estado]
	//or
	//static belongsTo = Pais
	
	String nome
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
