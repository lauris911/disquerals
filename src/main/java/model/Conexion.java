package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    //Declarar los atributos para la conexion
    private static final String bbdd="jdbc:mysql://localhost:3306/bd_disquera";
    private static final String usuario="root";
    private static final String clave="";
    private static Connection con;

    //Declar el metodo conexion
    public static Connection conectar(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(bbdd,usuario,clave);
            System.out.println("Conexion Exitosa");
        } catch(Exception e){
            System.out.println("Error de conexion a la base de datos"+e.getMessage().toString());
        }
        return con;
    }
    public static void main(String[] args) {
        Conexion.conectar();
    }
}

