package com.jath.apirestspring.controller;

import com.jath.apirestspring.model.dto.ClienteDto;
import com.jath.apirestspring.model.entity.Cliente;
import com.jath.apirestspring.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto create(@RequestBody ClienteDto clienteDto) {

        Cliente clienteSave = clienteService.save(clienteDto);
        return ClienteDto.builder()
                .idCliente(clienteSave.getIdCliente())
                .nombre(clienteSave.getNombre())
                .apellidos(clienteSave.getApellidos())
                .correo(clienteSave.getCorreo())
                .fechaRegistro(clienteSave.getFechaRegistro())
                .build();


    }

    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto update(@RequestBody ClienteDto clienteDto) {
        Cliente clienteUpdate = clienteService.save(clienteDto);
        return ClienteDto.builder()
                .idCliente(clienteUpdate.getIdCliente())
                .nombre(clienteUpdate.getNombre())
                .apellidos(clienteUpdate.getApellidos())
                .correo(clienteUpdate.getCorreo())
                .fechaRegistro(clienteUpdate.getFechaRegistro())
                .build();

    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        Map<String, Object> response = new HashMap<>();

        try {
            Cliente clienteDelete = clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            response.put("mensaje", e.getMessage());
            response.put("cliente", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDto showById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ClienteDto.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellidos(cliente.getApellidos())
                .correo(cliente.getCorreo())
                .fechaRegistro(cliente.getFechaRegistro())
                .build();
    }

}
