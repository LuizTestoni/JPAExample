package br.com.alular.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {
	
	public static void main(String[] args) {
		// Estado: Transient
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(1201);
		conta.setNumero(148);
		conta.setSaldo(267.00); 
		
		// Fábrica para criar o entity manager: o entityManager é um objeto complexo e não pode ser criado diretamente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		// De fato cira o EM
		EntityManager em = emf.createEntityManager();		
		
		em.getTransaction().begin();
		
		// Transforma o estado de Transient para Managed
		em.persist(conta);
		// Transforma o estado Managed para Removed
		em.remove(conta);
		
		em.getTransaction().commit();
	}
}
