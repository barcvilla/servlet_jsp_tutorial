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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.escueladigital.excepciones.ExcepcionGeneral;
import pe.escueladigital.modelos.Producto;

public class PSQLProducto {
    
    private final String OBTENERPORID = "SELECT id_producto, nombre, descripcion, valor, imagen FROM productos WHERE id_producto = ?";
    private final String OBTENERTODOS = "SELECT id_producto, nombre, descripcion, valor, imagen FROM productos";
    
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultados;
    
    private Producto convertir(ResultSet rs) throws SQLException {
        Producto producto = new Producto();
        producto.setId(rs.getShort("id_producto"));
        producto.setNombre(rs.getString("nombre"));
        producto.setDescripcion(rs.getString("descripcion"));
        producto.setValor(rs.getFloat("valor"));
        producto.setImagen(rs.getString("imagen"));
        return producto;
    }
    
    public Producto obtenerPorId(Short id) throws ExcepcionGeneral {
        Producto producto = null;
        try {
            conexion = new PSQLConexion().conectar();
            sentencia = conexion.prepareStatement(OBTENERPORID);
            sentencia.setShort(1, id);
            resultados = sentencia.executeQuery();
            if (resultados.next()) {
                producto = convertir(resultados);
            }
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral("Error al obtener Producto: "+sqle.getMessage());
        } finally {
            cerrarRecursos();
        }
        return producto;
    }
    
    public List<Producto> obtenerTodos() throws ExcepcionGeneral {
        List<Producto> listado = new ArrayList<>();
        try {
            conexion = new PSQLConexion().conectar();
            sentencia = conexion.prepareStatement(OBTENERTODOS);
            resultados = sentencia.executeQuery();
            while (resultados.next()) {
                Producto producto = convertir(resultados);
                listado.add(producto);
            }
        } catch (SQLException sqle) {
            throw new ExcepcionGeneral("Error al obtener todos los Producto: "+sqle.getMessage());
        } finally {
            cerrarRecursos();
        }
        return listado;
    }
    
    private void cerrarRecursos() {
        try {
            if (resultados != null) {
                resultados.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException sqle) {}
    }
}
