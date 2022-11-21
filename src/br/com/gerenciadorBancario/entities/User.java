package br.com.gerenciadorBancario.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "USER")
@DynamicUpdate
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
	@Column(name = "ID_USER", nullable = false)
	private Integer id;
	
	@Column(name = "NAME", nullable = false, length = 60)
	private String name;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "BIRTH", nullable = false)
	private Calendar birth;
	
	@Column(name = "CPF", nullable = false, length = 11, unique = true)
	private String cpf;
	
	@OneToMany
//	(targetEntity = Account.class, mappedBy = "ID_USER", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Account> userAccount;
	
	
	
	public User() {}



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



	public Calendar getBirth() {
		return birth;
	}



	public void setBirth(Calendar birth) {
		this.birth = birth;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public List<Account> getUserAccount() {
		return userAccount;
	}



	public void setUserAccount(List<Account> userAccount) {
		this.userAccount = userAccount;
	}



	@Override
	public int hashCode() {
		return Objects.hash(birth, cpf, id, name, userAccount);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(birth, other.birth) && Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(userAccount, other.userAccount);
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birth=" + birth + ", cpf=" + cpf + ", userAccount="
				+ userAccount + "]";
	}



	public User(String name, Calendar birth, String cpf, List<Account> userAccount) {
		super();
		this.name = name;
		this.birth = birth;
		this.cpf = cpf;
		this.userAccount = userAccount;
	}
	
	
}