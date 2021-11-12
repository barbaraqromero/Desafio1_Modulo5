package br.com.zup.GerenciadorContas.conta;


import br.com.zup.GerenciadorContas.conta.dtos.AtualizarPagamentoDTO;
import br.com.zup.GerenciadorContas.conta.dtos.EntradaDTO;
import br.com.zup.GerenciadorContas.conta.dtos.ResumoDTO;
import br.com.zup.GerenciadorContas.conta.dtos.SaidaDTO;
import br.com.zup.GerenciadorContas.conta.enums.Status;
import br.com.zup.GerenciadorContas.conta.enums.Tipo;
import br.com.zup.GerenciadorContas.conta.exceptions.StatusInvalidoException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contas")
@Api(value = "Gerenciador de contas")
@CrossOrigin(origins = "*")
public class ContaController {

  @Autowired
  ContaService contaService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Método que permite cadastrar uma conta")
  public SaidaDTO cadastrarConta(@RequestBody @Valid EntradaDTO entradaDTO) {
    Conta conta = modelMapper.map(entradaDTO, Conta.class);
    return modelMapper.map(contaService.cadastrarConta(conta), SaidaDTO.class);

  }

  @GetMapping
  @ApiOperation(value = "Método que permite exibir todas as contas passando parâmetros ou não")
  List<ResumoDTO> exibirContas(@RequestParam(required = false) Status status,
                               @RequestParam(required = false) Tipo tipo,
                               @RequestParam(required = false) Double valor) {
    List<ResumoDTO> listaDeContas = new ArrayList<>();
    for (Conta conta : contaService.aplicarFiltros(status, tipo, valor)) {
      ResumoDTO resumoConta = modelMapper.map(conta, ResumoDTO.class);
      listaDeContas.add(resumoConta);
    }
    return listaDeContas;

  }

  @PutMapping("/{id}")
  @ApiOperation(value = "Método que permite atualizar o status de pagamento de uma determinada conta")
  public SaidaDTO atualizarPagamento(@PathVariable int id, @RequestBody AtualizarPagamentoDTO contaAtualizada) {
    if (contaAtualizada.getStatus() == Status.PAGO) {
      return modelMapper.map(contaService.atualizarConta(id), SaidaDTO.class);

    }
    throw new StatusInvalidoException("Status inválido!");

  }

  @GetMapping("/{id}")
  @ApiOperation(value = "Método que permite buscar informações de uma conta específica através do id")
  public SaidaDTO buscarInfosPorId(@PathVariable int id) {
    Conta conta = contaService.buscarPorId(id);
    return modelMapper.map(conta, SaidaDTO.class);

  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "Método que permite deletar uma conta a partir de um id específico")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deletarConta(@PathVariable int id) {
    contaService.deletarConta(id);

  }

}


