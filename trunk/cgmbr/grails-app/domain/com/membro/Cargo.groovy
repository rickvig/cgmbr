package com.membro

class Cargo {
	
	public static final String MEMBRO = "Membro"
	public static final String MINISTRO = "Ministro"

	static hasMany = [membros: Membro]
	
	String nome
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
