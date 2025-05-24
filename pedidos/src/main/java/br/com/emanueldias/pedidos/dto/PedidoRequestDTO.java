package br.com.emanueldias.pedidos.dto;

import br.com.emanueldias.pedidos.model.ItemPedido;
import java.util.List;

public class PedidoRequestDTO {

    private Long usuarioId;
    private List<ItemPedido> itensDoPedido;

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(Long usuarioId, List<ItemPedido> itensDoPedido) {
        this.usuarioId = usuarioId;
        this.itensDoPedido = itensDoPedido;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemPedido> getItensDoPedido() {
        return itensDoPedido;
    }

    public void setItensDoPedido(List<ItemPedido> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }
}

