package br.com.alular.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionameto {
	
	public static void main(String[] args) {
		
		Conta contaDaMichele = new Conta();
		contaDaMichele.setAgencia(123);
		contaDaMichele.setNumero(456);
		contaDaMichele.setSaldo(50000.0);
		contaDaMichele.setTitular("Michele Bolsonaro");
		
		Movimentacao deposito = new Movimentacao();
		deposito.setData(LocalDateTime.now());
		deposito.setDescricao("Pagamento de ~empréstimo~ ;)");
		deposito.setValor(new BigDecimal(89000.0));
		deposito.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		deposito.setConta(contaDaMichele);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(contaDaMichele);
		em.persist(deposito);
		
		em.getTransaction().commit();
		em.close();
	}
}
