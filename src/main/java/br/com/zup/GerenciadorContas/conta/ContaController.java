package br.com.zup.GerenciadorContas.conta;


import br.com.zup.GerenciadorContas.conta.dtos.AtualizarPagamentoDTO;
import br.com.zup.GerenciadorContas.conta.dtos.EntradaDTO;
import br.com.zup.GerenciadorContas.conta.dtos.ResumoDTO;
import br.com.zup.GerenciadorContas.conta.dtos.SaidaDTO;
import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.enums.Tipo;
import br.com.zup.GerenciadorContas.conta.exceptions.StatusInvalidoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
  public SaidaDTO cadastrarConta(@RequestBody @Valid EntradaDTO entradaDTO) {
    Conta conta = modelMapper.map(entradaDTO, Conta.class);
    return modelMapper.map(contaService.cadastrarConta(conta), SaidaDTO.class);

  }

  @GetMapping
  List<ResumoDTO> exibirContas(@RequestParam(required = false) Status status,
                               @RequestParam(required = false) Tipo tipo,
                               @RequestParam(required = false) Double valor) {
    List<ResumoDTO> listaDeContas = new ArrayList<>();
    for (Conta conta : contaService.aplicarFiltros(status, tipo, valor)) {
      ResumoDTO resumo = modelMapper.map(conta, ResumoDTO.class);
      listaDeContas.add(resumo);
    }
    return listaDeContas;

  }

  @PutMapping("/{id}")
  public SaidaDTO atualizarPagamento(@PathVariable int id, @RequestBody AtualizarPagamentoDTO contaAtualizada) {
    if (contaAtualizada.getStatus() == Status.PAGO) {
      return modelMapper.map(contaService.atualizarConta(id), SaidaDTO.class);

    }
    throw new StatusInvalidoException("Status inválido!");

  }

  @GetMapping("/{id}")
  public SaidaDTO buscarInfosPorId(@PathVariable int id) {
    Conta conta = contaService.buscarPorId(id);
    return modelMapper.map(conta, SaidaDTO.class);

  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletarConta(@PathVariable int id) {
    contaService.deletarConta(id);


  }

}


