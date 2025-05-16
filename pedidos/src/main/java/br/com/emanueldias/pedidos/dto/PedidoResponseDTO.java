package br.com.emanueldias.pedidos.dto;

import br.com.emanueldias.pedidos.model.ItemPedido;
import br.com.emanueldias.pedidos.model.StatusPedido;

import java.util.List;

public record PedidoResponseDTO(
        Long id,
        Long usuarioId,
        StatusPedido statusPedido,
        List<ItemPedido> itensDoPedido
) {
}
