package br.com.alular.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;
	
public class TestaSomaDasMovimentacoes {
	
	public static void main(String[] args) {
		// Pega o entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		// Cria a criteriaQuery
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
		
		// Pega a raiz da query (from)
		Root<Movimentacao> root = query.from(Movimentacao.class);
		
		// Cria uma expressão para ser executada na query (cria os campos do select)
		Expression<BigDecimal> sum = builder.sum(root.<BigDecimal>get("valor"));
		
		// Define os campos a serem executados (define os campos do selecte para a query)
		query.select(sum);
		
		
		TypedQuery<BigDecimal> typedQuery = em.createQuery(query);
		System.out.println("A soma das movimentações é: " + typedQuery.getSingleResult());
	}
}
