package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Movimentacao> getMovimentacaoFiltradasPorData(Integer dia, Integer mes, Integer ano) {
		CriteriaBuilder builder = this.em.getCriteriaBuilder();

		CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
		Root<Movimentacao> root = query.from(Movimentacao.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (Objects.nonNull(dia)) {
			Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
			predicates.add(predicate);
		}

		if (Objects.nonNull(mes)) {
			Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
			predicates.add(predicate);
		}

		if (Objects.nonNull(ano)) {
			Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
			predicates.add(predicate);
		}
		

		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

		return typedQuery.getResultList();
	}

	public List<MediaComData> getMediaDiariaDasMovimentcoes() {
		TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaMovimentos", MediaComData.class);

		return query.getResultList();
	}

	public BigDecimal getSomaDasMovimentacoes() {
		String jpql = "select sum(m.valor) from Movimentacao m";

		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);

		return query.getSingleResult();
	}
}
