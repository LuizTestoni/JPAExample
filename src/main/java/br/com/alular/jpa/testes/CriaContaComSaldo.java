package br.com.alular.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	
	public static void main(String[] args) {
		// F�brica para criar o entity manager: o entityManager � um objeto complexo e n�o pode ser criado diretamente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		// De fato cira o EM
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("M�rcia");
		conta.setNumero(12345);
		conta.setAgencia(51201);
		conta.setSaldo(100.99);
		
		em.getTransaction().begin();
		
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
		// Ap�s o close do entityManager a conta fica em estado DETACHED
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("Id da conta da M�rcia: " + conta.getId());
		conta.setSaldo(500.99);
		
		em2.getTransaction().begin();
		
		// Sincrona a conta e retorna o seu estado para MANAGED
		// A troca que estadado no JPA � quem dispara o comando para o banco
		em2.merge(conta);
		
		em2.getTransaction().commit();
	}

}
