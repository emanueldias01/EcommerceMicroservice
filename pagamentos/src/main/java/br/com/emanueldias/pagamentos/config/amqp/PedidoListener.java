package br.com.emanueldias.pagamentos.config.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {

    @RabbitListener(queues = "pedido.realizado")
    public void recebeMensagem(Message message){
        System.out.println(message.toString());
    }
}
