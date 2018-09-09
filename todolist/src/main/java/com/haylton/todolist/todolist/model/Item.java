package com.haylton.todolist.todolist.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.Data;

@Data
@Entity
public class Item {
	
	@Id
	@SequenceGenerator(name="seq_item", sequenceName="seq_item")
	@GeneratedValue(generator="seq_item")
	private Integer id;
	
	private String titulo;
	
	private String descricao;
	 
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dataCriacao;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)   
	@JsonSerialize(using = LocalDateSerializer.class)  
	private LocalDate dataVencimento;
	
	private boolean completado;
	
	private boolean deletado;
	
	@JoinColumn
	@ManyToOne
	private Lista lista;

	public Item() {
		
	}

	public Item(Integer id, String titulo, String descricao, LocalDate dataCriacao, LocalDate dataVencimento,
			boolean completado, boolean deletado, Lista lista) {
		
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.completado = completado;
		this.deletado = deletado;
		this.lista = lista;
	}
	
	
	
	
	
}
