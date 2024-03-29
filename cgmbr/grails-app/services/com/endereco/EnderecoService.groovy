package com.endereco

import com.membro.Membro;

class EnderecoService {

	def saveEndereco(Map parametros) {

		def endereco

		if(!parametros.membroEndereco || parametros.membroEndereco == ""){
			endereco = new Endereco()
		} else{
			Long idEndereco = Long.parseLong(parametros.membroEndereco)
			endereco = Endereco.get(idEndereco)
		}
		
		endereco.pais = Pais.get(parametros.pais.id)
		endereco.estado = Estado.get(parametros.estado.id)
		endereco.cidade = Cidade.get(parametros.cidade.id)
		endereco.cep = parametros.cep
		endereco.rua = parametros.rua
		endereco.bairro = parametros.bairro
		endereco.numero = parametros.numero
		endereco.complemento = parametros.complemento
		
		if(!endereco.save()){
			throw new Exception("Erro ao salver endereço. $e")
			return
		}

		endereco
	}
}
