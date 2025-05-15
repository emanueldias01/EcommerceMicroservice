package br.com.emanueldias.pedidos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="pedidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long usuarioId;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private ModoPagamento modoPagamento;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private StatusPedido statusPedido;

    @ElementCollection
    private List<ItemPedido> itensDoPedido;

}
