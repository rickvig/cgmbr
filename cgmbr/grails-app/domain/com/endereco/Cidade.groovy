package com.endereco

class Cidade {

	static mapping = { 
		sort nome: "asc" // or "asc"
	}

	//static hasMany = [:]
	//or
	//static belongsTo = Estado

	Estado estado
	String nome

	static constraints = { nome(blank:false) }

	String toString() {
		return nome
	}
}
