package com.spring.seguros.manager;

import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dao.DireccionesDao;
import com.spring.seguros.dao.DireccionesDaoImp;
import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.exceptions.DaoExceptions;
import com.spring.seguros.exceptions.ManagerExceptions;

import java.util.ArrayList;

public class DireccionesManagerImp implements DireccionesManager {
    private DireccionesDao direccionesDa;
    private static DireccionesManagerImp direccionesManagerImp;

    private DireccionesManagerImp()
    {
        this.direccionesDa = DireccionesDaoImp.getInstance();
    };

    public static DireccionesManager getInstance()
    {
        if (direccionesManagerImp == null)
        {
            direccionesManagerImp = new DireccionesManagerImp();
        }
        return direccionesManagerImp;
    }


    @Override
    public void save(Direcciones direcciones, Conexion connect) throws ManagerExceptions {
        try {
            Direcciones temp = this.direccionesDa.getById(direcciones, connect);
            if(temp==null){
                this.direccionesDa.insert(direcciones,connect);
            }else{
                this.direccionesDa.update(direcciones,connect);
            }
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public void delete(Direcciones addressDto, Conexion connect) throws ManagerExceptions {
        try {
            Direcciones temp = this.direccionesDa.getById(addressDto,connect);
            if(temp!=null) {
                this.direccionesDa.delete(addressDto, connect);
            }
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }

    }

    @Override
    public ArrayList<Direcciones> selectAll(Conexion connect) throws ManagerExceptions {
        try {
            return this.direccionesDa.getAll(connect);
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }
    }

    @Override
    public void update(Direcciones direcciones, Conexion connect) throws ManagerExceptions {
        try {
            Direcciones temp = this.direccionesDa.getById(direcciones,connect);
            if(temp!=null){
                this.direccionesDa.update(direcciones,connect);

            }
        } catch (DaoExceptions dex) {
            throw new ManagerExceptions(dex);
        } catch (Exception ex) {
            throw new ManagerExceptions(ex);
        }
    }


}
