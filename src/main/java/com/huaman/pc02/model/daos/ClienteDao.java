package com.huaman.pc02.model.daos;

import com.huaman.pc02.model.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}
