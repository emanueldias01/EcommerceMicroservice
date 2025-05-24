package br.com.emanueldias.pagamentos.dto;

import br.com.emanueldias.pagamentos.model.FormaPagamento;

import java.math.BigDecimal;

public class PagamentoResponseDTO {
    private Long id;
    private Long usuarioId;
    private Long pedidoId;
    private BigDecimal valor;
    private FormaPagamento formaPagamento;

    public PagamentoResponseDTO(){

    }

    public PagamentoResponseDTO(FormaPagamento formaPagamento, Long id, Long pedidoId, Long usuarioId, BigDecimal valor) {
        this.formaPagamento = formaPagamento;
        this.id = id;
        this.pedidoId = pedidoId;
        this.usuarioId = usuarioId;
        this.valor = valor;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
