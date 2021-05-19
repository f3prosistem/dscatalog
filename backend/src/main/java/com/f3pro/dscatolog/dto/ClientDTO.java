package com.f3pro.dscatolog.dto;

import java.io.Serializable;
import java.time.Instant;

import com.f3pro.dscatolog.entities.Client;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
private Long id;
	private String name;
	private String cpf;
	private Double income;
	private  Instant bithDate;
	private Integer children;

	public ClientDTO() {}
	
	

	public ClientDTO(Long id, String name, String cpf, Double income, Instant bithDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.bithDate = bithDate;
		this.children = children;
	}
	

	public ClientDTO(Client entity) {
		
		this.id =  entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.bithDate = entity.getBithDate();
		this.children = entity.getChildren();
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBithDate() {
		return bithDate;
	}

	public void setBithDate(Instant bithDate) {
		this.bithDate = bithDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientDTO other = (ClientDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
