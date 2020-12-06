package br.com.alular.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteCriaTabelas {
	
	public static void main(String[] args) {
		// Fábrica para criar o entity manager: o entityManager é um objeto complexo e não pode ser criado diretamente 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		// De fato cira o EM
		EntityManager em = emf.createEntityManager();
		
		emf.close();
	}
}
