package com.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@ToString @EqualsAndHashCode
@Document("empleado")
public class Empleado {
	
	@Id 
	private String id;
	private String nombre;
	private String apellido;
	private String email;
	private String area;
	
	public Empleado(String nombre, String apellido, String email, String area) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.area = area;
	}

	public Empleado() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	

}
