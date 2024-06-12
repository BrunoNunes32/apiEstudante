package com.example.demo.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AvaliacaoCurso;
import com.example.demo.entity.Curso;
import com.example.demo.entity.Estudante;
import com.example.demo.repository.AvaliacaoCursoRepository;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudanteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoCursoService {

	private final AvaliacaoCursoRepository avaliacaoCursoRepository;
	private final EstudanteRepository estudanteRepository;
	private final CursoRepository cursoRepository;
	
	public ResponseEntity<String> avaliar(Long idEstudante, String nomeCurso, Integer notaAvaliacao){
		Optional<Estudante> estudanteOptional = estudanteRepository.findById(idEstudante);
		
		if (!estudanteOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado!");
		}
		
		Optional<Curso> cursoOptional = cursoRepository.findByName(nomeCurso);
		
		if (!cursoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado!");
		}
		
		AvaliacaoCurso avaliacaoCurso = new AvaliacaoCurso();
		avaliacaoCurso.setEstudante(estudanteOptional.get());
		avaliacaoCurso.setCurso(cursoOptional.get());
		avaliacaoCurso.setNotaAvaliacao(notaAvaliacao);
		
		avaliacaoCursoRepository.save(avaliacaoCurso);
		return ResponseEntity.ok("Avaliação salva com sucesso!");
	}
	
	
}
