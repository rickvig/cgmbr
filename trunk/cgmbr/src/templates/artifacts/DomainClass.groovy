@artifact.package@class @artifact.name@ {

	static mapping = {
		//table '@artifact.name@'
		//coisas joinTable: 'NOME_TABELA_JOIN'
	}
	
	//static hasMany = [:]
	//or
	//static belongsTo = @artifact.name@
	
	String nome
	
	static constraints = {
		nome(blank:false)
	}
	
	String toString() {
		return nome
	}
}
