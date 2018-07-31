/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Conversiones {
    private static final String FORMATO_FECHA = "dd-MM-yyyy";
    
    /**
     * Convertimos una fecha en una cadena con el formato especifico
     * @param fecha
     * @return 
     */
    public static String format(Date fecha)
    {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
    //sobrecargamos el metodo format
    public static String format(String fecha)
    {
        SimpleDateFormat formateador = new SimpleDateFormat(FORMATO_FECHA);
        return formateador.format(fecha);
    }
    
}
