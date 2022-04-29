/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probandoarraylist;

/**
 * Clase con la que se inicia la aplicación, y se llama al constructor de 
 * Instanciador, para poder generar los datos iniciales
 * @author Adrián José
 * @see probandoarraylist.Instanciador
 */
public class Login extends BaseDeDatos2{
    public Login(){
        datos();
        
        boolean finalizar = false;
        String decision,dni,contra,nombre;
        System.out.println(" <-- BIENVENIDO!! --> ");
        
        while(!finalizar){
            System.out.println(" 1. Iniciar sesion \n 2. Registrarse \n 3. Olvidé mi contraseña \n 4. SALIR");
            
            decision = pedirDato();
            switch(decision.toLowerCase().replace(" ", "")){
                case "4": case "salir":
                    System.out.println(" <-- ADIOS! --> ");
                    finalizar = true;
                    break;
                case "3":
                    System.out.println(" <-- Dime tu dni --> ");
                    dni = pedirDato();
                    System.out.println(" <-- Dime tu nombre --> ");
                    nombre = pedirDato();
                    System.out.println(olvideContra(dni, nombre));
                    break;
                case "2":
                    System.out.println(" <-- Dime tu dni --> ");
                    dni = pedirDato();
                    System.out.println(" <-- Dime tu nombre --> ");
                    nombre = pedirDato();
                    registrarse(nombre, dni);
                    break;
                case "1":
                    System.out.println(" <-- Dime tu dni --> ");
                    dni = pedirDato();
                    System.out.println(" <-- Dime tu contraseña --> ");
                    contra = pedirDato();
                    iniciarSesion(dni, contra);
                    break;
                default:
                    System.err.println(" <-- Opción invalida --> ");
                    break;
            }
            
        }
        
    }

    private void datos() {
        Instanciador ins = new Instanciador();
    }
    
    private String olvideContra(String dni, String nombre){
        Persona p = super.buscar(dni);
    
        try{
        
            if(p.getNombre().equalsIgnoreCase(nombre)){
                return " <-- Tu contraseña es: " + p.obtenerClave() + " --> ";
            }   else {
                return " <-- Los datos no coinciden con el dni introducido --> ";
            }
        
        }catch(NullPointerException noEncontrado){
            return " <-- Dni no registrado --> ";
        }
        
    }
    
    private void iniciarSesion(String dni, String contra){
        Persona p = super.buscar(dni);
        
        try{
        
            if(p.obtenerClave().equals(contra)){
                System.out.println(" <-- Has iniciado sesion --> ");
            }   else{
                System.err.println(" <-- Datos invalidos --> ");
            }
        
        }catch(NullPointerException noEncontrado){
            System.err.println(" <-- Datos invalidos --> ");
        }
        
    }
    
    private void registrarse(String nombre, String dni){
        
        if(agregarPersonas(new Cliente(nombre,dni))){

            Persona creada = super.buscar(dni);
            creada.asignarClave(creada.getDni(), creada.crearClave());
            System.out.println(" <-- Registrado correctamente --> ");
        }   else{
            System.err.println(" <-- Ya existe en la base de datos --> ");
        }
        
    }
}
