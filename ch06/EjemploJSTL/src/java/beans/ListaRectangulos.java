/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ListaRectangulos {
    //almacenmos loa objetos de tipo rectangulo
    List<Rectangulo> lista = new ArrayList<>();
    
    /**
     * este metodo nos permite simular una propiedad llamada "rectangulo" desde la accion jsp:setProperty en un JSPA
     */
    public void setRectangulo(Rectangulo r)
    {
        this.lista.add(r);
    }
    
    public List<Rectangulo> getLista()
    {
        return this.lista;
    }
    
    public void setLista(List<Rectangulo> lista)
    {
        this.lista = lista;
    }
}
