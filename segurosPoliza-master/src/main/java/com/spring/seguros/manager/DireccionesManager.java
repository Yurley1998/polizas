package com.spring.seguros.manager;
import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.bd.Conexion;
import com.spring.seguros.exceptions.ManagerExceptions;
import java.util.ArrayList;

public interface DireccionesManager {
    public void save(Direcciones direcciones, Conexion connect) throws ManagerExceptions;
    public void delete(Direcciones addressDto,Conexion connect) throws ManagerExceptions;
    public ArrayList<Direcciones> selectAll(Conexion connect) throws ManagerExceptions;
    public void update(Direcciones direcciones, Conexion connect) throws ManagerExceptions;
}
