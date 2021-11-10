package br.com.zup.GerenciadorContas.conta;


import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.exceptions.IdNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {
  @Autowired
  private ContaRepository contaRepository;
  @Autowired
  private ModelMapper modelMapper;

  public Conta cadastrarConta(Conta conta) {
    LocalDate dataAtual = LocalDate.now();
    if (conta.getDataDeVencimento().isBefore(dataAtual)) {
      conta.setStatus(Status.VENCIDO);
    } else {
      conta.setStatus(Status.AGUARDANDO);
    }
    conta.setDataDePagamento(null);
    return contaRepository.save(conta);
  }

  public List<Conta> exibirContas() {
    List<Conta> contas = (List<Conta>) contaRepository.findAll();
    return contas;
  }

  public Conta buscarPorId(int id) {
    Optional<Conta> conta = contaRepository.findById(id);
    if (conta.isEmpty()){
      throw new IdNaoEncontradoException("Não encontrado!");
    }
    return conta.get();
  }

}
