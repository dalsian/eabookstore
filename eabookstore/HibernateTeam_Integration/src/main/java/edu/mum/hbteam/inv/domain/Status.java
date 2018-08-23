package edu.mum.hbteam.inv.domain;

import java.io.Serializable;

public class Status implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
 	private Long id;
    String name;

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

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + "]";
	}
	
}
