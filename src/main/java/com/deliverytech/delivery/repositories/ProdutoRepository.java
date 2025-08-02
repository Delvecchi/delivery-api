package com.deliverytech.delivery.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deliverytech.delivery.entities.Produto;
import com.deliverytech.delivery.entities.Restaurante;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {


    // Produtos disponíveis
	List<Produto> findByDisponivelTrue();

	// Produtos por restaurante
    List<Produto> findByRestauranteAndDisponivelTrue(Restaurante restaurante);

    List<Produto> findByRestauranteIdAndDisponivelTrue(Long restauranteId);

    // Buscar por categoria
    List<Produto> findByCategoriaAndDisponivelTrue(String categoria);

    List<Produto> findByRestauranteId(Long restauranteId);

    List<Produto> findByCategoria(String categoria);

    // Buscar por nome contendo
    List<Produto> findByNomeContainingIgnoreCaseAndDisponivelTrue(String nome);

    // Buscar por faixa de preço
    List<Produto> findByPrecoBetweenAndDisponivelTrue(BigDecimal precoMin, BigDecimal precoMax);

    // Buscar produtos mais baratos que um valor
    List<Produto> findByPrecoLessThanEqualAndDisponivelTrue(BigDecimal preco);

    List<Produto> findByPrecoLessThanEqual(BigDecimal preco);

    // Ordenar por preço
    List<Produto> findByDisponivelTrueOrderByPrecoAsc();

    List<Produto> findByDisponivelTrueOrderByPrecoDesc();

    
}

