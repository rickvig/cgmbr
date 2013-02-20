package com.membro

import com.congregacao.Congregacao;
import com.endereco.Endereco;

class Membro {
	
	public static final String ATIVO = "Ativo"
	public static final String INATIVO = "Inativo"
	
	public static final String SOLTEIRO = "Solteiro(a)"
	public static final String CASADO = "Casado(a)"
	public static final String SEPARADO = "Separado(a)"
	public static final String DIVORCIADO = "Divorciado(a)"
	public static final String VIUVO  = "Viuvo(a)"
	public static final String OUTROS = "Outros"
	
	String nome
	String nomePai
	String nomeMae
	Date dataDeNascimento
	String naturalidade
	String estadoCivil
	Date dataDeBatismo
	String RG
	String CPF
	String telefoneResidencial
	String telefoneComercial
	String telefoneCelular
	String email
	String status = ATIVO
	Date dataDeInclusao = new Date()
	Endereco endereco
	Cargo cargo
	Congregacao congregacao
	byte[] foto
	
	static constraints = {
		status(blank:false, inList: [ATIVO, INATIVO])
		nome(blank:false)
		nomePai(blank:true)
		nomeMae(blank:true)
		dataDeNascimento(nullable:false)
		RG(blank:true, nullable:true)
		CPF(blank:true, nullable:true, unique:true, cpf:true)
		telefoneResidencial(blank:true)
		telefoneComercial(blank:true)
		telefoneCelular(blank:true)
		email(blank:true, email:true)
		endereco(nullable:true, blank:true)
		naturalidade(blank:true)
		estadoCivil(blank:false, inList: [SOLTEIRO, CASADO, SEPARADO, DIVORCIADO, VIUVO, OUTROS])
		dataDeBatismo(nullable:true)
		congregacao(blank:true)
		cargo(blank:false, nullable:false)
		dataDeInclusao(nullable:true)
		foto maxSize: 1024 * 1024 * 1
	}
	
	public String toString(){
		return "${nome} - ${cargo} - ${status}"
	}
	
}
