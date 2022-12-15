package br.com.testeestagioamandapicinini.cadastropacientes.formulario;


import br.com.testeestagioamandapicinini.cadastropacientes.model.Paciente;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
public class CriarPacienteFormulario {

    @NotBlank
    private String nomePaciente;
    @NotBlank
    private String dataNascimento;
    @NotBlank
    private String endereco;
    private String observacoes;


    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Paciente converterParaPaciente(){
        try {
            Paciente paciente = new Paciente();
            paciente.setNomePaciente(getNomePaciente());
            paciente.setEndereco(getEndereco());
            paciente.setObservacoes(getObservacoes());

            paciente.setDataNascimento(LocalDate.parse(getDataNascimento()));
            return paciente;
        }catch (Exception e){
            System.out.println("formulário inválido");
        }
        return null;
    }
}
