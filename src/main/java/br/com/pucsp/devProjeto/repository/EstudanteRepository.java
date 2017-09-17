package br.com.pucsp.devProjeto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.pucsp.devProjeto.modelo.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Long>{
public List<Estudante> findByNome(String nome);
public List<Estudante> findByNomeIgnoreCaseContaining(String nome);
public List<Estudante> findByEmail(String email);
}
