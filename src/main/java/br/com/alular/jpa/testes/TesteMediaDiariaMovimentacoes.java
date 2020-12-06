package br.com.alular.jpa.testes;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.MediaComData;
import dao.MovimentacaoDao;

public class TesteMediaDiariaMovimentacoes {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		
		List<MediaComData> listResult = new MovimentacaoDao(emf.createEntityManager()).getMediaDiariaDasMovimentcoes();
		
		for (MediaComData result : listResult) {
			System.out.println("A média das movimentações no dia " + result.getDia() + "/" + result.getMes() + " é: " + result.getValor());
		}
	}	

}
