package br.com.emanueldias.pagamentos.config.amqp.dto;

import java.util.List;

public class PedidoDTO {
    private Long id;
    private Long usuarioId;
    private StatusPedido statusPedido;
    private List<ItemPedido> itensDoPedido;

    public PedidoDTO(){

    }

    public PedidoDTO(Long id, List<ItemPedido> itensDoPedido, StatusPedido statusPedido, Long usuarioId) {
        this.id = id;
        this.itensDoPedido = itensDoPedido;
        this.statusPedido = statusPedido;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemPedido> getItensDoPedido() {
        return itensDoPedido;
    }

    public void setItensDoPedido(List<ItemPedido> itensDoPedido) {
        this.itensDoPedido = itensDoPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
