package br.com.zup.GerenciadorContas.conta;

import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.enums.Tipo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contas")
public class Conta {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String nome;
  @Column(nullable = false)
  private double valor;
  @Enumerated(EnumType.STRING)
  private Tipo tipo;
  @Column(nullable = false)
  private LocalDate dataDeVencimento;
  @Column(nullable = true)
  private LocalDateTime dataDePagamento;
  @Enumerated(EnumType.STRING)
  private Status status;

  public Conta() {

  }

  public Conta(String nome, double valor, Tipo tipo, LocalDate dataDeVencimento, LocalDateTime dataDePagamento, Status status) {
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
