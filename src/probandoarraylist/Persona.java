/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoarraylist;
import java.util.*;

/**
 *
 * @author Adrián José
 */
public abstract class Persona implements Comparable<Persona> {

    private String nombre;
    private String dni;
    
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    @Override
    public abstract int compareTo(Persona arg0);

    @Override
    public String toString() {
        return "nombre:" + nombre + ", dni:" + dni + "\n";
    }

}
