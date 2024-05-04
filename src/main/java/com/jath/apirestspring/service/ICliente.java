package com.jath.apirestspring.service;

import com.jath.apirestspring.model.dto.ClienteDto;
import com.jath.apirestspring.model.entity.Cliente;

public interface ICliente {

    Cliente save(ClienteDto cliente);
    Cliente findById(Integer id);
    void delete(Cliente cliente);
}
