package com.membro

class Foto {

	static mapping = {
		//table 'Foto'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}

	byte[] myFile

	static constraints = {
		// Limit upload file size to 2MB 
		myFile maxSize: 1024 * 1024 * 2
	}


	String toString() {
		return myFile
	}
}
