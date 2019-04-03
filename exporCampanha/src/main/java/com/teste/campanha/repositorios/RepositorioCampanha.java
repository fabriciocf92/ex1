package com.teste.campanha.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.teste.campanha.modelos.Campanha;

@Repository
public interface RepositorioCampanha extends JpaRepository<Campanha, Long>{

	@Query(value =
			"SELECT * " +
			"FROM campanha " +
			"WHERE fim_vigencia > Now()"
		, nativeQuery = true)
	public List<Campanha> campanhas();
	
	@Query(value =
			"SELECT * " +
			"FROM campanha " +
			"WHERE fim_vigencia = ?1"
		, nativeQuery = true)
	public List<Campanha> campanhasPorFimVigencia(String fimVigencia);
	
	@Query(value =
			"SELECT * " +
			"FROM campanha " +
			"WHERE inicio_vigencia = ?1 AND " +
			"fim_vigencia = ?2"
		, nativeQuery = true)
	public List<Campanha> campanhasPorVigencia(String inicioVigencia, String fimVigencia);
	
	@Query(value =
			"SELECT * " +
			"FROM campanha " +
			"WHERE time_id = ?1"
		, nativeQuery = true)
	public List<Campanha> campanhasPorTime(String timeId);
}
