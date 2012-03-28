package com.endereco

class EnderecoService {

    def saveEndereco(Map parametros) {
		
		Endereco endereco = new Endereco()
		
		endereco.pais = Pais.get(parametros.pais.id)
		endereco.estado = Estado.get(parametros.estado.id)
		endereco.cidade = Cidade.get(parametros.cidade.id)
		endereco.cep = parametros.cep
		endereco.rua = parametros.rua
		endereco.bairro = parametros.bairro
		endereco.numero = parametros.numero
		endereco.complemento = parametros.complemento
		
		if(!endereco.save()){
			println "saveEndereco - erro"
			return
		}
		
		return endereco
    }
}
