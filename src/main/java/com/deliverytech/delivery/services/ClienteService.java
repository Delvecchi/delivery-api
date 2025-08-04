package com.deliverytech.delivery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deliverytech.delivery.dtos.request.ClienteRequestDTO;
import com.deliverytech.delivery.dtos.response.ClienteResponseDTO;
import com.deliverytech.delivery.entities.Cliente;
import com.deliverytech.delivery.repositories.ClienteRepository;

@Service
@Transactional
public interface ClienteService {

	ClienteResponseDTO cadastrarCliente(ClienteRequestDTO cliente);
    ClienteResponseDTO buscarClientePorId(Long id);
    ClienteResponseDTO buscarClientePorEmail(String email);
    List<ClienteResponseDTO> buscarClientePorNome(String nome);
    ClienteResponseDTO atualizarCliente(Long id, ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO ativarDesativarCliente(Long id);
    List<ClienteResponseDTO> listarClientesAtivos();

    // Buscar clientes ativos com paginação
    Page<ClienteResponseDTO> listarAtivosPaginado(Pageable pageable);

    ResponseEntity<Void> deletarCliente(Long id);

    ClienteResponseDTO buscarPorCPF(String cpf);
}
