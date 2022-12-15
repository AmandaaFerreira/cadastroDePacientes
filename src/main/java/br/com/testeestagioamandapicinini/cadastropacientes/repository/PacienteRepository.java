package br.com.testeestagioamandapicinini.cadastropacientes.repository;

import br.com.testeestagioamandapicinini.cadastropacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
