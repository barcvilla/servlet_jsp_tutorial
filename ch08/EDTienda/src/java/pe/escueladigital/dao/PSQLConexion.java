/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.escueladigital.dao;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.escueladigital.utilidades.Utilidades;

public class PSQLConexion {
    
    // Metodo que retorna un objeto Connection, sin modificador de acceso lo cual hace accesible unicamente a clases dentro del mismo paquete
    Connection conectar() {
        Connection conexion = null;
        Properties propiedades = Utilidades.getInstancia().getConfiguracionBaseDeDatos();
        
        String url = "jdbc:postgresql://" +
                        propiedades.getProperty("servidor") +
                        ":" + propiedades.getProperty("puerto") +
                        "/" + propiedades.getProperty("basededatos");
        String user = propiedades.getProperty("usuario");
        String pass = propiedades.getProperty("password");
        
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            
        }catch(ClassNotFoundException ex){}
        return conexion;
    }
    
}

