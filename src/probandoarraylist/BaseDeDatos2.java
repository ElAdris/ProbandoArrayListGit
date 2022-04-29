/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoarraylist;

import java.util.*;

/**
 * RECORDATORIO -- TODOS LOS METODOS ESTAN HECHOS PARA PERSONAS NO PARA DOCUMENTOS.
 * Todas las instancias están hechas en Instanciador
 * @author Adrián José
 * @see probandoarraylist.Instanciador
 */
public class BaseDeDatos2 {
    private static HashMap<String,Persona> personas = new HashMap<>();
    
    public BaseDeDatos2(){
    }
    
    public void agregarPersonas(){
        System.out.println(" <-- Elige que cargo de la base de datos ?? --> ");
        Persona p = bddPersona();
        System.out.println(" <-- INTRODUCE LOS DATOS QUE SE SOLICITAN --> ");
        
        System.out.println(" <-- DNI --> ");
        String dni = pedirDato();
        
        System.out.println(" <-- NOMBRE --> ");
        String nombre = pedirDato();
        
        p.setDni(dni);
        p.setNombre(nombre);
        
            personas.put(dni, p);
        
        System.out.println(" <-- ¿ AGREGADO ? --> " + '\n' + personas.containsKey(dni));
        System.out.println("\n" + personas.get(dni).toString());
    }
    
    public boolean agregarPersonas(Persona p){
        Persona comprobante = personas.putIfAbsent(p.getDni(), p);

        return comprobante == null;
    }
    
    public void eliminar(){
        System.out.println(" <-- Qué quieres eliminar --> ");
        
        filtrarInformacion(bddPersona());
        
        System.out.println(" <-- Indica el DNI de quien quieres eliminar --> ");
        String dniAeliminar = pedirDato();
        
        String decision = "";
        
        if(!personas.containsKey(dniAeliminar)){
            System.err.println(" <-- No existe --> ");
        }
        else{
            
            System.out.println("<-- ¿Seguro de querer eliminar? --> \n" 
                    + personas.get(dniAeliminar) + "si o no");
            
            boolean correcto = false;
            while(!correcto)
            {
                decision = pedirDato();
            
                switch(decision.toLowerCase().replace(" ", "")){
                    case "si":case"s":
                        personas.remove(dniAeliminar);
                        System.out.println(" <-- Eliminado --> ");
                        correcto = true;
                        break;
                    case "no":case"n":
                        System.out.println(" <-- No eliminado --> ");
                        correcto = true;
                        break;
                    default:
                        System.out.println(" <-- Opcion no valida --> ");
                        break;
                }
            }
        }
    }
    
    public Persona bddPersona(){
        String decision = "";
        boolean correcto = false;
        Persona p = null;
        
        while(!correcto){
            System.out.println("1 --> Bibliotecario \n2 --> Cliente");
            decision = pedirDato();
            
            switch(decision.toLowerCase().replace(" ", "")){
                case "1": case "bibliotecario":
                    p = new Bibliotecario();
                    correcto = true;
                    break;
                case "2": case "cliente":
                    p = new Cliente();
                    correcto = true;
                    break;
                default:
                    System.err.println(" <-- OPCION INVALIDA --> ");
                    break;
            }
            
        }
        
        return p;
    }
    
    public void filtrarInformacion(Object filtrado){
        String clase = filtrado.getClass().getName();
        clase = clase.substring(clase.indexOf(".") + 1);
        
        System.out.println(" <-- Filtrado por : " + clase + "s -->");
        
        Object[] dnis = personas.keySet().toArray();
        
        for(int i = 0 ; i < dnis.length ; i++){

            if(filtrado.getClass().equals(personas.get(dnis[i]).getClass())){
                System.out.println(personas.get(dnis[i]));
            }

        }
    }
    
    public void mostrarInformacion(){
        String decision = "";
        
        boolean correcto = false;
        
        while(!correcto){
            System.out.println(" <-- Quieres ver la informacion filtrada?? "
                    + "--> si o no");
            decision = pedirDato();
            
            switch(decision.toLowerCase().replace(" ", "")){
                case "s": case "si":
                    System.out.println(" <-- Como la quieres filtrar?? --> ");
                    filtrarInformacion(bddPersona());
                    
                    correcto = true;
                    break;
                case "n": case "no":
                    System.out.println(personas.values().toString());
                    
                    correcto = true;
                    break;
                default:
                    System.err.println(" <-- Opcion invalida --> ");
                    break;
            }
        }
    }
    
    public <T> T buscar(String identificador){
        return (T) personas.getOrDefault(identificador, null);
    }
    
    public Object bddDocumento(){
        String decision = "";
        System.out.println("-- Que deseas?? --");
        
        return null;
    }
    
    public String pedirDato(){
        Scanner scann = new Scanner(System.in);
        return scann.nextLine();
    }
}
