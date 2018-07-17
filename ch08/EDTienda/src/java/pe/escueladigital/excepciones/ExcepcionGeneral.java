/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.escueladigital.excepciones;

/**
 *
 * @author PC
 */
public class ExcepcionGeneral extends RuntimeException {
    
    public ExcepcionGeneral() {
        this("Excepcion General no especificada");
    }
    
    public ExcepcionGeneral(String msg) {
        super(msg);
    }
}
