package br.com.alular.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacaoContao {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 5L);
		Conta conta = movimentacao.getConta();
		Integer qtdMovimentacao = conta.getMovimentacao().size();
		
		System.out.println("Quantidade de movimentações: " + qtdMovimentacao);
		System.out.println("Titular da Conta: " + conta.getTitular());
	}
}
