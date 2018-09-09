package com.haylton.todolist.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


import lombok.Data;

@Data
@Entity 
public class Lista {
	
	@Id
	@SequenceGenerator(name="seq_lista", sequenceName="seq_lista", allocationSize =1)
	@GeneratedValue(generator = "seq_lista")
	private Integer id;
	private String nome;
	private boolean deletado;
	
}
