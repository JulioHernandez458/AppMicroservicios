package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Cliente;
import com.service.IClienteService;

@RestController
public class ClienteController {

	@Autowired
	IClienteService service;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes() {
		return service.obtenerClientes();
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> getClienteById(@PathVariable int id){
		Optional<Cliente> cliente = service.obtenerClienteId(id);
		if(cliente.isPresent()) {
			return new ResponseEntity<Object>(cliente,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(cliente,null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> addCliente(@RequestBody Cliente cliente){
		if(cliente != null) {
			service.ingresarCliente(cliente);
			return new ResponseEntity<Object>(cliente,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(cliente,null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> updateClientes(@PathVariable Integer id, @RequestBody Cliente cliente){
		Optional<Cliente> clienteOld = service.obtenerClienteId(id);
		if(clienteOld.isPresent()) {
			service.actualizarCliente(id, cliente);
			return new ResponseEntity<Object>(clienteOld,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(clienteOld,null,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> deleteClientes(@PathVariable int id){
		Optional<Cliente> clienteOld = service.obtenerClienteId(id);
		if(clienteOld.isPresent()) {
			service.eliminarCliente(id);
			return new ResponseEntity<Object>(clienteOld,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(clienteOld,null,HttpStatus.NOT_FOUND);
		}
	}
}
