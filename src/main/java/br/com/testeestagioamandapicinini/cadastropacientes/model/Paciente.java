package br.com.testeestagioamandapicinini.cadastropacientes.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Paciente {


    public Paciente() {
    }

    public Paciente(Long codigo) {
        this.codigo = codigo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nomePaciente;
    @Column(columnDefinition = "DATE")
    private LocalDate dataNascimento;
    private String endereco;
    private String observacoes;

    public Long getCodigo() {
        return codigo;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    public String getDataNascimentoFormatado() {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return this.dataNascimento.format(formatter);
        } catch (Exception e) {
            return "";
        }
    }
}
