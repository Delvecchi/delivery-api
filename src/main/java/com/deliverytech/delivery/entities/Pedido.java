package com.deliverytech.delivery.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.deliverytech.delivery.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "itens")
@Table(name = "pedidos")
@Schema(description = "Entidade que representa um pedido no sistema")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do restaurante", example = "1")
    private Long id;

    @Column(name = "numero_pedido")
    @Schema(description = "Número do pedido", example = "12345", required = true)
    private String numeroPedido;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Status do pedido", example = "ENTREGUE")
    private StatusPedido status;

    @Schema(description = "Endereço de entrega do pedido", example = "Rua das Flores, 123")
    private String enderecoEntrega;

    @Schema(description = "Subtotal do pedido", example = "99.99", required = true)
    private BigDecimal subtotal;

    @Schema(description = "Taxa de entrega do pedido", example = "5.0", required = true)
    private BigDecimal taxaEntrega;

    @Column(name = "valor_total")
    @Schema(description = "Valor total do pedido", example = "99.99", required = true)
    private BigDecimal valorTotal;

    @Schema(description = "Observações do pedido", example = "Não colocar cebola")
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Schema(description = "Data do pedido", example = "2023-10-01", required = true)
    private LocalDateTime dataPedido;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido itemPedido) {
        itens.add(itemPedido);
    }

    public void confirmar() {
        // lógica futura
    }
}



