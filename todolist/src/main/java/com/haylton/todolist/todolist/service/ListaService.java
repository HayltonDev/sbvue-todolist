package com.haylton.todolist.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haylton.todolist.todolist.model.Lista;
import com.haylton.todolist.todolist.repository.ListaRepository;

@Service //service apenas é um intermediador entre model e repository
public class ListaService {
	
	@Autowired
	private ListaRepository repository;
	
	
	public Lista salvar(Lista l) {
		return repository.save(l);
	}
	
	public List<Lista> buscaPorNome(String nome){ 
		return repository.findByNomeIgnoreCase(nome);
	}
	
	public Lista buscaPorId(Integer id) {
		return repository.findById(id).get();
	} 
	
	public List<Lista> buscarPorTodos(){
		return repository.findAll();
	}
	
	public void excluir(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Lista> buscarPorTodosNaoDeletados(){
		return repository.buscaTodosNaoDeletados();
	}
	
	
}
