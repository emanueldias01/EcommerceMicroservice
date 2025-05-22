package br.com.emanueldias.pagamentos.dto;

import java.math.BigDecimal;

public record PagamentoRequestDTO(
        Long usuarioId,
        BigDecimal valor
) {
}
