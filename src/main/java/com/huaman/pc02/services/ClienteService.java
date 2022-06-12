package com.huaman.pc02.services;

import com.huaman.pc02.model.entities.Cliente;

import java.util.List;

public interface ClienteService {

    void grabar(Cliente cliente);
    void eliminar(int id);
    Cliente buscar(int id);
    List<Cliente> listar();
}
