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
public class BaseDeDatos {

    ArrayList<Director> directores;
    ArrayList<Bibliotecario> bibliotecarios;

    public BaseDeDatos(ArrayList<Director> directores, ArrayList<Bibliotecario> bibliotecarios) {
        ArrayList<Director> copiaD = new ArrayList();
        copiaD.addAll(directores);
        copiaD.sort(null);
        this.directores = copiaD;

        ArrayList<Bibliotecario> copiaB = new ArrayList();
        copiaB.addAll(bibliotecarios);
        copiaB.sort(null);
        this.bibliotecarios = copiaB;
    }

    public ArrayList<Director> getDirectores() {
        ArrayList<Director> copiaD = new ArrayList();
        copiaD.addAll(this.directores);
        return copiaD;
    }

    public void setDirectores(ArrayList<Director> directores) {
        ArrayList<Director> copiaD = new ArrayList();
        copiaD.addAll(directores);
        this.directores = copiaD;
    }

    public ArrayList<Bibliotecario> getBibliotecarios() {
        ArrayList<Bibliotecario> copiaB = new ArrayList();
        copiaB.addAll(this.bibliotecarios);
        return copiaB;
    }

    public void setBibliotecarios(ArrayList<Bibliotecario> bibliotecarios) {
        ArrayList<Bibliotecario> copiaB = new ArrayList();
        copiaB.addAll(bibliotecarios);
        this.bibliotecarios = copiaB;
    }

    public ArrayList queLista() {
        System.out.println("\n-- BASES DE DATOS --");
        System.out.println("--------------------\n");
        System.out.println("-- ¿Cual quieres? --");
        System.out.println("--------------------");

        String bdd = "";
        System.out.println("1.-> Directores \n\t 2.-> Bibliotecarios \n\t 3.-> NADA");
        
        bdd = pedirDato();
        switch (bdd.replace(" ", "")) {
            case "1":
                return this.getDirectores();
            case "2":
                return this.getBibliotecarios();
            case "3":
                break;
            default:
                System.err.println("¡ No elegiste algo de la lista !");
                queLista();
        }
        return null;
    }

    public String pedirDato() {
        Scanner scann = new Scanner(System.in);
        return scann.nextLine();
    }
}
