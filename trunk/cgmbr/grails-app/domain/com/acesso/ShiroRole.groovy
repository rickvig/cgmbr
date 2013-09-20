package com.acesso

import com.congregacao.Congregacao;

class ShiroRole {
    String name

    static hasMany = [ users: ShiroUser, permissions: String, congregacoes: Congregacao ]
    static belongsTo = ShiroUser

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
	
	@Override
	public String toString() {
		name
	}
}
