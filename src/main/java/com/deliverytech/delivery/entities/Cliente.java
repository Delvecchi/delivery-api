package com.deliverytech.delivery.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
@Schema(description = "Entidade que representa um cliente no sistema")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único do cliente", example = "1")
    private Long id;

    @Schema(description = "Nome do cliente", example = "João da Silva", required = true)
    private String nome;

    @Schema(description = "Email do cliente", example = "email@email.com", required = true)
    private String email;

    @Schema(description = "Telefone do cliente", example = "+5511999999999", required = true)
    private String telefone;

    @Schema(description = "Endereço do cliente", example = "Rua das Flores, 123", required = true)
    private String endereco;

    @Column(nullable = true)
    @Schema(description = "Acesso do cliente ao sistema", example = "true", required = true)
    private boolean ativo;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Schema(description = "CPF do cliente", example = "12345678901")
    private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> pedidos;

    public void inativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", ativo=" + ativo +
                ", dataCadastro=" + dataCadastro +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}




