package com.spring.springboot.seguros.facade;

import com.spring.springboot.seguros.bd.Conexion;
import com.spring.springboot.seguros.bd.MgConexion;
import com.spring.springboot.seguros.dto.Personas;
import com.spring.springboot.seguros.exceptions.FacadeExceptions;
import com.spring.springboot.seguros.exceptions.ManagerExceptions;
import com.spring.springboot.seguros.manager.PersonaManager;
import com.spring.springboot.seguros.manager.PersonaManagerImp;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;


public class PersonFacadeImp implements PersonaFacade{
    private static PersonFacadeImp personFacade;
    private PersonaManager personManager;
    private PersonFacadeImp() {
        this.personManager = PersonaManagerImp.getInstance();
    }

    public static PersonFacadeImp getInstance()
    {
        if (personFacade == null)
        {
            personFacade = new PersonFacadeImp();
        }
        return personFacade;
    }

    @Override
    public void createPerson(Personas personas) throws FacadeExceptions {
        Conexion connect = null;
        MgConexion managerConnect = null;
        try {
            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre

            this.personManager.save(personas,connect);
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
    public void delete(Personas personas) throws FacadeExceptions {
        Conexion connect= null;
        MgConexion managerConnect =null;
        try {
            managerConnect = managerConnect.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");
            this.personManager.delete( personas, connect);
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
    public ArrayList<Personas> selectAll() throws FacadeExceptions {
        Conexion connect = null;
        MgConexion managerConnect = null;
        try {
            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");

            return this.personManager.selectAll(connect);

        } catch (ManagerExceptions mex) {
            throw new FacadeExceptions(mex);
        } catch (Exception ex) {
            throw new FacadeExceptions(ex);
        }finally {
            managerConnect.close(connect);
        }
    }

    @Override
    public void update(Personas personas) throws FacadeExceptions {
        Conexion connect = null;
        MgConexion managerConnect =null;
        try {

            managerConnect = MgConexion.getInstance();
            connect = managerConnect.getConexion(); //Aqui pido una conexion libre  System.out.println("Facade");

            this.personManager.update(personas,connect);
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
