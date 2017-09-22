package br.com.pucsp.devProjeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.pucsp.devProjeto.modelo.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, Long>{
public List<Estudante> findByNome(String nome);
public List<Estudante> findByNomeIgnoreCaseContaining(String nome);
public List<Estudante> findByEmail(String email);
@Query("select e from Estudante e where e.nome := nome")
public List<Estudante> buscarPorNome(@Param("nome")String nome);

}
