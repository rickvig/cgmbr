package com.endereco

class Estado {

	static mapping = {
		//table 'Estado'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}
	
	static hasMany = [cidades: Cidade]
	//or
	//static belongsTo = Pais
	
	Pais pais
	String nome
	String sigla
	
	static constraints = {
		nome(blank:false)
		sigla(nullable:false)
	}
	
	String toString() {
		return "${sigla} - ${nome}"
	}
}
