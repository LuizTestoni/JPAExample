package br.com.alular.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class AlterarSaldoContaLuiz {

	
	public static void main(String[] args) {
		// Fábrica para criar o entity manager: o entityManager é um objeto complexo e não pode ser criado diretamente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		// De fato cira o EM
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoLuiz = em.find(Conta.class, 1L);
		
		em.getTransaction().begin();
		
		contaDoLuiz.setSaldo(250.0);
		
		em.getTransaction().commit();
	}
}
