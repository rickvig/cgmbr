package com.endereco


class Endereco {
	
	String cep
	String rua
	String bairro
	String numero
	String complemento
	Cidade cidade
	Estado estado
	Pais pais
	
	static constraints = {
		pais(blank:true, nullable:true)
		estado(blank:false)
		cidade(nullable:false)
		cep(blank:true, nullable:true, cep:true)
		rua(blank:false, nullable:true)
		bairro(blank:false)
		numero(blank:false)
		complemento(blank:true, nullable:true)
	}
	
	public String toString(){
		return "${cidade} - ${estado}"
	}
}
