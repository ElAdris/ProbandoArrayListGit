/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoarraylist;

import java.util.Objects;

/**
 *
 * @author Adrián José
 */
public abstract class Persona extends Claves implements Comparable<Persona> {

    private String nombre;
    private String dni;
    
    /**
     * En el constructor se genera la clave de la persona, en base a su nombre
     * y hashCode de su nombre.
     * @param nombre
     * @param dni 
     * @see asignarClave(String dni, String clave)
     */
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
    
    public String obtenerClave(){
        return contras.get(this.dni);
    }
    
    public void cambiarClave(String claveNueva){
        super.asignarClave(this.dni, claveNueva);
    }
    
    public String crearClave(){
        return this.nombre + this.nombre.hashCode();
    }
    
    @Override
    public abstract int compareTo(Persona arg0);

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nombre:" + nombre + ", dni:" + dni + "\n";
    }

}
