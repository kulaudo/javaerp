package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import common.HibernateUtil;

public class BaseDAO<T> {

	/**
	 * 
	 * 
	 * @param object
	 */
	public void create(T object) {

		Session session =  HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();

			session.persist(object);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 
	 * 
	 * @param object
	 */
	public void update(T object) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();

			session.saveOrUpdate(session.merge(object));

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 
	 * 
	 * @param object
	 */
	public void delete(T object) {

		
		Session session =  HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.delete(session.merge(object));
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * @Entity Bean
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	// @SuppressWarnings("unchecked")
	public T find(Class<? extends T> clazz, Serializable id) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			return (T) session.get(clazz, id);

		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	/**
	 * @Entity Bean
	 * 
	 * @param hql
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> list(String hql) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			return session.createQuery(hql).list();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> advlist(Class<? extends T> clazz, List<Criterion> criteria2) {
		List<T> list;
		Session session =  HibernateUtil.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(clazz);
		for (Iterator<Criterion> i = criteria2.iterator(); i.hasNext();) {
			criteria.add(i.next());
		}

		try {
			session.beginTransaction();
			list = criteria.list();
		} finally {
			session.getTransaction().commit();
			session.close();
		}
		return list;
	}

}
