package br.com.gerenciadorBancario.dao;

import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.Bank;

public interface BankDAO {
	
	public void transfer(Account myAccount, Integer bankId, Double value);
	
	public Bank findBank(Integer bankID);
	
}
