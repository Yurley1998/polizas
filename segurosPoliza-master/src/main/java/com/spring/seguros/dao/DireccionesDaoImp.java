package com.spring.seguros.dao;

import com.spring.seguros.bd.Conexion;
import com.spring.seguros.dto.Direcciones;
import com.spring.seguros.dto.Personas;
import com.spring.seguros.exceptions.DaoExceptions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DireccionesDaoImp implements DireccionesDao{
    private static DireccionesDaoImp direcciones;
    private DireccionesDaoImp()
    {
    }
    public static DireccionesDaoImp getInstance()
    {
        if (direcciones == null)
        {
            direcciones = new DireccionesDaoImp();
        }
        return direcciones;
    }

    @Override
    public void insert(Direcciones direcciones, Conexion connect) throws DaoExceptions {
        String INSERT = "INSERT INTO direcciones(id_personas," +
                "direccion, " +
                "ciudad, " +
                "departamento, " +
                "pais)" +
                " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connect.getConnection().prepareStatement(INSERT);
            statement.setInt(1,direcciones.getPersonas().getIdPersona());
            statement.setString(2,direcciones.getDireccion());
            statement.setString(3,direcciones.getCiudad());
            statement.setString(4,direcciones.getDepartamento());
            statement.setString(5,direcciones.getPais());

            statement.executeUpdate();
        }catch (SQLException se){
            throw new DaoExceptions(se);
        } catch (Exception ex) {
            throw new DaoExceptions(ex);
        }finally {
            if(statement!=null){
                try{
                    statement.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        }
        System.out.println("Insertado");

    }

    @Override
    public void delete(Direcciones direcciones, Conexion connect) throws DaoExceptions {
        String SQL = "DELETE FROM direcciones WHERE id_direccion = ?";
        PreparedStatement statement = null;
        try {
            statement = connect.getConnection().prepareStatement(SQL);
            statement.setInt(1,direcciones.getIdDireccion());
            statement.executeUpdate();
        }catch (SQLException se){
            throw new DaoExceptions(se);
        } catch (Exception ex) {
            throw new DaoExceptions(ex);
        }finally {
            if(statement!=null){
                try{
                    statement.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }

    }

    @Override
    public Direcciones getById(Direcciones direcciones, Conexion connect) throws DaoExceptions {
        String SQL = "SELECT id_direccion, " +
                "id_personas, " +
                "direccion, " +
                "ciudad, " +
                "departamento, " +
                "pais" +
                " FROM direcciones " +
                " WHERE id_direccion = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        Direcciones result = null;
        try {
            statement = connect.getConnection().prepareStatement(SQL);
            statement.setInt(1,direcciones.getIdDireccion());
            rs = statement.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    result = new Direcciones();
                    result.setDireccion(rs.getString("direccion"));
                }
            }
            return result;
        } catch (Exception ex) {
            throw new DaoExceptions(ex);
        }finally {
            try{
                if(rs!=null){
                    rs.close();
                    statement.close();
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Direcciones> getAll(Conexion connect) throws DaoExceptions {
        String SQL = "SELECT A.departamento,\n" +
                "\t\tA.ciudad,\n" +
                "\t\tA.direccion,\n" +
                "\t\tA.id_direccion,\n" +
                "\t\tA.pais,\n" +
                "\t\tA.id_personas,\n" +
                "\t\tB.nombre1,\n" +
                "\t\tB.nombre2,\n" +
                "\t\tB.apellido1,\n" +
                "\t\tB.apellido2\n" +
                "FROM  direcciones  A\n" +
                "INNER JOIN\n" +
                "personas B ON A.id_personas = B.id_persona";
        PreparedStatement statement = null;
        ResultSet rs = null;

        ArrayList<Direcciones> listaPersonas = new ArrayList<>();
        try {
            statement = connect.getConnection().prepareStatement(SQL);

            rs = statement.executeQuery();
            if(rs!=null){
                while (rs.next()){
                    Direcciones   result = new Direcciones();
                    Personas personDto = new Personas();
                    personDto.setIdPersona(rs.getInt("id_personas"));
                    personDto.setNombre1(rs.getString("nombre1"));
                    personDto.setNombre2(rs.getString("nombre2"));
                    result.setIdDireccion(rs.getInt("id_direccion"));
                    result.setDireccion(rs.getString("direccion"));
                    result.setCiudad(rs.getString("ciudad"));
                    result.setDepartamento(rs.getString("departamento"));
                    result.setPais(rs.getString("pais"));

                    result.setPersonas(personDto);
                    listaPersonas.add(result);
                }
            }
            return listaPersonas;
        } catch (Exception ex) {
            throw new DaoExceptions(ex);
        }finally {
            try{
                rs.close();
                statement.close();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Direcciones direcciones, Conexion connect) throws DaoExceptions {
        String UPDATE = "UPDATE direcciones" +
                " SET id_personas=?," +
                "direccion=?, " +
                "ciudad=?, " +
                "departamento=?, " +
                "pais=?" +
                " WHERE id_direccion = ? ";
        PreparedStatement statement = null;
        try {
            statement = connect.getConnection().prepareStatement(UPDATE);
            statement.setInt(1,direcciones.getPersonas().getIdPersona());
            statement.setString(2,direcciones.getDireccion());
            statement.setString(3,direcciones.getCiudad());
            statement.setString(4,direcciones.getDepartamento());
            statement.setString(5,direcciones.getPais());

            statement.setInt(6,direcciones.getIdDireccion());
            statement.executeUpdate();
        }catch (SQLException se){
            throw new DaoExceptions(se);
        } catch (Exception ex) {
            throw new DaoExceptions(ex);
        }finally {
            if(statement!=null){
                try{
                    statement.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }


}
