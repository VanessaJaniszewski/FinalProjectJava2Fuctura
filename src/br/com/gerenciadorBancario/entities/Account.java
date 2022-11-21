package br.com.gerenciadorBancario.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "ACCOUNT")
@DynamicUpdate
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
	@Column(name = "ACCOUNT_IS", nullable = false)
	private Integer id;
	
	@Column(name = "ACCOUNT_NUMB", nullable = false, unique = true)
	private Integer accountNumb;
	
	@Column(name = "BALANCE", nullable = false)
	private Double balance;
	
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= CascadeType.ALL, targetEntity = User.class)
	@JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
	private User id_user;
	
	@ManyToOne (fetch=FetchType.LAZY, cascade= CascadeType.ALL, targetEntity = Bank.class)
	@JoinColumn(name = "ID_BANK", referencedColumnName ="ID_BANK")
	private Bank id_bank;
	
	public Account() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountNumb() {
		return accountNumb;
	}

	public void setAccountNumb(Integer accountNumb) {
		this.accountNumb = accountNumb;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public Bank getId_bank() {
		return id_bank;
	}

	public void setId_bank(Bank id_bank) {
		this.id_bank = id_bank;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumb=" + accountNumb + ", balance=" + balance + ", password=" + password
				+ ", id_user=" + id_user + ", id_bank=" + id_bank + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumb, balance, id, id_bank, id_user, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountNumb, other.accountNumb) && Objects.equals(balance, other.balance)
				&& Objects.equals(id, other.id) && Objects.equals(id_bank, other.id_bank)
				&& Objects.equals(id_user, other.id_user) && Objects.equals(password, other.password);
	}

	public Account(Integer accountNumb, Double balance, String password, User id_user, Bank id_bank) {
		super();
		this.accountNumb = accountNumb;
		this.balance = balance;
		this.password = password;
		this.id_user = id_user;
		this.id_bank = id_bank;
	}
	
	


	
	

}