package br.com.zup.GerenciadorContas.conta;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
  @Autowired
  private ContaRepository contaRepository;
}
