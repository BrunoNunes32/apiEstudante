package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{

	@Query(value = "SELECT e.* FROM apiEstudante.estudante e " +
					"LEFT JOIN apiEstudante.avaliacao_curso ac ON ac.estudante_id = e.id " +
					"WHERE ac.estudante_id IS NULL", nativeQuery = true)
	List<Estudante> findByAvaliacaoCursosEstudanteIsNullNativeQuery();
	
	@Query(value = "SELECT e.* FROM estudante e " +
			"JOIN avaliacao_curso ac ON ac.estudante_id = e.id " +
			"WHERE ac.estudante_id IS NULL")
	List<Estudante> findByAvaliacaoCursosEstudanteIsNullJPQL();

	List<Estudante> findByAvaliacaoCursosEstudanteIsNull();
	
}
