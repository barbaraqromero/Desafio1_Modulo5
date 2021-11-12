package br.com.zup.GerenciadorContas.conta.dtos;

import br.com.zup.GerenciadorContas.conta.enums.Tipo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class EntradaDTO {

  @NotBlank
  @Size(min = 2, message = "Digite um nome com pelo menos 2 caracteres")
  private String nome;
  @NotNull
  @DecimalMin(value = "0.01", message = "Digite um valor acima de 0")
  private double valor;
  @NotNull
  private Tipo tipo;
  @NotNull(message = "O campo 'Data de vencimento' deve ser preenchido")
  private LocalDate dataDeVencimento;

  public EntradaDTO() {

  }

  public EntradaDTO(String nome, double valor, Tipo tipo, LocalDate dataDeVencimento) {
    this.nome = nome;
    this.valor = valor;
    this.tipo = tipo;
    this.dataDeVencimento = dataDeVencimento;
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

}
