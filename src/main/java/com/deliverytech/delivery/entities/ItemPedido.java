package com.deliverytech.delivery.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Data
@Table(name = "itens_pedido")
@Schema(description = "Entidade que representa itens de um pedido no sistema")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do item", example = "1")
    private Long id;

    @Schema(description = "Quantidade do produto no pedido", example = "2", required = true)
    private int quantidade;

    @Schema(description = "Preço unitário de um item", example = "10.90", required = true)
    private BigDecimal precoUnitario;

    @Schema(description = "Subtotal do item", example = "10.90", required = true)
    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

	public void calcularSubtotal() {
		
	}

    public BigDecimal getSubtotal() {
    return subtotal != null ? subtotal : BigDecimal.ZERO;
}

}



