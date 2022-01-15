package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Cliente;
import com.repository.ItemRepository;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	ItemRepository repo;

	@Override
	public List<Cliente> obtenerClientes() {
		List<Cliente> clientes = repo.findAll();
		return clientes;
	}

	@Override
	public Optional<Cliente> obtenerClienteId(String id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente;
		
	}

	@Override
	public void ingresarCliente(Cliente cliente) {
		repo.save(cliente);
	}

	@Override
	public void actualizarCliente(String id, Cliente cliente) {
		cliente.setId(id);
		repo.save(cliente);
	}

	@Override
	public void eliminarCliente(String id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		repo.delete(cliente);
	}

}
