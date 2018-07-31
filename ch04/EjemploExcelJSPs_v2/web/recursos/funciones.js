/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var capa;
console.log("hola");
function cambio(idCapa)
{
    // recuperamos la capa segun el elemento disponible
    if(document.layers)
    {
        capa = eval("document." + idCapa); //obtenemos el elemento div del documento html
    }
    if(document.all)
    {
        capa = eval(idCapa + ".style");
    }
    if(document.getElementById)
    {
        capa = eval('document.getElementById("' + idCapa +'").style'); //obtenemos el estilo del div
    }
    
    //si esta visible la capa la ocultamos si no es asi la mostramos
    if(capa.visibility == "hidden" || (capa.visibility == "hide"))
    {
        capa.visibility = (document.layers) ? "show" : "visible";
    }
    else
    {
        capa.visibility = (document.layers) ? "hide" : "hidden";
    }
}

