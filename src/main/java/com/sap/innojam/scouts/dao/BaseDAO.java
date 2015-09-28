package com.sap.innojam.scouts.dao;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

abstract public class BaseDAO<TYPE, KEY> {

	@Inject
	protected EntityManager em;
	protected final Class<TYPE> type;

	private static final int BATCH_SIZE = 500;

	public BaseDAO(Class<TYPE> clz) {
		this.type = clz;
	}

	@SuppressWarnings("unchecked")
	public List<TYPE> findAll() {
		return em.createQuery("SELECT x FROM " + this.type.getSimpleName() + " x").getResultList();
	}

	public TYPE find(KEY key) {
		return em.find(type, key);
	}

	public TYPE findOrCreate(TYPE entity, KEY key) {
		TYPE foundEntitiy = find(key);
		if (foundEntitiy == null) {
			insert(entity);
			return entity;
		} else
			return foundEntitiy;
	}

	public TYPE upsert(TYPE entity) {
		em.getTransaction().begin();
		try {
			TYPE e = em.merge(entity);
			em.getTransaction().commit();
			return e;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public TYPE insert(TYPE entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public Collection<TYPE> insertBatch(Collection<TYPE> entities) {
		try {
			em.getTransaction().begin();
			int i = 0;
			for (TYPE entity : entities) {
				em.persist(entity);
				if (i % BATCH_SIZE == 0) {
					em.flush();
					em.clear();
				}
			}
			em.getTransaction().commit();
			return entities;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public TYPE delete(TYPE entity) {
		em.getTransaction().begin();
		try {
			entity = em.merge(entity);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public int deleteAll() {
		em.getTransaction().begin();
		try {
			int cntDeleted = em.createQuery("DELETE FROM " + this.type.getSimpleName()).executeUpdate();
			em.getTransaction().commit();
			return cntDeleted;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public boolean exists(KEY key) {
		return find(key) != null;
	}

	public Long count() {
		return (Long) em.createQuery("SELECT COUNT(x) FROM " + this.type.getSimpleName() + " x").getSingleResult();
	}
}