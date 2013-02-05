package com.congregacao

import com.endereco.Endereco;
import com.membro.Membro;

class Congregacao {

	static final SEDE = "Sede"	
	
	String nome
	Endereco endereco
	
	static hasMany = [membros: Membro]
	
	static constraints = {
		nome(blank:false, nullable:false)
		endereco(blank:false)
	}
	
	String toString() {
		return nome
	}
}
