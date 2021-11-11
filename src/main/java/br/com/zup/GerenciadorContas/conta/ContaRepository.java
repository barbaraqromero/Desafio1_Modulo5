package br.com.zup.GerenciadorContas.conta;

import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.enums.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository <Conta, Integer> {

  List<Conta> findAllByStatus (Status status);

  List<Conta> findAllByTipo (Tipo tipo);
}
