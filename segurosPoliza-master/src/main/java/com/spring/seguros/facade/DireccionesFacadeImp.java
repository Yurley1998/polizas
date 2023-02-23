package com.spring.seguros.facade;

import com.spring.seguros.bd.Conexion;
import com.spring.seguros.bd.MgConexion;
import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.exceptions.FacadeExceptions;
import com.spring.seguros.exceptions.ManagerExceptions;
import com.spring.seguros.manager.DireccionesManager;
import com.spring.seguros.manager.DireccionesManagerImp;

import java.sql.SQLException;
import java.util.ArrayList;


public class DireccionesFacadeImp implements DireccionesFacade{
    private static DireccionesFacadeImp direccionesFacade;
    private DireccionesManager direccionesManager;

    private DireccionesFacadeImp() {

        this.direccionesManager = DireccionesManagerImp.getInstance();
    }
    public static DireccionesFacadeImp getInstance()
    {
        if (direccionesFacade == null)
        {
            direccionesFacade = new DireccionesFacadeImp();
        }
        return direccionesFacade;
    }

    @Override
    public void createAddress(Direcciones direcciones) throws FacadeExceptions {
        Conexion connect = null;
        MgConexion managerConnect = null;
        try {
            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre

            this.direccionesManager.save(direcciones,connect);
            connect.getConnection().commit();  //Si es exitoso
        } catch (ManagerExceptions mex) {
            try {
                connect.getConnection().rollback(); //Si falla devuelve todo
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new FacadeExceptions(mex);
        } catch (Exception ex) {
            try {
                connect.getConnection().rollback(); //Si falla devuelve todo
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new FacadeExceptions(ex);
        }finally {
            managerConnect.close(connect);
        }

    }

    @Override
    public void delete(Direcciones direcciones) throws FacadeExceptions {
        Conexion connect= null;
        MgConexion managerConnect =null;
        try {
            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");
            this.direccionesManager.delete(direcciones, connect);
            connect.getConnection().commit();  //Si es exitoso
        } catch (ManagerExceptions mex) {
            try {
                connect.getConnection().rollback(); //Si falla devuelve todo
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new FacadeExceptions(mex);
        } catch (Exception ex) {
            try {
                connect.getConnection().rollback(); //Si falla devuelve todo
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new FacadeExceptions(ex);
        }finally {
            managerConnect.close(connect);
        }

    }

    @Override
    public ArrayList<Direcciones> selectAll() throws FacadeExceptions {
        Conexion connect = null;
        MgConexion managerConnect = null;
        try {
            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");

            return this.direccionesManager.selectAll(connect);

        } catch (ManagerExceptions mex) {
            throw new FacadeExceptions(mex);
        } catch (Exception ex) {
            throw new FacadeExceptions(ex);
        }finally {
            managerConnect.close(connect);
        }
    }

    @Override
    public void update(Direcciones direcciones) throws FacadeExceptions {
        Conexion connect = null;
        MgConexion managerConnect =null;
        try {
            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");
            this.direccionesManager.update(direcciones,connect);
            connect.getConnection().commit();  //Si es exitoso
        } catch (ManagerExceptions mex) {
            try {
                connect.getConnection().rollback(); //Si falla devuelve todo
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new FacadeExceptions(mex);
        } catch (Exception ex) {
            try {
                connect.getConnection().rollback(); //Si falla devuelve todo
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            throw new FacadeExceptions(ex);
        }finally {
            managerConnect.close(connect);
        }
    }


}
