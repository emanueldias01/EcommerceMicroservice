package br.com.emanueldias.pagamentos.config.amqp;

import br.com.emanueldias.pagamentos.config.amqp.dto.PedidoDTO;
import br.com.emanueldias.pagamentos.service.PagamentoService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    @Autowired
    PagamentoService service;

    @RabbitListener(queues = "pedido.realizado")
    public void recebeMensagem(@Payload PedidoDTO dto){
        System.out.println(dto.getItensDoPedido());
        service.cria(dto);
    }
}
