package com.endereco

class Estado {

	static mapping = { 
		sort sigla: "asc" // or "asc"
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
