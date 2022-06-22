package model.cancion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;

public class cancionDao{
    
    Connection con;         //objeto de conexion
    PreparedStatement ps;   //preparar sentencias
    ResultSet rs;           //almacenar consultas
    String sql=null;
    int r;

     //Registrar

     public int registrar(cancionVo cancion) throws SQLException{
        sql="INSERT INTO Cancion(nombreCancion,fechaGrabacion,duracionCancion,estadoCancion) values (?,?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencias
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registro la Cancion correctamente");
        } catch(Exception e){
            System.out.println("Error en el registro"+e.getMessage().toString());
        } finally{
            con.close(); //cerrar la conexion
        }
        return r;
    }
 //Eliminar

 public void eliminar(int idCancion) throws SQLException{
    sql="DELETE FROM genero WHERE idCancion"+idCancion;
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

 public int actualizar(cancionVo cancion) throws SQLException{
    sql="UPDATE cancion SET nombreCancion=?, fechaGrabacion=?,duracionCancion=?,estadoCancion=? WHERE idCancion=?";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.setInt(1, cancion.getIdCancion());
        ps.setString(2, cancion.getNombreCancion());
        ps.setString(3, cancion.getFechaGrabacion());
        ps.setString(4, cancion.getDuracionCancion());
        ps.setBoolean(5, cancion.getEstadoCancion());
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
public void estado(Boolean estadoCancion, int idCancion) throws SQLException{
    sql="UPDATE cancion SET estadoCancion="+estadoCancion+"WHERE idCancion="+idCancion;
try{
    con=Conexion.conectar();
    ps=con.prepareStatement(sql);
    System.out.println(ps);
    ps.executeUpdate();
    ps.close();
    System.out.println("Se cambio el estado a"+estadoCancion+" correctamente");
} catch (Exception e){
    System.out.println("Error en el cambio de estado"+e.getMessage().toString());
}
finally{
    con.close();
}
}

  //Editar
  public List<cancionVo> listarcancion(int i) throws SQLException{
    List<cancionVo> genero=new   ArrayList<>();
    sql="SELECT * FROM cancion WHERE idCancion="+i;
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
            cancionVo filas=new cancionVo();
            //Escribir en el setter cada valor encontrado

            filas.setIdCancion(rs.getInt("idCancion")); //peticion de id
            filas.setNombreCancion(rs.getString("nombreCancion")); //peticion del nombre
            filas.setFechaGrabacion(rs.getString("fechaGrabacion")); //peticion de estado
            filas.setDuracionCancion(rs.getString("duracionCancion")); //peticion de estado
            filas.setEstadoCancion(rs.getBoolean("estadoGenero")); //peticion de estado
            genero.add(filas);
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
       public List<cancionVo> listar() throws SQLException{
        List<cancionVo> cancionesList=new ArrayList<>();
        sql="SELECT * from Cancion";
        try{
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while (rs.next()) {
                cancionVo filas=new cancionVo();
                //Escribir en el setter cada valor encontrado

                filas.setIdCancion(rs.getInt("idCancion"));
                filas.setNombreCancion(rs.getString("nombreCancion"));
                filas.setFechaGrabacion(rs.getString("fechaGrabacion"));
                filas.setDuracionCancion(rs.getString("duracionCancion"));
                filas.setEstadoCancion(rs.getBoolean("estadoCancion"));
                cancionesList.add(filas);
            }
            ps.close();
            System.out.println("Consulta Exitosa");
        } catch (Exception e){
            System.out.println("La conulta no logro ser ejecutada"+e.getMessage().toString());
        } finally{
            con.close();
        } 
        return cancionesList; //Retorna array con los datos de la tabla
    }
}

