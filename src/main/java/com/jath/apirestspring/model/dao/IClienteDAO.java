package com.jath.apirestspring.model.dao;

import com.jath.apirestspring.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDAO extends CrudRepository<Cliente, Integer> {
}
