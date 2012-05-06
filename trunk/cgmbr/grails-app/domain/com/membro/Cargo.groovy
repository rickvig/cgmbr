package com.membro

class Cargo {
	
	public static final String MEMBRO = "Membro"
	public static final String MINISTRO = "Ministro"

	static mapping = {
		//table 'Cargo'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}
	
	//static hasMany = [:]
	//or
	//static belongsTo = Cargo
	
	String nome
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
