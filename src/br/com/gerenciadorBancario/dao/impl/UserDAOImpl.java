package br.com.gerenciadorBancario.dao.impl;

import javax.persistence.EntityManager;

import br.com.gerenciadorBancario.dao.UserDAO;
import br.com.gerenciadorBancario.entities.User;
import br.com.gerenciadorBancario.util.JpaUtil;

public class UserDAOImpl implements UserDAO{
	EntityManager em =JpaUtil.getEntityManager();
	@Override
	public User findUser(Integer userID) {
			try {
				em.getTransaction().begin();
				return em.find(User.class, userID);
			}catch (Exception e) {
				System.err.println(e);
				em.getTransaction().rollback();
				return null;
			}finally {
				em.close();
				JpaUtil.close();
			}
	}
	

	@Override
	public void addAccount(Integer accountnumb, Double initialAmount) {
		// TODO Auto-generated method stub
		
	}

}
