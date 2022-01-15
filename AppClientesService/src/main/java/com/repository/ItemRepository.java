package com.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Cliente;

public interface ItemRepository extends MongoRepository<Cliente, String> {

}
