package br.com.emanueldias.pagamentos.controller;

import br.com.emanueldias.pagamentos.dto.PagamentoResponseDTO;
import br.com.emanueldias.pagamentos.dto.PagamentoUpdateFormaPagamentoDTO;
import br.com.emanueldias.pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoResponseDTO> buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscaPorId(id));
    }

    @PostMapping("/aprova/{id}")
    public ResponseEntity<PagamentoResponseDTO> aprovaPagamento(@PathVariable Long id){
        return ResponseEntity.ok(service.aprovaPagamento(id));
    }

    @PostMapping("/cancela/{id}")
    public ResponseEntity<PagamentoResponseDTO> cancelaPagamento(@PathVariable Long id){
        return ResponseEntity.ok(service.cancelaPagamento(id));
    }

    @PatchMapping
    public ResponseEntity<PagamentoResponseDTO> mudaFormaDePagamento(@RequestBody PagamentoUpdateFormaPagamentoDTO dto){
        return ResponseEntity.ok(service.mudaFormaPagamento(dto));
    }
}
