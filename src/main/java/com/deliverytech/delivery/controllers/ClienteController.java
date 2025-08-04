package com.deliverytech.delivery.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deliverytech.delivery.dtos.request.ClienteRequestDTO;
import com.deliverytech.delivery.dtos.response.ApiResponseWrapper;
import com.deliverytech.delivery.dtos.response.ClienteResponseDTO;
import com.deliverytech.delivery.dtos.response.PagedResponseWrapper;
import com.deliverytech.delivery.entities.Cliente;
import com.deliverytech.delivery.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
@Tag(name = "Clientes", description = "Operações relacionadas aos clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	/**
	 * Cadastrar novo cliente
	 */
	@PostMapping
	@Operation(summary = "Cadastrar cliente",
            description = "Cria um novo cliente no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Requisição inválida"),
            @ApiResponse(responseCode = "409", description = "Cliente já cadastrado")
    })
    public ResponseEntity<ApiResponseWrapper<ClienteResponseDTO>> cadastrarCliente(@Valid @RequestBody
                                                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                                                           description = "Dados do cliente a ser criado"
                                                                                   )
                                                                                   ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = clienteService.cadastrarCliente(clienteRequestDTO);
        ApiResponseWrapper<ClienteResponseDTO> response =
                new ApiResponseWrapper<>(true, clienteResponseDTO, "Cliente criado com sucesso");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/**
	 * Listar todos os clientes ativos
	 */
	@GetMapping
        @PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Listar clientes ativos",
            description = "Lista todos os clientes que estão ativos no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de clientes recuperada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado")
    })
    public ResponseEntity<PagedResponseWrapper<ClienteResponseDTO>> listarClientesAtivos(Pageable pageable) {
        Page<ClienteResponseDTO> clientes = clienteService.listarAtivosPaginado(pageable);
        PagedResponseWrapper<ClienteResponseDTO> response =  new PagedResponseWrapper<>(clientes);
        return ResponseEntity.ok(response);
    }

	/**
	 * Buscar cliente por ID
	 */
	@GetMapping("/{id}")
        @PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Buscar cliente por ID",
            description = "Recupera os detalhes de um cliente específico pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<ApiResponseWrapper<ClienteResponseDTO>> buscarPorId(@PathVariable Long id) {
		ClienteResponseDTO cliente = clienteService.buscarClientePorId(id);
        ApiResponseWrapper<ClienteResponseDTO> response =
                new ApiResponseWrapper<>(true, cliente, "busca realizada com sucesso");
        return ResponseEntity.ok(response);
	}

	/**
	 * Buscar clientes por nome
	 */
	@GetMapping("/buscar")
        @PreAuthorize("hasRole('ADMIN')")
        @Operation(summary = "Buscar clientes por nome via parametro",
                description = "Recupera uma lista de clientes que correspondem ao nome fornecido")
        @ApiResponses({
                @ApiResponse(responseCode = "200", description = "Clientes encontrados"),
                @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado com o nome fornecido")
        })
        public ResponseEntity<ApiResponseWrapper<List<ClienteResponseDTO>>> buscarClientePorNome(@RequestParam String nome) {
                List<ClienteResponseDTO> clientes = clienteService.buscarClientePorNome(nome);
                ApiResponseWrapper<List<ClienteResponseDTO>> response =
                        new ApiResponseWrapper<>(true, clientes, "busca realizada com sucesso");
                return ResponseEntity.ok(response);
                }

	/**
	 * Buscar cliente por email
	 */
	@GetMapping("/email/{email}")
        @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Buscar cliente por email",
            description = "Recupera os detalhes de um cliente específico pelo email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<ApiResponseWrapper<ClienteResponseDTO>> buscarClientePorEmail(@PathVariable String email) {
        ClienteResponseDTO cliente = clienteService.buscarClientePorEmail(email);
        ApiResponseWrapper<ClienteResponseDTO> response =
                new ApiResponseWrapper<>(true, cliente, "busca realizada com sucesso");
        return ResponseEntity.ok(response);
	}

	/**
	 * Atualizar cliente
	 */
	@PutMapping("/{id}")
        @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENTE')")
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable Long id,
                                       @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteRequestDTO);
        return ResponseEntity.ok(clienteAtualizado);
	}

	/**
	 * Inativar cliente (soft delete)
	 */
	@PatchMapping("/{id}/status")
    @Operation(summary = "Atualizar cliente",
            description = "Atualiza os dados de um cliente existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ApiResponseWrapper<ClienteResponseDTO>> atualizarStatusCliente(@PathVariable Long id,
                                                                                   @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteRequestDTO);
        ApiResponseWrapper<ClienteResponseDTO> response =
                new ApiResponseWrapper<>(true, clienteAtualizado, "cliente atualizado com sucesso");
        return ResponseEntity.ok(response);
	}

	/**
     * Inativar cliente (soft delete)
     */
	@PatchMapping("/api/clientes/{id}/toggle-status")
	@Operation(summary = "Ativar/Desativar cliente",
            description = "Ativa ou desativa o status de um cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente inativado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
    })
    public ResponseEntity<ApiResponseWrapper<ClienteResponseDTO>> ativarDesativarCliente(@PathVariable Long id) {
		ClienteResponseDTO clienteAtualizado = clienteService.ativarDesativarCliente(id);
		ApiResponseWrapper<ClienteResponseDTO> response =
                new ApiResponseWrapper<>(true, clienteAtualizado, "cliente inativado com sucesso");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponseWrapper<Void>> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        ApiResponseWrapper<Void> response =
                new ApiResponseWrapper<>(true, null, "cliente deletado com sucesso");
        return ResponseEntity.noContent().build();
    }
}

