package com.deliverytech.delivery.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    void deleteById(Long id);

    @Query("SELECT p FROM Produto p " +
            "WHERE " +
            "(:restauranteId IS NULL OR p.restaurante.id = :restauranteId  ) AND " +
            "(:categoria IS NULL OR p.categoria = :categoria) AND " +
            "(:disponivel IS NULL OR p.disponivel = :disponivel)")
    Page<Produto> listarProdutosComPaginacao(Pageable pageable, @Param("restauranteId") Long restauranteId,
                                             @Param("categoria") String categoria, @Param("disponivel") Boolean disponivel);
}

