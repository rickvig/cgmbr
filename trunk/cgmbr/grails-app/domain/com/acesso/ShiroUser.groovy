package com.acesso

import org.apache.shiro.crypto.hash.Sha256Hash

class ShiroUser {
	String username
	String passwordHash

	static hasMany = [ roles: ShiroRole, permissions: String ]

	static constraints = {
		username(nullable: false, blank: false)
	}

	def afterInsert() {
		println "| afterInsert: ${this.passwordHash}"
		passwordHash = new Sha256Hash(this.passwordHash).toHex()
	}
	
	@Override
	public String toString() {
		username
	}
}
