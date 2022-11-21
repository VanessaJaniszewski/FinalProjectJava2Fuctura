package br.com.gerenciadorBancario.business.impl;

import br.com.gerenciadorBancario.business.ContaBusiness;
import br.com.gerenciadorBancario.dao.AccountDAO;
import br.com.gerenciadorBancario.dao.impl.AccountDAOImpl;
import br.com.gerenciadorBancario.entities.Account;

public class ContaBusinessImpl implements ContaBusiness{
	
	AccountDAO accountDAO = new AccountDAOImpl();
	@Override
	public void transfer(Account myAccount, Double value, Account contaTransferir) {
		if (myAccount.getBalance() >= value) {
			accountDAO.transfer(myAccount, contaTransferir, value);
		} else {
			System.out.println("Not enough balance for the requested transfer. Your"
					+ "current balance is of R$ "+myAccount.getBalance());
		}
	}
}
