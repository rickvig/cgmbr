package com.membro

import com.endereco.Endereco;

class Membro {
	
	public static final String ATIVO = "Ativo"
	public static final String INATIVO = "Inativo"
	
	public static final String SOLTEIRO = "Solteiro(a)"
	public static final String CASADO = "Casado"
	public static final String SEPARADO = "Separado"
	public static final String DIVORCIADO = "Divorciado"
	public static final String VIUVO  = "Viuvo"
	public static final String OUTROS = "Outros"
	
	String nome
	String nomePai
	String nomeMae
	String cargo
	Date dataDeNascimento
	String naturalidade
	String estadoCivil
	Date dataDeBatismo
	Date dataDeEmissao
	Date dataDeValidadeDoCartao
	String RG
	String CPF
	String telefoneResidencial
	String telefoneComercial
	String telefoneCelular
	String email
	String status
	String congregacao
	
	Endereco endereco
	
	byte[] foto
	
	static constraints = {
		status(blank:false, inList: [ATIVO, INATIVO])
		nome(blank:false)
		nomePai(blank:true)
		nomeMae(blank:true)
		dataDeNascimento(nullable:false)
		RG(blank:false)
		CPF(blank:false, unique:true, cpf:true)
		telefoneResidencial(blank:true)
		telefoneComercial(blank:true)
		telefoneCelular(blank:true)
		email(email:true)
		endereco(nullable:true, blank:true)
		naturalidade(blank:true)
		estadoCivil(blank:false, inList: [SOLTEIRO, CASADO, SEPARADO, DIVORCIADO, VIUVO, OUTROS])
		dataDeBatismo(nullable:true)
		congregacao(blank:true)
		cargo(blank:false)
		foto maxSize: 1024 * 1024 * 1
	}
	
	public String toString(){
		return "${nome} - ${cargo} - ${status}"
	}
	
}
