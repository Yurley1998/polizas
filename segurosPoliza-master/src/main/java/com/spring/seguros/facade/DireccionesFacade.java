package com.spring.seguros.facade;

import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.exceptions.FacadeExceptions;
import java.util.ArrayList;

public interface DireccionesFacade {
    public void createAddress(Direcciones direcciones) throws FacadeExceptions;
    public void delete(Direcciones direcciones) throws FacadeExceptions;
    public ArrayList<Direcciones> selectAll() throws FacadeExceptions;
    public void update(Direcciones direcciones) throws FacadeExceptions;
}
