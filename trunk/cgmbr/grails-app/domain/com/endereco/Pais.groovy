package com.endereco

class Pais {

	static final BRA = "Brasil"
	static final PTG = "Portugal"
	
	static mapping = {
		sort nome: "asc" // or "asc"
	}
	
	String nome
	
	static hasMany = [estados: Estado]
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
