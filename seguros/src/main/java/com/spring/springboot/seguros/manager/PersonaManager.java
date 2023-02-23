package com.spring.springboot.seguros.manager;
import com.spring.springboot.seguros.bd.Conexion;
import com.spring.springboot.seguros.dto.Personas;
import com.spring.springboot.seguros.exceptions.ManagerExceptions;

import java.util.ArrayList;

public interface PersonaManager {
        public void save(Personas personas, Conexion connect) throws ManagerExceptions;
        public void delete(Personas personas,Conexion connect) throws ManagerExceptions;
        public ArrayList<Personas> selectAll( Conexion connect) throws ManagerExceptions;
        public void update(Personas personas, Conexion connect) throws ManagerExceptions;
    }

