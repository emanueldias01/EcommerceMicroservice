package br.com.emanueldias.pedidos.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ItemPedido {
    private String nomeProduto;
    private Integer quantidade;
    private Double precoUnitario;
}
