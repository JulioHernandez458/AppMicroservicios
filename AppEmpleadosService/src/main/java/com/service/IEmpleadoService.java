package com.service;

import java.util.List;
import java.util.Optional;

import com.model.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> obtenerEmpleados();
	
	public Optional<Empleado> obtenerEmpleadoId(String id);
	
	public void ingresarEmpleado(Empleado empleado);
	
	public void actualizarEmpleado(String id, Empleado empleado);
	
	public void eliminarEmpleado(String id);
	
}
