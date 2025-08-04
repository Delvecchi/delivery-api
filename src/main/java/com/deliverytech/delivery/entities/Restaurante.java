package com.deliverytech.delivery.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurantes")
@Schema(description = "Entidade que representa um restaurante no sistema")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do restaurante", example = "1")
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    @Schema(description = "Nome do restaurante", example = "Pizza Palace", required = true)
    private String nome;

    @Column(nullable = false)
    @NotBlank(message = "Categoria é obrigatória")
    @Schema(description = "Categoria/ tipo de culinária do restaurante", example = "Italiana", required = true)
    private String categoria;

    @Column(nullable = false)
    @NotBlank(message = "Endereço é obrigatório")
    @Schema(description = "Endereço completo do restaurante", example = "Rua das Pizzas, 123 - Centro, São Paulo - SP", required = true)
    private String endereco;

    @Column(nullable = false)
    @NotBlank(message = "Telefone é obrigatório")
    @Schema(description = "Telefone de contato do restaurante", example = "(11) 1234-5678", required = true)
    private String telefone;

    @Column(name = "taxa_entrega")
    private BigDecimal taxaEntrega;

    @Column(precision = 3, scale = 2)
    @Schema(description = "Avaliação média do restaurante (0 a 5 estrelas)", example = "4.5", minimum = "0", maximum = "5")
    private BigDecimal avaliacao;

    @Column(nullable = false)
    @Schema(description = "Indica se o restaurante está ativo no sistema", example = "true", defaultValue = "true")
    private boolean ativo;

    @Schema(description = "Tempo de entrega do restaurante", example = "45")
    private Integer tempoEntregaMinutos;

    @Schema(description = "Horário de funcionamento do restaurante", example = "09:00-22:00")
    private String horarioFuncionamento;

    @Column(name = "data_criacao", nullable = false)
    @Schema(description = "Data e hora de criação do registro", example = "2024-06-04T10:30:00")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de produtos oferecidos pelo restaurante")
    @JsonIgnore
    private List<Produto> produtos;

    @OneToMany(mappedBy = "restaurante")
    @JsonIgnore
    private List<Pedido> pedidos;

    public void inativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", taxaEntrega=" + taxaEntrega +
                ", avaliacao=" + avaliacao +
                ", ativo=" + ativo +
                ", tempoEntregaMinutos=" + tempoEntregaMinutos +
                ", horarioFuncionamento='" + horarioFuncionamento + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}





