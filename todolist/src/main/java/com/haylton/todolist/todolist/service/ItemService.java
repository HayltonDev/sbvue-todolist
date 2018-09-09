package com.haylton.todolist.todolist.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haylton.todolist.todolist.model.Item;
import com.haylton.todolist.todolist.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	

	public Item salvar(Item item) {

		return itemRepository.save(item);
	}
	
	public Item buscarPorId(Integer id) {
		return itemRepository.findById(id).get();
	}
	
	public List<Item> buscarPorTodos(){
		return itemRepository.findAll();
	}
	
	public List<Item> buscarPorTodosNaoDeletados(){
		return itemRepository.findByDeletadoFalse();
	}
	
	public List<Item> buscarItensLista(Integer id){
		return itemRepository.buscarPorListaIdEDeletadoFalso(id);
	}
	
	public List<Item> buscarPorTitulo(String titulo){
		return itemRepository.findByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Item> buscarPorDescricao(String descricao){
		return itemRepository.findByDescricaoContainingIgnoreCase(descricao);
	}
	
	public List<Item> buscarPorDataVencimento(LocalDate dataVencimento){
		return itemRepository.findByDataVencimento(dataVencimento);
	}
	
	public List<Item> buscarPorRangeDeDatasVencimento(LocalDate dataInicio, LocalDate dataFim){
		return itemRepository.findByDataVencimentoBetween(dataInicio, dataFim);
	}
	
	public void excluir(Integer id) {
		itemRepository.deleteById(id);
	}
}
