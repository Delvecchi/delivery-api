package com.deliverytech.delivery.services;

import com.deliverytech.delivery.dtos.request.ProdutoRequestDTO;
import com.deliverytech.delivery.dtos.response.ProdutoResponseDTO;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdutoService {

    ProdutoResponseDTO cadastrarProduto(ProdutoRequestDTO produtoRequestDTO);
    
    ProdutoResponseDTO buscarProdutoPorId(Long id);

    ProdutoResponseDTO  atualizarProduto(Long id, ProdutoRequestDTO  produtoRequestDTO);

    ProdutoResponseDTO ativarDesativarProduto(Long id);

    ProdutoResponseDTO alterarDisponibilidade(Long id);

    List<ProdutoResponseDTO > buscarProdutosPorNome(String nome);

    List<ProdutoResponseDTO > buscarProdutosPorRestaurante(Long restauranteId);

    List<ProdutoResponseDTO > buscarProdutosPorCategoria(String categoria);

    List<ProdutoResponseDTO > buscarProdutosPorFaixaPreco(BigDecimal precoMinimo,
                                                          BigDecimal precoMaximo);
    List<ProdutoResponseDTO> buscarTodosProdutos();

    List<ProdutoResponseDTO> buscarPorPrecoMenorOuIgual(BigDecimal valor);

    Page<ProdutoResponseDTO> listarProdutosComPaginacao(Pageable pageable,
                                                        Long restauranteId,
                                                        String categoria,
                                                        Boolean disponivel);

    void removerProduto(Long id);
}
