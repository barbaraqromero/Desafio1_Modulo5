package br.com.zup.GerenciadorContas.conta;

import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.enums.Tipo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

  List<Conta> findAllByStatus(Status status);

  List<Conta> findAllByTipo(Tipo tipo);

  //Anotação usada para criar filtro que busca valores aproximados àquele valor que está sendo pesquisado
  @Query(value = "SELECT * FROM contas WHERE VALOR BETWEEN :valor*0.5 AND :valor*1.5", nativeQuery = true)
  List<Conta> findAllByValorAproximado(double valor);

}
