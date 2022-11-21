package br.com.gerenciadorBancario.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.gerenciadorBancario.dao.GenericDAO;
import br.com.gerenciadorBancario.util.JpaUtil;

public class GenericDAOImpl implements GenericDAO{
	EntityManager ent = JpaUtil.getEntityManager();
	@SuppressWarnings("rawtypes")
	@Override
	public List listAll(Object object) {
		try {
		Query query = ent.createQuery("FROM " + object.getClass().getSimpleName());
		return query.getResultList();
		}catch(Exception e) {
			System.err.println(e);
			return null;
		}finally {
			ent.close();
			JpaUtil.close();
		}
	}

	@Override
	public Object searchById(Object object, Integer id) {
		try {
			return ent.find(object.getClass(), id);
		}catch (Exception e) {
			System.err.println(e);
			return null;
		}finally {
			ent.close();
			JpaUtil.close();
		}}
		
		
	@Override
	public void delete(Object object) {
		try {
		ent.getTransaction().begin();
		ent.remove(object);
		ent.getTransaction().commit();
		}catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		}finally{
		ent.close();
		JpaUtil.close();
	}}

	@Override
	public void save(Object object) {
		try {
		ent.getTransaction().begin();
		ent.persist(object);
		ent.getTransaction().commit();
		}catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		}finally {
			ent.close();
			JpaUtil.close();
		}
	}

	@Override
	public void update(Object object) {
		try {
		ent.getTransaction().begin();
		ent.merge(object);
		ent.getTransaction().commit();
		}catch(Exception e){
			System.err.println(e);
			ent.getTransaction().rollback();
		}finally {
		ent.close();
		JpaUtil.close();
	}}

	}
