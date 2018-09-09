package com.haylton.todolist.todolist.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haylton.todolist.todolist.model.Item;
import com.haylton.todolist.todolist.service.ItemService;

@RestController
@RequestMapping("/itens")
@CrossOrigin("http://127.0.0.1:8090")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/item/cadastrar")
	public Item cadastrar(@RequestBody Item item) {
		return itemService.salvar(item);
	}
	
	@PutMapping("item/editar")
	public Item editar(@RequestBody Item item) {
		return itemService.salvar(item);
	}
	
	@GetMapping("/item/{id}")
	public Item buscarPorId(Integer id) {
		return itemService.buscarPorId(id);
	}
	
	@GetMapping("/item/itempost")
	public Item buscarPorIdPost(@RequestBody Item item) {
		return itemService.buscarPorId(item.getId());
	}
	
	@GetMapping("/todos")
	public List<Item> buscarPorTodos(){
		return itemService.buscarPorTodos();
	}
	
	@GetMapping("/")
	public List<Item> buscarPorTodosNaoDeletados(){
		return itemService.buscarPorTodosNaoDeletados();
	}
	
	
	@PostMapping("/item/titulo")
	public List<Item> buscarPorTitulo(@RequestBody Item item){
		return itemService.buscarPorTitulo(item.getTitulo());
	}
	
	@PostMapping("/item/descricao")
	public List<Item> buscarPorDescricao(@RequestBody Item item){
		return itemService.buscarPorDescricao(item.getDescricao());
	}
	
	@PostMapping("/item/datavencimento")
	public List<Item> buscarPorDataVencimento(@RequestBody Item item){
		return itemService.buscarPorDataVencimento(item.getDataVencimento());
	}
	
	@GetMapping("/range/{dataInicio}/{dataFim}")
	List<Item> buscarPorRangeDeDatasVencimento(
			@PathVariable("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio, 
			@PathVariable("dataFim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim){
		return itemService.buscarPorRangeDeDatasVencimento(dataInicio,dataFim);
	}
	
//	@PostMapping("/ranges")
//	List<Item> buscarPorRangeDeDatasVencimentos(
//			 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestBody Item  dataInicio, 
//			 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestBody Item dataFim){
//		return itemService.buscarPorRangeDeDatasVencimento(dataInicio.getDataVencimento(),dataFim.getDataVencimento());
//	} 
	
	@DeleteMapping("/item/apagar/{id}")  
	public void apagar(@PathVariable("id")Integer id) {
		itemService.excluir(id);
	}
	
	
	
}
