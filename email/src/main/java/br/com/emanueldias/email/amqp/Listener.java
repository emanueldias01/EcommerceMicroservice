package br.com.emanueldias.email.amqp;

import br.com.emanueldias.email.amqp.dto.PedidoDTO;
import br.com.emanueldias.email.dto.InfoPedidoDTO;
import br.com.emanueldias.email.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @Autowired
    EmailService service;

    @RabbitListener(queues = "pedido.email")
    public void PedidoListener(@Payload PedidoDTO dto){

        System.out.println(dto.getItensDoPedido());

        InfoPedidoDTO info = new InfoPedidoDTO(dto.getItensDoPedido()
                .stream().map(i -> i.getNomeProduto()).toList(), dto.getItensDoPedido()
                .stream().mapToDouble(i -> i.getQuantidade() * i.getPrecoUnitario()).sum());

        service.enviaEmailDeSolicitacaoDePagamento(info);
    }
}
