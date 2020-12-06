package br.com.alular.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Movimentacao;
import dao.MovimentacaoDao;

public class TestaMovimentacoesFiltradasPorDataCriteria {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(em);

		List<Movimentacao> listMovimentacao = movimentacaoDao.getMovimentacaoFiltradasPorData(null, null, null);	
		
		for (Movimentacao movimentacao : listMovimentacao) {
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Data: " + movimentacao.getData());
			System.out.println("=============================");
		}
	}

}
