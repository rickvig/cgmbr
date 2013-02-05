package com.endereco

class Pais {

	static final BRA = "Brasil"
	static final PTG = "Portugal"
	
	String nome
	
	static hasMany = [estados: Estado]
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
