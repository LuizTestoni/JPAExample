package br.com.alular.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TestaRelatorioMovimentacoes {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacaoes";
		
		TypedQuery<Conta> query = em.createQuery(jpql, Conta.class);
		List<Conta> listConta = query.getResultList();
		
		for (Conta conta : listConta) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agência: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Movimentações: " + conta.getMovimentacao());
			System.out.println("============");
		}
	}
}
