package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Empleado;
import com.service.IEmpleadoService;

@RestController
public class EmpleadoController {

	@Autowired
	IEmpleadoService service;
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados() {
		return service.obtenerEmpleados();
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<?> getEmpleadoById(@PathVariable String id){
		Optional<Empleado> empleado = service.obtenerEmpleadoId(id);
		if(empleado.isPresent()) {
			return new ResponseEntity<Object>(empleado,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(empleado,null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/empleados")
	public ResponseEntity<?> addEmpleado(@RequestBody Empleado empleado){
		if(empleado != null) {
			service.ingresarEmpleado(empleado);
			return new ResponseEntity<Object>(empleado,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(empleado,null,HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/empleados/{id}")
	public ResponseEntity<?> updateEmpleado(@PathVariable String id, @RequestBody Empleado empleado){
		Optional<Empleado> empleadoOld = service.obtenerEmpleadoId(id);
		if(empleadoOld.isPresent()) {
			service.actualizarEmpleado(id, empleado);
			return new ResponseEntity<Object>(empleado,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(empleado,null,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/empleados/{id}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable String id){
		Optional<Empleado> empleadoOld = service.obtenerEmpleadoId(id);
		if(empleadoOld.isPresent()) {
			service.eliminarEmpleado(id);
			return new ResponseEntity<Object>(empleadoOld,null,HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(empleadoOld,null,HttpStatus.NOT_FOUND);
		}
	}
}
