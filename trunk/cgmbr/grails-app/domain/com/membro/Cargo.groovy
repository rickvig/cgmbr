package com.membro

class Cargo {
	
	public static final String MEMBRO = "Membro"
	public static final String MINISTRO = "Ministro"

	static hasMany = [membros: Membro]
	
	String nome
	String grupo
	
	static constraints = {
		nome(blank:false)
		grupo(blank:false, inList: [MEMBRO, MINISTRO])
	}
	
	String toString() {
		return nome
	}
}
