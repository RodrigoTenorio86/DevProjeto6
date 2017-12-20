package br.com.pucsp;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import br.com.pucsp.devProjeto.modelo.Estudante;
import br.com.pucsp.devProjeto.repository.EstudanteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EstudanteRepositoryTest {
	@Autowired
	private EstudanteRepository estudanteRepository;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	private Estudante estudante;
	@Before
	public void setup() {
		this.estudante = new Estudante("Jose", "jse@com.br");
	}

	@Test
	public void deleteShoulRemoveData() {
		this.estudanteRepository.save(estudante);
		this.estudanteRepository.delete(estudante);
		assertThat(estudanteRepository.findOne(estudante.getId())).isNull();
	}

	@Test
	public void UpdateShouldChangeAndPersistData() {
		this.estudanteRepository.save(estudante);
		estudante.setNome("Maria");
		estudante.setEmail("maria@com.br");
		this.estudanteRepository.save(estudante);
		estudante = estudanteRepository.findOne(estudante.getId());
		assertThat(estudante.getNome()).isEqualTo("Maria");
		assertThat(estudante.getEmail()).isEqualTo("maria@com.br");
	}

}
