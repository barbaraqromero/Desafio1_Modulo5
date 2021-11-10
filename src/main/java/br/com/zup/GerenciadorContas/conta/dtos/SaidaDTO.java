package br.com.zup.GerenciadorContas.conta.dtos;

import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.enums.Tipo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SaidaDTO {
  private int id;
  private String nome;
  private double valor;
  private Tipo tipo;
  private LocalDate dataDeVencimento;
  private LocalDateTime dataDePagamento;
  private Status status;

  public SaidaDTO() {

  }

  public SaidaDTO(int id, String nome, double valor, Tipo tipo, LocalDate dataDeVencimento, LocalDateTime dataDePagamento, Status status) {
    this.id = id;
    this.nome = nome;
    this.valor = valor;
    this.tipo = tipo;
    this.dataDeVencimento = dataDeVencimento;
    this.dataDePagamento = dataDePagamento;
    this.status = status;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public LocalDate getDataDeVencimento() {
    return dataDeVencimento;
  }

  public void setDataDeVencimento(LocalDate dataDeVencimento) {
    this.dataDeVencimento = dataDeVencimento;
  }

  public LocalDateTime getDataDePagamento() {
    return dataDePagamento;
  }

  public void setDataDePagamento(LocalDateTime dataDePagamento) {
    this.dataDePagamento = dataDePagamento;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
