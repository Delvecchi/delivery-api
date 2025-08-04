package com.deliverytech.delivery.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;

import com.deliverytech.delivery.dtos.request.RestauranteRequestDTO;
import com.deliverytech.delivery.dtos.response.RestauranteResponseDTO;
import com.deliverytech.delivery.projection.RelatorioVendas;

public interface RestauranteService {

    RestauranteResponseDTO cadastrarRestaurante(RestauranteRequestDTO restauranteRequestDTO);
    
    RestauranteResponseDTO buscarRestaurantePorId(Long id);

    RestauranteResponseDTO atualizarRestaurante(Long id, RestauranteRequestDTO restauranteRequestDTO);

    RestauranteResponseDTO ativarDesativarRestaurante(Long id);

    RestauranteResponseDTO buscarRestaurantePorNome(String nome);

    List<RestauranteResponseDTO> buscarRestaurantePorCategoria(String categoria);

    List<RestauranteResponseDTO> buscarRestaurantePorPreco(BigDecimal precoMinimo, BigDecimal precoMaximo);

    List<RestauranteResponseDTO> buscarRestaurantesAtivos();

    List<RestauranteResponseDTO> buscarTop5RestaurantesPorNome();

    List<RelatorioVendas> relatorioVendasPorRestaurante();

    List<RestauranteResponseDTO> buscarPorTaxaEntrega(BigDecimal taxaEntrega);

    BigDecimal calcularTaxaEntrega(Long restauranteId, String cep);

    Page<RestauranteResponseDTO> buscarRestaurantesComPaginacao(String categoria, Boolean ativo, org.springframework.data.domain.Pageable pageable);

    List<RestauranteResponseDTO> buscarRestaurantesProximos(String cep, Integer raio);

    boolean isOwner(Long restauranteId);
}
