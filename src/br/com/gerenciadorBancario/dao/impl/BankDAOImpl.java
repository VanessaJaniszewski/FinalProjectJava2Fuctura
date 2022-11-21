package br.com.gerenciadorBancario.dao.impl;

import javax.persistence.EntityManager;

import br.com.gerenciadorBancario.dao.BankDAO;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.Bank;
import br.com.gerenciadorBancario.util.JpaUtil;

public class BankDAOImpl implements BankDAO {
	EntityManager em =JpaUtil.getEntityManager();
	@Override
	public void transfer(Account myAccount, Integer bankId, Double value) {
		if(myAccount.getBalance() >= value) {
			myAccount.setBalance(myAccount.getBalance()-value);
			try {
				em.getTransaction().begin();
				em.merge(myAccount);
				em.getTransaction().commit();
			}catch (Exception e) {
				System.err.println(e);
				em.getTransaction().rollback();
			}finally {
				em.close();
				JpaUtil.close();
			}
		}else {
			System.out.println("Not enought balance for requested transfer. Your current balance is of R$ "+myAccount.getBalance());
		}
	}

	@Override
	public Bank findBank(Integer bankID) {
			try {
				em.getTransaction().begin();
				return em.find(Bank.class, bankID);
			}catch (Exception e) {
				System.err.println(e);
				em.getTransaction().rollback();
				return null;
			}finally {
				em.close();
				JpaUtil.close();
			}
	}

}
