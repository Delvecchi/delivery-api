package com.deliverytech.delivery.entities;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
@Schema(description = "Entidade que representa um produto no sistema")
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(description = "Identificador único do restaurante", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  private Long id;

  @Schema(description = "Nome do produto", example = "Pizza Margherita", requiredMode = Schema.RequiredMode.REQUIRED)
  private String nome;

  @Schema(description = "Descrição do produto", example = "Deliciosa pizza com molho de tomate, mussarela e manjericão", requiredMode = Schema.RequiredMode.REQUIRED)
  private String descricao;

  @Schema(description = "Preço do produto", example = "29.90", required = true)
  private BigDecimal preco;

  @Schema(description = "Categoria do produto", example = "Pizzas", requiredMode = Schema.RequiredMode.REQUIRED)
  private String categoria;

  @Schema(description = "Disponibilidade do produto", example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
  private Boolean disponivel;

  @Schema(description = "Estoque do produto", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
  private Integer estoque;

  private Boolean ativo;

  @ManyToOne
  @JoinColumn(name = "restaurante_id", nullable = false)
  @Schema(description = "Restaurante vinculado ao produto", example = "Pizzaria Bella", required = true)
  private Restaurante restaurante;

  public boolean getDisponivel() {
    return disponivel;
  }

  public void setDisponivel(Boolean disponivel) {
    this.disponivel = disponivel;
  }

  public Integer getEstoque() {
    return estoque;
  }

  public void setEstoque(Integer estoque) {
    this.estoque = estoque;
  }

}
