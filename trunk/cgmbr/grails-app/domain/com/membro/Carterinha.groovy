package com.membro

import com.mysql.jdbc.Blob;

class Carterinha {

	static mapping = {
	}

	static belongsTo = [membro: Membro]

	Date dataDeEmissao
	Date dataDeValidade
	String tipoConteudo
	Integer tamanhoArquivo

	static constraints = {
		dataDeEmissao(nullable:true)
		dataDeValidade(nullable:true)
		tipoConteudo(nullable:true)
		tamanhoArquivo(nullable:true)
	}

}
