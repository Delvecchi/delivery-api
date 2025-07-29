package com.deliverytech.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.deliverytech.delivery.entity.Cliente;
import com.deliverytech.delivery.entity.Pedido;
import com.deliverytech.delivery.entity.StatusPedido;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // Buscar pedidos por cliente
    List<Pedido> findByClienteOrderByDataPedidoDesc(Cliente cliente);

    // Buscar pedidos por cliente ID
    List<Pedido> findByClienteIdOrderByDataPedidoDesc(Long clienteId);

    // Buscar por status
    List<Pedido> findByStatusOrderByDataPedidoDesc(StatusPedido status);

    // Buscar por número do pedido
    Pedido findByNumeroPedido(String numeroPedido);

    // Buscar pedidos por período
    List<Pedido> findByDataPedidoBetweenOrderByDataPedidoDesc(LocalDateTime inicio, LocalDateTime fim);

    // Buscar pedidos do dia
    @Query(value = "SELECT * FROM pedidos WHERE DATE(data_pedido) = CURRENT_DATE ORDER BY data_pedido DESC", nativeQuery = true)
    List<Pedido> findPedidosDodia();


    // Buscar pedidos por restaurante
    @Query("SELECT p FROM Pedido p WHERE p.restaurante.id = :restauranteId ORDER BY p.dataPedido DESC")
    List<Pedido> findByRestauranteId(@Param("restauranteId") Long restauranteId);

    // Relatório - pedidos por status
    @Query("SELECT p.status, COUNT(p) FROM Pedido p GROUP BY p.status")
    List<Object[]> countPedidosByStatus();

    // Pedidos pendentes (para dashboard)
    @Query("SELECT p FROM Pedido p WHERE p.status IN ('PENDENTE', 'CONFIRMADO', 'PREPARANDO') " +
           "ORDER BY p.dataPedido ASC")
    List<Pedido> findPedidosPendentes();

    // Valor total de vendas por período
    @Query("SELECT SUM(p.valorTotal) FROM Pedido p WHERE p.dataPedido BETWEEN :inicio AND :fim " +
           "AND p.status NOT IN ('CANCELADO')")
    BigDecimal calcularVendasPorPeriodo(@Param("inicio") LocalDateTime inicio,
                                       @Param("fim") LocalDateTime fim);

    @Query("SELECT p.restaurante.nome, SUM(p.valorTotal) " +
       "FROM Pedido p " +
       "GROUP BY p.restaurante.id, p.restaurante.nome " +
       "ORDER BY SUM(p.valorTotal) DESC")
List<Object[]> calcularTotalVendasPorRestaurante();

@Query("SELECT p FROM Pedido p WHERE p.valorTotal > :valor ORDER BY p.valorTotal DESC")
List<Pedido> buscarPedidosComValorAcimaDe(@Param("valor") BigDecimal valor);

@Query("SELECT p FROM Pedido p " +
       "WHERE p.dataPedido BETWEEN :inicio AND :fim " +
       "AND p.status = :status " +
       "ORDER BY p.dataPedido DESC")
List<Pedido> relatorioPedidosPorPeriodoEStatus(
    @Param("inicio") LocalDateTime inicio,
    @Param("fim") LocalDateTime fim,
    @Param("status") StatusPedido status
);

}

