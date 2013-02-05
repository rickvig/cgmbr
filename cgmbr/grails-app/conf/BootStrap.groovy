import com.endereco.Endereco

import com.acesso.ShiroRole;
import com.acesso.ShiroUser;
import com.congregacao.Congregacao;
import com.endereco.Cidade;
import com.endereco.Endereco;
import com.endereco.Estado
import com.endereco.Pais;
import com.membro.Cargo;

import org.apache.shiro.crypto.hash.Sha256Hash

class BootStrap {

	def init = { servletContext ->

		/*Definição de usuário administrador*/
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
		
		/*Definição de Pais*/
		Pais bra = Pais.findByNome(Pais.BRA) ?: new Pais(nome: Pais.BRA).save()
		Pais ptg = Pais.findByNome(Pais.PTG) ?: new Pais(nome: Pais.PTG).save() 
		
		/*Definição de Estados para BRA*/
		Estado ro = Estado.findBySigla("RO") ?: new Estado(pais: bra, nome: "Rondônia", sigla: "RO").save()
		Estado ac = Estado.findBySigla("AC") ?: new Estado(pais: bra, nome: "Acre", sigla: "AC").save()
		Estado am = Estado.findBySigla("AM") ?: new Estado(pais: bra, nome: "Amazonas", sigla: "AM").save()
		Estado rr = Estado.findBySigla("RR") ?: new Estado(pais: bra, nome: "Roraima", sigla: "RR").save()
		Estado pa = Estado.findBySigla("PA") ?: new Estado(pais: bra, nome: "Pará", sigla: "PA").save()
		Estado ap = Estado.findBySigla("AP") ?: new Estado(pais: bra, nome: "Amapá", sigla: "AP").save()
		Estado to = Estado.findBySigla("TO") ?: new Estado(pais: bra, nome: "Tocantins", sigla: "TO").save()
		Estado ma = Estado.findBySigla("MA") ?: new Estado(pais: bra, nome: "Maranhão", sigla: "MA").save()
		Estado pi = Estado.findBySigla("PI") ?: new Estado(pais: bra, nome: "Piauí", sigla: "PI").save()
		Estado ce = Estado.findBySigla("CE") ?: new Estado(pais: bra, nome: "Ceará", sigla: "CE").save()
		Estado rn = Estado.findBySigla("RN") ?: new Estado(pais: bra, nome: "Rio Grande do Norte", sigla: "RN").save()
		Estado pb = Estado.findBySigla("PB") ?: new Estado(pais: bra, nome: "Paraíba", sigla: "PB").save()
		Estado pe = Estado.findBySigla("PE") ?: new Estado(pais: bra, nome: "Pernambuco", sigla: "PE").save()
		Estado al = Estado.findBySigla("AL") ?: new Estado(pais: bra, nome: "Alagoas", sigla: "AL").save()
		Estado se = Estado.findBySigla("SE") ?: new Estado(pais: bra, nome: "Sergipe", sigla: "SE").save()
		Estado ba = Estado.findBySigla("BA") ?: new Estado(pais: bra, nome: "Bahia", sigla: "BA").save()
		Estado mg = Estado.findBySigla("MG") ?: new Estado(pais: bra, nome: "Minas Gerais", sigla: "MG").save()
		Estado es = Estado.findBySigla("ES") ?: new Estado(pais: bra, nome: "Espírito Santo", sigla: "ES").save()
		Estado rj = Estado.findBySigla("RJ") ?: new Estado(pais: bra, nome: "Rio de Janeiro", sigla: "RJ").save()
		Estado sp = Estado.findBySigla("SP") ?: new Estado(pais: bra, nome: "São Paulo", sigla: "SP").save()
		Estado pr = Estado.findBySigla("PR") ?: new Estado(pais: bra, nome: "Paraná", sigla: "PR").save()
		Estado sc = Estado.findBySigla("SC") ?: new Estado(pais: bra, nome: "Santa Catarina", sigla: "SC").save()
		Estado rs = Estado.findBySigla("RS") ?: new Estado(pais: bra, nome: "Rio Grande do Sul", sigla: "RS").save()
		Estado ms = Estado.findBySigla("MS") ?: new Estado(pais: bra, nome: "Mato Grosso do Sul", sigla: "MS").save()
		Estado mt = Estado.findBySigla("MT") ?: new Estado(pais: bra, nome: "Mato Grosso", sigla: "MT").save()
		Estado go = Estado.findBySigla("GO") ?: new Estado(pais: bra, nome: "Goiás", sigla: "GO").save()
		Estado df = Estado.findBySigla("DF") ?: new Estado(pais: bra, nome: "Distrito Federal", sigla: "DF").save()
		
		/*Definição de Estados para BRA*/
		Cidade mga = Cidade.findByNome("Maringá") ?: new Cidade(estado: pr, nome: "Maringá").save()
		
		/*Definição de cargo padrão, Menbro e Ministro*/
		Cargo.findByNome(Cargo.MINISTRO) ?: new Cargo(nome:Cargo.MINISTRO).save()
		Cargo.findByNome(Cargo.MEMBRO) ?: new Cargo(nome:Cargo.MEMBRO).save()
		
		///Definição de da congregação Sede
		if(!Congregacao.findByNome(Congregacao.SEDE)){
			println "| criando SEDE..."
			Endereco enderecoSede = new Endereco(pais: bra, estado: pr, cidade: mga, bairro:"Operaria", rua: "Av. Mauá", numero: "1008").save()
			println "| endereçoe: "+enderecoSede
			new Congregacao(nome: Congregacao.SEDE, endereco: enderecoSede).save()
		}
		
	}
	def destroy = {
	}
}
