package br.com.emanueldias.pedidos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name="pedidos")

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long usuarioId;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private StatusPedido statusPedido;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ItemPedido> itensDoPedido;

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

    public @NotNull StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public @NotNull Long getUsuarioId() {
        return usuarioId;
    }

    public void setStatusPedido(@NotNull StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void setUsuarioId(@NotNull Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
