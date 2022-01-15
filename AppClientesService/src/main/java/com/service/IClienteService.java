package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Cliente;

public interface IClienteService {
	
	public List<Cliente> obtenerClientes();
	
	public Optional<Cliente> obtenerClienteId(String id);
	
	public void ingresarCliente(Cliente cliente);
	
	public void actualizarCliente(String id, Cliente cliente);
	
	public void eliminarCliente(String id);
	
}
