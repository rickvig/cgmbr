import com.acesso.ShiroRole;
import com.acesso.ShiroUser;
import com.membro.Cargo;

import org.apache.shiro.crypto.hash.Sha256Hash

class BootStrap {

	def init = { servletContext ->

		def adminRole = ShiroRole.findByName("Administrador")

		if(!adminRole){
			adminRole = new ShiroRole(name: 'Administrador')
			adminRole.addToPermissions("*:*")
			adminRole.save()
		}

		def admin = ShiroUser.findByUsername('admin')

		if(!admin){
			admin = new ShiroUser(username: 'admin', passwordHash: new Sha256Hash('admin').toHex())
			admin.save()
			adminRole.addToUsers(admin)
			adminRole.save()
		}

		def cargo1 = Cargo.findByNome(Cargo.MINISTRO)
		if(!cargo1){
			Cargo cargoMinistro = new Cargo(nome:Cargo.MINISTRO).save()
		}
		def cargo2 = Cargo.findByNome(Cargo.MEMBRO)
		if(!cargo2){
			Cargo cargoMembro = new Cargo(nome:Cargo.MEMBRO).save()
		}

		//		def user = new ShiroUser(username: "user123", passwordHash: new Sha256Hash("password").toHex())
		//		user.addToPermissions("*:*")
		//		user.save()
	}
	def destroy = {
	}
}
