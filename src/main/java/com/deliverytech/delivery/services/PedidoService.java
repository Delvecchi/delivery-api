package com.deliverytech.delivery.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable; 

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverytech.delivery.dtos.request.ItemPedidoRequestDTO;
import com.deliverytech.delivery.dtos.request.PedidoRequestDTO;
import com.deliverytech.delivery.dtos.response.PedidoResponseDTO;
import com.deliverytech.delivery.enums.StatusPedido;

@Service
@Transactional
public interface PedidoService {

	PedidoResponseDTO criarPedido(PedidoRequestDTO pedidoRequestDTO);
    
    PedidoResponseDTO buscarPedidoPorId(Long id);

    PedidoResponseDTO buscarPedidoPorNumero(String numero);

    List<PedidoResponseDTO> buscarPedidosPorCliente(Long clienteId);

    PedidoResponseDTO atualizarStatusPedido(Long id, StatusPedido status);
    
    //    List<PedidoResponseDTO> buscarPedidosPorRestaurante(Long restauranteId);
    List<PedidoResponseDTO> buscarPedidosPorRestaurante(Long restauranteId, StatusPedido status);

    BigDecimal calcularTotalPedido(List<ItemPedidoRequestDTO> itens);

    PedidoResponseDTO cancelarPedido(Long id);


    List<PedidoResponseDTO> buscarPedidosPorRestaurante(Long restauranteId);

    Page<PedidoResponseDTO> listarPedidosComPaginacao(StatusPedido status, LocalDate dataInicio, LocalDate dataFim,
            Pageable pageable);

    Page<PedidoResponseDTO> listarPorCliente(Pageable pageable);

} 

