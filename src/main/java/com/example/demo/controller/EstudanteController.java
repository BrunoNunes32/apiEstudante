package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Estudante;
import com.example.demo.service.EstudanteService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("estudantes")
@AllArgsConstructor
public class EstudanteController {
	
	private EstudanteService estudanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudante> buscarEstudantePorId(@PathVariable Long id){
		return estudanteService.buscarEstudantePorId(id);
	}
	
	@GetMapping()
	public Page<Estudante> buscarTodosEstudante(
			@RequestParam(defaultValue = "0") Integer pagina, 
			@RequestParam(defaultValue = "5") Integer itensPorPagina){
		return estudanteService.buscarTodosEstudante(PageRequest.of(pagina,itensPorPagina));
	}
	
	@PostMapping()
	public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody Estudante estudante) {
		return estudanteService.cadastrarEstudante(estudante);
	}
	
	@PutMapping()
	public ResponseEntity<Estudante> atualizarEstudante(@PathVariable Long id, @RequestParam Estudante estudante) {
		return estudanteService.atualizarEstudante(id, estudante);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> excluirEstudante(@PathVariable Long id) {
		return estudanteService.excluirEstudante(id);
	}
	
	@GetMapping("/naoAvaliaram")
	public List<Estudante> buscarEstudantesQueNaoAvaliaram(){
		return estudanteService.buscarEstudantesQueNaoAvaliaram();
	}
	

}
