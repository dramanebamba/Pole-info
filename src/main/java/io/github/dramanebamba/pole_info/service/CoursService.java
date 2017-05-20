package io.github.dramanebamba.pole_info.service;


import java.util.List;
import java.util.Vector;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import io.github.dramanebamba.pole_info.model.Cours;
import io.github.dramanebamba.pole_info.model.Item;
import io.github.dramanebamba.pole_info.utils.QueryHelper;

@RequestScoped
public class CoursService {
	@PersistenceContext
	private EntityManager em;

	@Inject
	private QueryHelper helper;

	@Transactional
	public List<Cours> getAll() {
		return em.createQuery(helper.selectAll(em.getCriteriaBuilder(), Cours.class)).getResultList();
	}

	@Transactional
	public void persist(Cours cours) {
		em.persist(cours);
	}
}
