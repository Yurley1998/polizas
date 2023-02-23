package com.spring.seguros.dao;

import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.exceptions.DaoExceptions;
import java.util.ArrayList;

public interface DireccionesDao {
    public void insert(Direcciones direcciones, Conexion connect) throws DaoExceptions;
    public void delete(Direcciones direcciones,Conexion connect) throws DaoExceptions;
    public Direcciones getById(Direcciones direcciones, Conexion connect) throws DaoExceptions;
    public ArrayList<Direcciones> getAll(Conexion connect) throws DaoExceptions;
    public void update(Direcciones direcciones,Conexion connect) throws DaoExceptions;
}
