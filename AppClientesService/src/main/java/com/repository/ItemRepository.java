package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Cliente;

/*@Repository
public interface ItemRepository extends MongoRepository<Cliente, String> {

}*/

@Repository
public interface ItemRepository extends JpaRepository<Cliente, Integer> {
}
