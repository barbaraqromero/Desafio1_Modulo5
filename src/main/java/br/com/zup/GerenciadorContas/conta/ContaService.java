package br.com.zup.GerenciadorContas.conta;


import br.com.zup.GerenciadorContas.conta.enums.Status;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
  @Autowired
  private ContaRepository contaRepository;
  @Autowired
  private ModelMapper modelMapper;

  public Conta cadastrarConta(Conta conta){
    LocalDate dataAtual = LocalDate.now();
    if (conta.getDataDeVencimento().isBefore(dataAtual)) {
      conta.setStatus(Status.VENCIDO);
    } else {
      conta.setStatus(Status.AGUARDANDO);
    }
    conta.setDataDePagamento(null);
    return contaRepository.save(conta);
  }
}
