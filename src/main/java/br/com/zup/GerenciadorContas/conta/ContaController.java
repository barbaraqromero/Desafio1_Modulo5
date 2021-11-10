package br.com.zup.GerenciadorContas.conta;


import br.com.zup.GerenciadorContas.conta.dtos.AtualizarPagamentoDTO;
import br.com.zup.GerenciadorContas.conta.dtos.EntradaDTO;
import br.com.zup.GerenciadorContas.conta.dtos.ResumoDTO;
import br.com.zup.GerenciadorContas.conta.dtos.SaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {
  @Autowired
  ContaService contaService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SaidaDTO cadastrarConta(@RequestBody EntradaDTO entradaDTO) {
    Conta conta = modelMapper.map(entradaDTO, Conta.class);
    return modelMapper.map(contaService.cadastrarConta(conta), SaidaDTO.class);

  }

  @GetMapping
  List<ResumoDTO> exibirContas() {
    List<ResumoDTO> listaDeContas = new ArrayList<>();
    for (Conta conta : contaService.exibirContas()) {
      ResumoDTO resumo = modelMapper.map(conta, ResumoDTO.class);
      listaDeContas.add(resumo);
    }
    return listaDeContas;

  }

  @PutMapping("{id}")
  public SaidaDTO atualizarPagamento (@PathVariable int id, @RequestBody AtualizarPagamentoDTO contaAtualizada){
    return modelMapper.map(contaService.atualizarConta(id), SaidaDTO.class);

  }




}


