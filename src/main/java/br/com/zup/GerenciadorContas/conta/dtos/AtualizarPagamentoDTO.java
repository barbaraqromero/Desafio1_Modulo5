package br.com.zup.GerenciadorContas.conta.dtos;

import br.com.zup.GerenciadorContas.conta.enums.Status;

public class AtualizarPagamentoDTO {
  private Status status;

  public AtualizarPagamentoDTO() {

  }

  public AtualizarPagamentoDTO(Status status) {
    this.status = status;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
