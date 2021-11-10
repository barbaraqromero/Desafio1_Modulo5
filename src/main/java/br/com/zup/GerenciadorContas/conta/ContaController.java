package br.com.zup.GerenciadorContas.conta;


import br.com.zup.GerenciadorContas.conta.dtos.EntradaDTO;
import br.com.zup.GerenciadorContas.conta.dtos.SaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
