package br.com.emanueldias.pedidos.dto;

import br.com.emanueldias.pedidos.model.ItemPedido;

import java.util.List;

public record PedidoRequestDTO(
        Long usuarioId,
        List<ItemPedido> itensDoPedido
) {
}
