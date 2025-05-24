package br.com.emanueldias.pedidos.controller;

import br.com.emanueldias.pedidos.dto.PedidoRequestDTO;
import br.com.emanueldias.pedidos.dto.PedidoResponseDTO;
import br.com.emanueldias.pedidos.service.PedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criaPedido(@RequestBody PedidoRequestDTO dto, UriComponentsBuilder uriComponentsBuilder){
        PedidoResponseDTO pedido = service.criaPedido(dto);
        var uri = uriComponentsBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();

        rabbitTemplate.convertAndSend("pedido.ex", "", pedido);
        return ResponseEntity.created(uri).body(pedido);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscaPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscaPorId(id));
    }

    @GetMapping("/usuairo/{id}")
    public ResponseEntity<List<PedidoResponseDTO>> buscaPedidosDoUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.buscaPedidosDoUsuario(id));
    }

    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<PedidoResponseDTO> cancelaPedido(@PathVariable Long id){
        return ResponseEntity.ok(service.cancelaPedido(id));
    }

    @PatchMapping("/pagar/{id}")
    public ResponseEntity<PedidoResponseDTO> pagaPedido(@PathVariable Long id){
        return ResponseEntity.ok(service.pagarPedido(id));
    }
}
