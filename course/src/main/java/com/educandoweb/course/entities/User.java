package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // JPA = classifico para o JPA que a classe user é uma entidade relacional
@Table(name = "tb_user") // renomeio o nome da tabela 
//serializable para o objeto trafegar na rede/ transformar em arquivo
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id // indico quem é o id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id auto-incremento 
	private long id;
	private String name;
	private String emial;
	private String phone;
	private String password;
	
	public User() {
	}

	public User(long id, String name, String emial,
			String phone, String password) {
		this.id = id;
		this.name = name;
		this.emial = emial;
		this.phone = phone;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmial() {
		return emial;
	}

	public void setEmial(String emial) {
		this.emial = emial;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}
	
	
	
	
	
	
	
	
}
