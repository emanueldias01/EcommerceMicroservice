package br.com.emanueldias.email.service;

import br.com.emanueldias.email.dto.InfoPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    JavaMailSender mailSender;

    public void enviaEmailDeConfirmacaoDePedido(InfoPedidoDTO dto){
        var mensagem = new SimpleMailMessage();

        mensagem.setFrom("ecommerce@email.com");
        mensagem.setTo("emailcliente@email.com");
        mensagem.setSubject("Confirmação do seu pedido");

        mensagem.setText("""
        Olá!

        Informamos que o seu pagamento foi aprovado com sucesso e o seu pedido está confirmado.

        Detalhes do pedido:
        """ + dto.itens() + """

        Valor total da compra: R$ """ + dto.valor() + """

        Agradecemos por comprar conosco.
        Em breve você receberá atualizações sobre o envio.

        Atenciosamente,
        Equipe E-Commerce
        """);

        mailSender.send(mensagem);
    }

    public void enviaEmailDeSolicitacaoDePagamento(InfoPedidoDTO dto){
        var mensagem = new SimpleMailMessage();
        mensagem.setFrom("ecommerce@email.com");
        mensagem.setTo("emailcliente@email.com");
        mensagem.setSubject("Confirmação do seu pedido");

        mensagem.setSubject("Solicitação de pagamento do seu pedido");

        mensagem.setText("""
        Olá!

        Recebemos seu pedido e agora estamos aguardando o pagamento para dar continuidade ao processo.

        Detalhes do pedido:
        """ + dto.itens() + """

        Valor total a ser pago: R$ """ + dto.valor() + """

        Assim que o pagamento for confirmado, enviaremos a confirmação e atualizações sobre o envio.

        Em caso de dúvidas, estamos à disposição.

        Atenciosamente,
        Equipe E-Commerce
        """);

        mailSender.send(mensagem);
    }
}
