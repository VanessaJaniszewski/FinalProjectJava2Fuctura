package br.com.gerenciadorBancario.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.gerenciadorBancario.dao.AccountDAO;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.util.JpaUtil;

public class AccountDAOImpl implements AccountDAO {
	
	EntityManager ent = JpaUtil.getEntityManager();
	
	@Override
	public void transfer(Account myAccount, Account transferAccount, Double value) {
		if(myAccount.getBalance()>= value){
		transferAccount.setBalance(transferAccount.getBalance() + value);
		myAccount.setBalance(myAccount.getBalance() - value);
		try {
			ent.getTransaction().begin();
			ent.merge(myAccount);
			ent.merge(transferAccount);
			ent.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
			JpaUtil.close();
		}}else {
			System.out.println("Not enough balance for transfer. Your current balance is of R$ "+myAccount.getBalance());
		}
	}
	

	@Override
	public Account findAccount(Integer accountNumb) {
	try {
		ent.getTransaction().begin();
		Query query = ent.createQuery("SELECT c FROM Conta c WHERE c.numConta = :numConta")
				.setParameter("numConta", accountNumb).setMaxResults(1);
		ent.getTransaction().commit();
		return  (Account) query.getSingleResult();
	}catch (Exception e) {
		System.err.println(e);
		ent.getTransaction().rollback();
		return null;
	}
	finally {
		ent.clear();
		JpaUtil.close();
	}
	}

	@Override
	public void deposit(Account contaDepositar, Double valorDepositar) {
		contaDepositar.setBalance(contaDepositar.getBalance() + valorDepositar);
		try {
			ent.getTransaction().begin();
			ent.merge(contaDepositar);
			ent.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
			JpaUtil.close();
		}
	}

	@Override
	public void withdraw(Account myAccount, Double amount) {
		if(myAccount.getBalance()>= amount){
		myAccount.setBalance(myAccount.getBalance() - amount);
		try {
			ent.getTransaction().begin();
			ent.merge(myAccount);
			ent.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			ent.getTransaction().rollback();
		} finally {
			ent.close();
			JpaUtil.close();
		}}else {
			System.out.println("Not enough balance for the requested withdraw. Your current balance is of R$ "+myAccount.getBalance());
		}

	}
}
