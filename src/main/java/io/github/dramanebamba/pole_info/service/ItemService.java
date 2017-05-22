package main.java.io.github.dramanebamba.pole_info.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import main.java.io.github.dramanebamba.pole_info.model.Item;
import main.java.io.github.dramanebamba.pole_info.utils.QueryHelper;

@RequestScoped
public class ItemService {
	@PersistenceContext
	private EntityManager em;

	@Inject
	private QueryHelper helper;

	@Transactional
	public List<Item> getAll() {
		return em.createQuery(helper.selectAll(em.getCriteriaBuilder(), Item.class)).getResultList();
	}

	@Transactional
	public void persist(Item item) {
		em.persist(item);
	}
}