package com.haylton.todolist.todolist.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.haylton.todolist.todolist.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	List<Item>findByTituloContainingIgnoreCase(String titulo);
	
	List<Item>findByDescricaoContainingIgnoreCase(String descricao);
	
	List<Item>findByDataVencimento(LocalDate dataVencimento);
	
	//passo a dataInicio pela interface e fim, para mostrar itens que vencen dentro desse range
	List<Item> findByDataVencimentoBetween(LocalDate dataInicio, LocalDate dataFim);
	
	List<Item> findByDeletadoFalse();
	
	@Query("select i from Item i where i.lista.id= :id and deletado=false")
	List<Item> buscarPorListaIdEDeletadoFalso(@Param("id")Integer id);
}
