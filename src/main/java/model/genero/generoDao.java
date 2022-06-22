package model.genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class generoDao {
    
    Connection con;         //objeto de conexion
    PreparedStatement ps;   //preparar sentencias
    ResultSet rs;           //almacenar consultas
    String sql=null;
    int r;

    //Registrar

    public int registrar(generoVo genero) throws SQLException{
        sql="INSERT INTO genero(nombreGenero,estadoGenero) values (?,?)";
        try{
            con=Conexion.conectar(); //abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencias
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); //ejecutar sentencia¿|{}
            ps.close(); //cerrar sentencia
            System.out.println("Se registro el genero correctamente");
        } catch(Exception e){
            System.out.println("Error en el registro"+e.getMessage().toString());
        } finally{
            con.close(); //cerrar la conexion
        }
        return r;
    }

    //Eliminar

    public void eliminar(int idGenero) throws SQLException{
        sql="DELETE FROM genero WHERE idGenero"+idGenero;
        try{
            con=Conexion.conectar(); //abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencias
            System.out.println(ps);
            ps.executeUpdate(); //ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino correctamente");
        } catch (Exception e){
            System.out.println("Error en la eliminacion"+e.getMessage().toString());
        } 
        finally{
            con.close(); //cerrar la conexion
        }
    }

    //Actualizar

    public int actualizar(generoVo genero) throws SQLException{
        sql="UPDATE genero SET nombreGenero=?, estadoGenero=? WHERE idGenero=?";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, genero.getNombreGenero());
            ps.setBoolean(2, genero.getEstadoGenero());
            ps.setInt(3, genero.getIdGenero());
            System.out.println("Se edito el genero correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar"+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    //Estado
    public void estado(Boolean estadoGenero, int idGenero) throws SQLException{
        sql="UPDATE genero SET estadoGenero="+estadoGenero+"WHERE idGenero="+idGenero;
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se cambio el estado a"+estadoGenero+" correctamente");
    } catch (Exception e){
        System.out.println("Error en el cambio de estado"+e.getMessage().toString());
    }
    finally{
        con.close();
    }
    }

    //listar
    public List<generoVo> listarg(int i) throws SQLException{
        List<generoVo> genero=new ArrayList<>();
        sql="SELECT * FROM genero WHERE idGenero="+i;
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                generoVo g=new generoVo();
                //Escribir en el setter cada valor encontrado

                g.setIdGenero(rs.getInt("idGenero")); //peticion de id
                g.setNombreGenero(rs.getString("nombreGenero")); //peticion del nombre
                g.setEstadoGenero(rs.getBoolean("estadoGenero")); //peticion de estado
                genero.add(g);
            }
            ps.close();
            System.out.println("Consulta exitosa a genero especifico");
            } catch (Exception e) {
            System.out.println("La consulta no logro ser ejecutada"+e.getMessage().toString());
            }
            finally{
                con.close();
            }
            return genero;
        }

    //Listar
    public List<generoVo> listargenero() throws SQLException{
        List<generoVo> generosList=new ArrayList<>();
        sql="SELECT * from genero";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                generoVo g=new generoVo();
                //Escribir en el setter cada valor encontrado

                g.setIdGenero(rs.getInt("idGenero"));
                g.setNombreGenero(rs.getString("nombreGenero"));
                g.setEstadoGenero(rs.getBoolean("estadoGenero"));
                generosList.add(g);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e){
            System.out.println("La conulta no logro ser ejecutada"+e.getMessage().toString());
        } finally{
            con.close();
        } 
        return generosList; //Retorna array con los datos de la tabla
    }
}