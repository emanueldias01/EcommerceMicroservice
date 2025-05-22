package br.com.emanueldias.pagamentos.dto;

import br.com.emanueldias.pagamentos.model.FormaPagamento;

public record PagamentoUpdateFormaPagamentoDTO(
        Long id,
        FormaPagamento formaPagamento
) {
}
