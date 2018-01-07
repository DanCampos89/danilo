package com.br.project1.util;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GenericDAO<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4701413177706368630L;
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("project1");
	private EntityManager em = null;
	private EntityTransaction transaction = null;

	public void beginTransaction() {

		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();

	}

	public void commit() {

		transaction.commit();

	}

	public void rollback() {

		transaction.rollback();

	}

	public void closeConnection() {

		em.close();

	}

	public void insert(T obj) {
		try {

			this.beginTransaction();
			em.persist(obj);

			this.commit();
		} catch (Exception e) {
			this.rollback();
			System.out.println("Erro inserir: " + e);
		} finally {
			this.closeConnection();
		}
	}

	public void update(T obj) {

		try {
			this.beginTransaction();

			em.merge(obj);

			this.commit();

		} catch (Exception e) {
			this.rollback();
		} finally {
			this.closeConnection();
		}
	}

	public void delete(Integer cod) {
		try {

			this.beginTransaction();
			em.remove(cod);

			this.commit();
		} catch (Exception e) {
			this.rollback();
			System.out.println("Erro inserir: " + e);
		} finally {
			this.closeConnection();
		}
	}

	public List<T> selectAll(String clazz, String where, String[] valores, String orderBy) {

		List<T> lt = new ArrayList<T>();

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			lt = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro selectAll: " + e);
		}

		this.closeConnection();

		return lt;
	}
	
	public List<T> selectAll(String clazz, String orderBy) {

		List<T> lt = new ArrayList<T>();

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl order by cl." + orderBy;

			Query q = em.createQuery(consulta);
			
			lt = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro selectAll: " + e);
		}

		this.closeConnection();

		return lt;
	}

	public List<T> selectAllI(String clazz, String where, Integer[] valores, String orderBy) {

		List<T> lt = new ArrayList<T>();

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			lt = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro selectAll: " + e);
		}

		this.closeConnection();

		return lt;
	}

	public List<T> selectAlld(String clazz, String where, Timestamp[] valores, String orderBy) {

		List<T> lt = new ArrayList<T>();

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;
			System.out.println("consulta: " + consulta);
			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			lt = q.getResultList();
			System.out.println("Lista: " + lt.size());
		} catch (Exception e) {
			System.out.println("Erro selectAll: " + e);
		}

		this.closeConnection();

		return lt;
	}

	public BigInteger countByCodigo(String clazz, String where, String[] valores, String orderBy) {

		BigInteger b = BigInteger.ZERO;

		try {

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			T result = (T) q.getSingleResult();

			b = (BigInteger) result;

		} catch (Exception e) {
			this.closeConnection();
			b = BigInteger.ZERO;
		}

		this.closeConnection();

		return b;
	}

	public T selectByString(String clazz, String where, String[] valores, String orderBy) {

		T obj = null;

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}
			System.out.println("quantidade: " + q.getResultList().size());
			obj = (T) q.getResultList().get(0);

		} catch (Exception e) {
			obj = null;
			System.out.println("Erro em selectByParam: " + e);
		}

		this.closeConnection();

		return obj;
	}

	public Object selectByObject(String clazz, String where, String[] valores, String orderBy) {

		Object obj = null;

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}
			System.out.println("Acesso selectByObject: " + consulta + valores[0]);

			obj = (T) q.getResultList().get(0);

		} catch (Exception e) {
			obj = null;
			System.out.println("Erro em selectByParam: " + e);
		}

		this.closeConnection();

		return obj;
	}

	public Object selectByObject(String clazz, String where, Integer[] valores, String orderBy) {

		Object obj = null;

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}
			System.out.println("Acesso selectByObject: " + q.getResultList().size());
			obj = (T) q.getResultList().get(0);

		} catch (Exception e) {
			obj = null;
			System.out.println("Erro em selectByParam: " + e);
		}

		this.closeConnection();

		return obj;
	}

	public T selectByInteger(String clazz, String where, Integer[] valores, String orderBy) {

		T obj = null;

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;
			System.out.println("consulta: " + consulta);
			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			obj = (T) q.getSingleResult();

		} catch (Exception e) {
			obj = null;
			System.out.println("Erro em selectByInteger: " + e);
		}

		this.closeConnection();

		return obj;
	}

	public List<String> selectByDesc(String clazz, String coluna, String where, String[] valores, String orderBy) {

		List<String> ltr = null;

		try {
			this.beginTransaction();

			String consulta = "Select " + coluna + " from " + clazz + " cl " + where + " " + orderBy;
			System.out.println("consulta: " + consulta);
			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			ltr = q.getResultList();

		} catch (Exception e) {
			System.out.println("Erro em selectByDesc: " + e);
		}
		this.closeConnection();
		return ltr;
	}

	public List<String> selectByDescConc(String clazz, String where, String[] valores, String orderBy) {
		List<T> lt = new ArrayList<T>();
		List<String> ltr = null;

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}

			lt = q.getResultList();

			for (T t : lt) {
				ltr.add(t.toString());
			}

		} catch (Exception e) {
			System.out.println("Erro em selectByDesc: " + e);
		}
		this.closeConnection();
		return ltr;
	}

	public Integer selectByStringCont(String clazz, String where, String[] valores, String orderBy) {

		Integer cont = 0;

		try {
			this.beginTransaction();

			String consulta = "Select cl from " + clazz + " cl " + where + " " + orderBy;

			Query q = em.createQuery(consulta);

			if (valores != null) {
				int tam = valores.length;

				for (int i = 0; i < tam; i++) {
					q.setParameter(i + 1, valores[i]);
				}
			}
			System.out.println("quantidade: " + q.getResultList().size());
			cont = q.getResultList().size();

		} catch (Exception e) {

			System.out.println("Erro em selectByParam: " + e);
		}

		this.closeConnection();

		return cont;
	}
}
