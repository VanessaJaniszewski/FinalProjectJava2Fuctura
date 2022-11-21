package br.com.gerenciadorBancario.dao;

import br.com.gerenciadorBancario.entities.Account;

public interface AccountDAO {
	
	public void transfer(Account minhaConta, Account contaTransferir, Double value);
	
	public Account findAccount(Integer numConta);
	
	public void deposit(Account contaDepositar, Double valorDepositar);
	
	public void withdraw(Account contaDepositar, Double valorSacado);
}
