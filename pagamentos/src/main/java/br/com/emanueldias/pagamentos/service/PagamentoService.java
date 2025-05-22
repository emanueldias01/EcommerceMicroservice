package br.com.emanueldias.pagamentos.service;

import br.com.emanueldias.pagamentos.dto.PagamentoRequestDTO;
import br.com.emanueldias.pagamentos.dto.PagamentoResponseDTO;
import br.com.emanueldias.pagamentos.dto.PagamentoUpdateFormaPagamentoDTO;
import br.com.emanueldias.pagamentos.model.FormaPagamento;
import br.com.emanueldias.pagamentos.model.Pagamento;
import br.com.emanueldias.pagamentos.model.Status;
import br.com.emanueldias.pagamentos.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    @Autowired
    ModelMapper modelMapper;

    public PagamentoResponseDTO buscaPorId(Long id){
        Pagamento pagamento = repository.getReferenceById(id);
        return modelMapper.map(pagamento, PagamentoResponseDTO.class);
    }

    public PagamentoResponseDTO cria(PagamentoRequestDTO dto){
        //recebe via queue rabbitMq
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);

        pagamento.setFormaPagamento(FormaPagamento.NAO_DEFINIDO);
        pagamento.setStatus(Status.EM_ABERTO);

        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoResponseDTO.class);
    }

    public PagamentoResponseDTO aprovaPagamento(Long id){
        Pagamento pagamento = repository.getReferenceById(id);

        pagamento.setStatus(Status.APROVADO);

        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoResponseDTO.class);
    }

    public PagamentoResponseDTO cancelaPagamento(Long id){
        Pagamento pagamento = repository.getReferenceById(id);

        pagamento.setStatus(Status.CANCELADO);

        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoResponseDTO.class);
    }

    public PagamentoResponseDTO mudaFormaPagamento(PagamentoUpdateFormaPagamentoDTO dto){
        Pagamento pagamento = repository.getReferenceById(dto.id());

        pagamento.setFormaPagamento(dto.formaPagamento());
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoResponseDTO.class);
    }
}
