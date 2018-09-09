package com.haylton.todolist.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.haylton.todolist.todolist.model.Lista;

public interface ListaRepository extends JpaRepository<Lista, Integer>{
	
	List<Lista> findByNomeIgnoreCase(String nome);
	
	@Query("select l from Lista l where l.deletado=false")
	List<Lista> buscaTodosNaoDeletados();
}
