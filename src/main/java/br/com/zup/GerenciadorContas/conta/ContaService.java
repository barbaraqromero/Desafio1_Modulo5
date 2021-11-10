package br.com.zup.GerenciadorContas.conta;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
  @Autowired
  private ContaRepository contaRepository;
  @Autowired
  private ModelMapper modelMapper;

  public Conta cadastrarConta(Conta conta){
    conta.setDataDePagamento(null);
    return contaRepository.save(conta);
  }
}
