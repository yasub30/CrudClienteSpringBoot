package com.huaman.pc02.services;

import com.huaman.pc02.model.daos.ClienteDao;
import com.huaman.pc02.model.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteDao dao;

    @Override
    @Transactional
    public void grabar(Cliente cliente) {
        dao.save(cliente);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente buscar(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {
        return (List<Cliente>) dao.findAll();
    }
}
