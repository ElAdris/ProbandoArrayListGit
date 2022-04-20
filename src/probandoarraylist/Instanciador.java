/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoarraylist;

import static probandoarraylist.BaseDeDatos2.agregarPersonas;
/**
 * Clase que contiene las estancias para la base de datos
 * @author Adrián José
 */
public class Instanciador{
    
    /**
     * Para poder asignar la instancia a la base de datos
     * hay que llamar al método agregarPersonas, de la clase base de datos
     */
    public Instanciador(){
        /*--BIBLIOTECARIOS--*/
        Bibliotecario b1 = new Bibliotecario("b1", "d1");
        Bibliotecario b2 = new Bibliotecario("b2", "d2");
        Bibliotecario b3 = new Bibliotecario("b3", "d3");
        
        /*--CREAR CLAVES--*/
        b1.asignarClave(b1.getDni(), b1.crearClave());
        b2.asignarClave(b2.getDni(), b2.crearClave());
        b3.asignarClave(b3.getDni(), b3.crearClave());
        
        /*--AÑADIDOS--*/
        agregarPersonas(b1);
        agregarPersonas(b2);
        agregarPersonas(b3);
        
        /*--CLIENTES--*/
        Cliente c1 = new Cliente("c1", "d4");
        Cliente c2 = new Cliente("c2", "d5");
        Cliente c3 = new Cliente("c3", "d6");      

        /*--CREAR CLAVES--*/
        c1.asignarClave(c1.getDni(), c1.crearClave());
        c2.asignarClave(c2.getDni(), c2.crearClave());
        c3.asignarClave(c3.getDni(), c3.crearClave());
        
        /*--AÑADIDOS--*/
        agregarPersonas(c1);
        agregarPersonas(c2);
        agregarPersonas(c3);
        
        
    }
}