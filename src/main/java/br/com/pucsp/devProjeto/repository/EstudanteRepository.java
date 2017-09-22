package br.com.pucsp.devProjeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.pucsp.devProjeto.modelo.Estudante;

//PagingAndSortingRepository   CrudRepository  JpaRepository
public interface EstudanteRepository extends JpaRepository<Estudante, Long>{
public List<Estudante> findByNome(String nome);
public List<Estudante> findByNomeIgnoreCaseContaining(String nome);
public List<Estudante> findByEmail(String email);
//@Query("select e from Estudante e where e.nome := nome")
//public List<Estudante> buscarPorNome(@Param("nome")String nome);

}
