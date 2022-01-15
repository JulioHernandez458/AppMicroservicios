package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Empleado;
import com.repository.ItemRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
	
	@Autowired
	ItemRepository repo;

	@Override
	public List<Empleado> obtenerEmpleados() {
		List<Empleado> empleados = repo.findAll();
		return empleados;
	}

	@Override
	public Optional<Empleado> obtenerEmpleadoId(String id) {
		Optional<Empleado> empleado = repo.findById(id);
		return empleado;
		
	}

	@Override
	public void ingresarEmpleado(Empleado empleado) {
		repo.save(empleado);
	}

	@Override
	public void actualizarEmpleado(String id, Empleado empleado) {
		empleado.setId(id);
		repo.save(empleado);
	}

	@Override
	public void eliminarEmpleado(String id) {
		Empleado empleado = new Empleado();
		empleado.setId(id);
		repo.delete(empleado);
	}

}
