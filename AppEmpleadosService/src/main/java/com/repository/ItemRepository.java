package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Empleado;

@Repository
public interface ItemRepository extends MongoRepository<Empleado, String> {

}
