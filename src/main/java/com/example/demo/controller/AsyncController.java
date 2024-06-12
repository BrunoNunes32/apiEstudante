package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.RelatorioService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/async")
@AllArgsConstructor
public class AsyncController {
	
	private RelatorioService relatorioService;
	
	@GetMapping
	public ResponseEntity<String> gerarRelatorio() throws InterruptedException{
		//chamar tarefa async
		relatorioService.gerrarRelatorio();
		return ResponseEntity.ok("Relatório inciado com sucesso!");
	}
}
