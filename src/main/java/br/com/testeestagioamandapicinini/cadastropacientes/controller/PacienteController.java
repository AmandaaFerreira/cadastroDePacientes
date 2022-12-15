package br.com.testeestagioamandapicinini.cadastropacientes.controller;

import br.com.testeestagioamandapicinini.cadastropacientes.formulario.CriarPacienteFormulario;
import br.com.testeestagioamandapicinini.cadastropacientes.model.Paciente;
import br.com.testeestagioamandapicinini.cadastropacientes.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping("cadastro")
    public String formulario(CriarPacienteFormulario criarPacienteFormulario) {
        return "formulario";
    }

    @GetMapping("todos")
    public String todos(Model model) {

        List<Paciente> pacientes = pacienteRepository.findAll();
        if(!pacientes.isEmpty()) {
            model.addAttribute("pacientes" , pacientes);
            return "todos";
        }

        return "redirect:/home";
    }

    @PostMapping("novo")
    public String novo(@Valid CriarPacienteFormulario criarPacienteFormulario, BindingResult result) {
        if(result.hasErrors()) {
            return "formulario";
        }

        Paciente paciente = criarPacienteFormulario.converterParaPaciente();
        if (paciente != null) {
            pacienteRepository.save(paciente);
        }

        return "redirect:/home";
    }

}
