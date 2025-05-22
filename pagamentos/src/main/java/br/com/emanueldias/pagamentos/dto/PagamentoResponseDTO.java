package br.com.emanueldias.pagamentos.dto;

import br.com.emanueldias.pagamentos.model.FormaPagamento;

import java.math.BigDecimal;

public record PagamentoResponseDTO(
        Long id,
        Long usuarioId,
        Long pedidoId,
        BigDecimal valor,
        FormaPagamento formaPagamento
) {
}
