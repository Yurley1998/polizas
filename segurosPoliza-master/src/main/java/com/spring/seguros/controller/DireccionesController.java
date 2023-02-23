package com.spring.seguros.controller;


import com.spring.seguros.facade.DireccionesFacade;
import com.spring.seguros.facade.DireccionesFacadeImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.message.Message;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class DireccionesController {
    private DireccionesFacade addressFacade = DireccionesFacadeImp.getInstance();

    @PostMapping("/address/insertAddress")
    public ResponseEntity<Message> insertAddress(@RequestBody Direcciones direcciones){
        Message message = new Message("1","Se creo con exito", "");
        try {
            addressFacade.createAddress(direcciones);
            message.setData(direcciones);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage("No se pudo crear con exito");
            e.printStackTrace();
        }
        return ResponseEntity.ok(message);
    }
    @GetMapping("/address/selectAll")
    public ResponseEntity<Message> selectAll(){
        Message message = new Message("1","Consulta exitosa", "");
        ArrayList<Direcciones> listAddress = null;
        try {
            listAddress = addressFacade.selectAll();
            message.setData(listAddress);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
            e.printStackTrace();
        }
        return ResponseEntity.ok(message);
    }

    @PostMapping("/address/delete")
    public ResponseEntity<Message> delete(@RequestBody Direcciones direcciones){
        Message message = new Message("1","Eliminado con exito", "");
        direcciones.setIdDireccion(1);
        try {
            addressFacade.delete(direcciones);
            message.setData(direcciones);
        } catch (Exception e) {
            message.setId("404");
            message.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(message);
    }
}
