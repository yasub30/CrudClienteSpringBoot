package com.huaman.pc02.controllers;

import com.huaman.pc02.model.entities.Cliente;
import com.huaman.pc02.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @RequestMapping(value = {"/listar", ""}, method = RequestMethod.GET)
    public String listar(Model model){
        List<Cliente> cliente = clienteService.listar();
        if (cliente.size() <= 0) {
            Object info = "Cree un nuevo cliente!";
            model.addAttribute("infoText", info );
        } else {
            model.addAttribute("clientes", cliente);
        }

        model.addAttribute("titulo","Mantenimiento de Clientes");
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model){

        Cliente cliente = new Cliente();
        Object text = "Crear";
        model.put("cliente", cliente);
        model.put("textbtn", text);
        return "form";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model){

        Cliente cliente = null;
        Object text = "Actualizar";

        if (id>0){ cliente = clienteService.buscar(id);}
        else{return "redirect:/listar";}

        model.put("cliente", cliente);
        model.put("textbtn", text);
        return "form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status){
        if (result.hasErrors()) {
            return "redirect:/form";
        }else {
            clienteService.grabar(cliente);
            status.setComplete();
            return "redirect:/listar";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id){
        if (id > 0){ clienteService.eliminar(id);}
        return "redirect:/listar";
    }
}










