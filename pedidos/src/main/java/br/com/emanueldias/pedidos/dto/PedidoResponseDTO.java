package br.com.emanueldias.pedidos.dto;

import br.com.emanueldias.pedidos.model.ItemPedido;
import br.com.emanueldias.pedidos.model.StatusPedido;
import java.util.List;

public class PedidoResponseDTO {

    private Long id;
    private Long usuarioId;
    private StatusPedido statusPedido;
    private List<ItemPedido> itensDoPedido;

    public PedidoResponseDTO() {
    }

    public PedidoResponseDTO(Long id, Long usuarioId, StatusPedido statusPedido, List<ItemPedido> itensDoPedido) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.statusPedido = statusPedido;
        this.itensDoPedido = itensDoPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public List<ItemPedido> getItensDoPedido() {
        return itensDoPedido;
    }

    public void setItensDoPedido(List<ItemPedido> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }
}

