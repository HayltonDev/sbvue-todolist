package com.haylton.todolist.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haylton.todolist.todolist.model.Item;
import com.haylton.todolist.todolist.model.Lista;
import com.haylton.todolist.todolist.service.ItemService;
import com.haylton.todolist.todolist.service.ListaService;

@RestController
@RequestMapping("/listas")
//@CrossOrigin("http://127.0.0.1:8090")
@CrossOrigin("*")
public class ListaController {
	
	@Autowired
	private ListaService listaService;
	
	@Autowired
	private ItemService itemService;
	
	
	@GetMapping("/") //apenas listas não deletas
	public List<Lista> buscaPorTodosNaoDeletados(){
		return listaService.buscarPorTodosNaoDeletados();
	}
	
	
	@PostMapping("/salvar")
	public Lista salvar(@RequestBody Lista lista) {
		return listaService.salvar(lista);
	}
	
	@PutMapping("/editar")
	public Lista editar(@RequestBody Lista lista) {
		return listaService.salvar(lista);
	}
	
	@DeleteMapping("/deletar/{id}") //como tá vindo da url a requisição, então é pathVariable
	public void excluir(@PathVariable("id") Integer id) {
		listaService.excluir(id);
	}
	
	
	@GetMapping("/lista/{id}")
	public Lista buscaPorId(@PathVariable("id") Integer id){
		return listaService.buscaPorId(id);
	}
	
	@GetMapping("/todaslistas") //esse aqui traz as listas deletas e não deletadas
	public List<Lista> buscaPorTodos(){
		return listaService.buscarPorTodos();
	}
	
	@GetMapping("/lista/itens/{id}")
	public List<Item> buscaPorItensLista(@PathVariable("id") Integer id){
		
		return itemService.buscarItensLista(id);
	}

	
	
}
