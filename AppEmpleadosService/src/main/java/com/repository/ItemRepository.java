package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Empleado;

public interface ItemRepository extends MongoRepository<Empleado, String> {

}
