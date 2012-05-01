package com.membro

import com.mysql.jdbc.Blob;

class Carterinha {

	static mapping = {
		columns { dados type:'blob' }
	}

	//static hasMany = [:]
	//or
	//static belongsTo = Carterinha

	Date dataDeEmissao
	Date dataDeValidade
	String tipoConteudo
	Integer tamanhoArquivo
	Membro membro
	byte [] dados

	static constraints = {
		dataDeEmissao(nullable:true)
		dataDeValidade(nullable:true)
		tipoConteudo(nullable:true)
		tamanhoArquivo(nullable:true)
		dados maxSize: 1024 * 1024 * 1
		membro()
	}

}
