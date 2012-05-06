package com.congregacao

import com.endereco.Endereco;
import com.membro.Membro;

class Congregacao {

	static mapping = {
		//table 'Congregacao'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}
	
	static hasMany = [membros: Membro]
	
	String nome
	Endereco endereco
	
	static constraints = {
		nome(blank:false, nullable:false)
		endereco(blank:false)
	}
	
	String toString() {
		return nome
	}
}
