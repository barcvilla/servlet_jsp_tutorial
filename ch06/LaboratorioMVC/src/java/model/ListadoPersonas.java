/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge
 */
public class ListadoPersonas {
    List<Persona> lista = new ArrayList<Persona>();

    public void setPersona(Persona p){
        this.lista.add(p);
    }

    public List<Persona> getLista() {
        return lista;
    }

    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }



}
