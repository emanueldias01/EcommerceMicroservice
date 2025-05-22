package br.com.emanueldias.email.dto;

import java.math.BigDecimal;
import java.util.List;

public record InfoPedidoDTO(
        List<String> itens,
        BigDecimal valor
) {
}
