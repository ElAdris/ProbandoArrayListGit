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
public abstract class Claves {
    static HashMap<String, String> contras = new HashMap<>();
    
    public void asignarClave(String dni, String clave){
        contras.put(dni, clave);
    }
}
