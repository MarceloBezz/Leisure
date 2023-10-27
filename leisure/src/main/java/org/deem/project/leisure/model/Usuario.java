package org.deem.project.leisure.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	private long id;
}
