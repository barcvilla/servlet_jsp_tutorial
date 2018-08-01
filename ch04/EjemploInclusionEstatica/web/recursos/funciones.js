/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Mostramos u Ocultamos los elementos Span
function desplegar(categoria)
{
    var menu = document.getElementById(categoria); //esto nos devuelve el elemento span
    if(menu.className == "ver_menu")
    {
        menu.className = "ocultar_menu";
    }
    else
    {
        menu.className = "ver_menu";
    }
}

