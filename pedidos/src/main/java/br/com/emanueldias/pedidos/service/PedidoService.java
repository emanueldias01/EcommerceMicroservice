package br.com.emanueldias.pedidos.service;

import br.com.emanueldias.pedidos.dto.PedidoRequestDTO;
import br.com.emanueldias.pedidos.dto.PedidoResponseDTO;
import br.com.emanueldias.pedidos.model.Pedido;
import br.com.emanueldias.pedidos.model.StatusPedido;
import br.com.emanueldias.pedidos.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public PedidoResponseDTO criaPedido(PedidoRequestDTO dto){
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        pedido.setStatusPedido(StatusPedido.REALIZADO);

        pedido.setId(null);
        repository.save(pedido);
        Message message = new Message("pedido realizado".getBytes());
        rabbitTemplate.send("pedido.realizado",message);

        return modelMapper.map(pedido, PedidoResponseDTO.class);
    }

    public PedidoResponseDTO buscaPorId(Long id){
        Pedido pedido = repository.getReferenceById(id);

        return modelMapper.map(pedido, PedidoResponseDTO.class);
    }

    public List<PedidoResponseDTO> buscaPedidosDoUsuario(Long usuarioId){
        List<Pedido> pedidoList = repository.findByUsuarioId(usuarioId);

        return pedidoList.stream().map(p -> modelMapper.map(p, PedidoResponseDTO.class)).toList();
    }

    public PedidoResponseDTO cancelaPedido(Long id){
        Pedido pedido = repository.getReferenceById(id);
        pedido.setStatusPedido(StatusPedido.CANCELADO);
        repository.save(pedido);

        return modelMapper.map(pedido, PedidoResponseDTO.class);
    }

    public PedidoResponseDTO pagarPedido(Long id){
        Pedido pedido = repository.getReferenceById(id);
        pedido.setStatusPedido(StatusPedido.PAGO);
        repository.save(pedido);

        return modelMapper.map(pedido, PedidoResponseDTO.class);
    }


}
