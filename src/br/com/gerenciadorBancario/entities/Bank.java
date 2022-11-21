package br.com.gerenciadorBancario.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "BANK")
@DynamicUpdate
public class Bank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bank_sequence")
	@Column(name = "ID_BANK", nullable = false)
	private Integer id;
	
	@Column(name = "BANK_NAME", nullable = false, length = 30)
	private String name;
	
	@Column(name = "CNPJ", nullable = false, length = 14)
	private String cnpj;
	
	@OneToMany
//	(targetEntity = Account.class, mappedBy = "ID_BANK", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Account> bankAccounts;
	
	
	public Bank() {
	}
	
	


	public Bank(String name, String cnpj, List<Account> bankAccounts) {
		super();
		this.name = name;
		this.cnpj = cnpj;
		this.bankAccounts = bankAccounts;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public List<Account> getBankAccounts() {
		return bankAccounts;
	}


	public void setBankAccounts(List<Account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}


	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", cnpj=" + cnpj + ", bankAccounts=" + bankAccounts + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(bankAccounts, cnpj, id, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(bankAccounts, other.bankAccounts) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
}
