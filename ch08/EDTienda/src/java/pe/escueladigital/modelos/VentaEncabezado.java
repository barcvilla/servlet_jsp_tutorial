/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.escueladigital.modelos;

/**
 * Clase que Mapea la tabla VentaEncabezado
 * @author PC
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentaEncabezado {
    private int id;
    private LocalDate fecha;
    private String nombre;
    private String direccion;
    private List<VentaDetalle> detalle = new ArrayList<>();

    public VentaEncabezado() {
    }

    public VentaEncabezado(int id, LocalDate fecha, String nombre, String direccion) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion.toUpperCase();
    }
    
    public void addDetalle(VentaDetalle item) {
        detalle.add(item);
    }
    
    public List<VentaDetalle> getDetalle() {
        return detalle;
    }
    
}
