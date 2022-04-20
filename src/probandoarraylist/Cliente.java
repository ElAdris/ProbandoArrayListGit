/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoarraylist;

/**
 *
 * @author Adrián José
 */
public class Cliente extends Persona{

    public Cliente(String nombre, String dni) {
        super(nombre, dni);
    }

    public Cliente(String nombre) {
        super(nombre);
    }

    public Cliente() {
    }

    @Override
    public int compareTo(Persona arg0) {
        return Integer.parseInt(this.getDni().substring(0,this.getDni().length()-1))
                - Integer.parseInt(arg0.getDni().substring(0, arg0.getDni().length()-1));
    }
    
}
