package com.spring.springboot.seguros.controller;
import com.spring.springboot.seguros.dto.Personas;
import com.spring.springboot.seguros.facade.PersonaFacade;
import com.spring.springboot.seguros.facade.PersonFacadeImp;
import com.spring.seguros.message.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/api")
public class PersonaController {

    private PersonaFacade personFacade = PersonFacadeImp.getInstance();

    @PostMapping("/person/insertPerson")
    public ResponseEntity<Message> insertPerson(@RequestBody Personas personas){
        Message message = new Message("1","Se creo con exito", "");
        try {
            personFacade.createPerson(personas);
            message.setData(personas);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage("No se pudo crear con exito");
        }
        return ResponseEntity.ok(message);
    }
    @GetMapping("/person/selectAll")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Consulta exitosa", "");
        ArrayList<Personas> listaPerson = null;
        try {
            listaPerson = personFacade.selectAll();
            message.setData(listaPerson);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/person/delete")
    public ResponseEntity<Message> delete(@RequestBody Personas personas){
        Message message = new Message("1","Eliminado con exito", "");
        personas.setIdPersona(6);
        try {
            personFacade.delete(personas);
            message.setData(personas);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/person/update")
    public ResponseEntity<Message> update(@RequestBody Personas personas){
        Message message = new Message("1","Actualizado con exito", "");

        try {
            personFacade.update(personas);
            message.setData(personas);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(message);
    }
}

