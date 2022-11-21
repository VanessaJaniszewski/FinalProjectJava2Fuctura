package br.com.gerenciadorBancario.dao;

import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.User;

public interface UserDAO {
	
	public User findUser(Integer userID);
	
	public void addAccount(Integer accountnumb, Double initialAmount);

}
