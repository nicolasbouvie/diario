package br.com.niggas.diario.dao;

import static org.hibernate.criterion.Projections.rowCount;
import static org.hibernate.criterion.Restrictions.eq;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import net.jodah.typetools.TypeResolver;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

public abstract class AbstractDao<T> {

	@Inject
	private Session session;

	public Session getSession() {
		return session;
	}

	public Query createQuery(String queryString) {
		return session.createQuery(queryString);
	}

	protected Class<?> getPersistentClass() {
		return TypeResolver.resolveRawArguments(AbstractDao.class, getClass())[0];
	}

	protected Criteria createCriteria(Class<?> baseClass) {
		Criteria criteria = getSession().createCriteria(baseClass);
		return criteria;
	}

	protected Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = createCriteria(getPersistentClass());
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return criteria;
	}

	@SuppressWarnings("unchecked")
	public T getByCriteria(Criteria criteria) {
		criteria.setMaxResults(1);
		List<T> list = criteria.list();
		return (!list.isEmpty()) ? list.iterator().next() : null;
	}

	public Long countByCriteria(Criteria criteria) {
		criteria.setProjection(rowCount());
		return (Long) criteria.list().get(0);
	}

	public T getByCriteria(Criterion... criterions) {
		return getByCriteria(createCriteria(criterions));
	}

	public Long countByCriteria(Criterion... criterions) {
		return countByCriteria(createCriteria(criterions));
	}

	public Boolean existsByCriteria(Criterion... criterions) {
		return countByCriteria(criterions) > 0;
	}

	public T findById(Serializable id) {
		return getByCriteria(eq("id", id));
	}

	public Object save(Object instance) {
		session.saveOrUpdate(instance);
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return createQuery("FROM " + getPersistentClass().getSimpleName()).list();
	}

	public void remove(T object) {
		session.delete(object);
	}

	@SuppressWarnings("unchecked")
	public void removeById(Serializable id) {
		remove((T) createCriteria(eq("id", id)).uniqueResult());
	}
}
