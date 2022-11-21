package br.com.gerenciadorBancario.business;

import br.com.gerenciadorBancario.entities.Account;

public interface ContaBusiness {

	public void transfer(Account minhaConta, Double valor, Account contaTransferir);
}
