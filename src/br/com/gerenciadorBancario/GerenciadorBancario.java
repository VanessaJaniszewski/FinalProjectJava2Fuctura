package br.com.gerenciadorBancario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.gerenciadorBancario.dao.impl.GenericDAOImpl;
import br.com.gerenciadorBancario.entities.Account;
import br.com.gerenciadorBancario.entities.Bank;
import br.com.gerenciadorBancario.entities.User;

public class GerenciadorBancario {


	public static void main(String[] args) {
	
		List<Account> userAccounts = new ArrayList<Account>();
		User u1 = new User();
		u1.setCpf("0123");
		u1.setName("Vanessa");
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(1988, 8, 29);
		u1.setBirth(calendar1);
		u1.setId(1);
		u1.setUserAccount(userAccounts);
		
		Bank b1 = new Bank();
		b1.setCnpj("5555");
		b1.setId(1);
		b1.setName("New Bank");
		List<Account> bankAccounts = new ArrayList<Account>();
		b1.setBankAccounts(bankAccounts);
		
		Account c1 = new Account();
		c1.setBalance(500.00);
		c1.setId_bank(b1);
		c1.setId_user(u1);
		c1.setAccountNumb(00001);
		c1.setId(1);
		c1.setPassword("thisisthepassword");
		c1.setId_bank(b1);
		c1.setId_user(u1);
	
		
		bankAccounts.add(c1);
		userAccounts.add(c1);
		
		GenericDAOImpl generics = new GenericDAOImpl();
		GenericDAOImpl generics2 = new GenericDAOImpl();
		GenericDAOImpl generics3 = new GenericDAOImpl();
//		generics.save(c1);
//		generics2.save(b1);
//		generics3.save(u1);
		
	}
}
