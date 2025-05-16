package br.com.emanueldias.pedidos.repository;

import br.com.emanueldias.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
