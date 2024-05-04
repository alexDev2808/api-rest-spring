package com.jath.apirestspring.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Integer idCliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private Date fechaRegistro;
}
