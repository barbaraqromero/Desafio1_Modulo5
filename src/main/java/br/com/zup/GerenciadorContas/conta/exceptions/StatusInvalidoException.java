package br.com.zup.GerenciadorContas.conta.exceptions;

public class StatusInvalidoException extends RuntimeException{
  public StatusInvalidoException (String mensagem) {
    super(mensagem);
  }

}
