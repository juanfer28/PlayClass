/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private String descripcion;
    private int id; 
    //private ArrayList<Publicacion> listaPublicaciones;
    private ArrayList<Usuario> listaEstudiantes;
    
    public Curso(String nombre, String descripcion, int id){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
    }
    
    /*public void BorrarPublicacion(Publicacion p){
        listaPublicaciones.remove(p);
    }
    // Para agregar al DAO estas dos funciones
    public void AgregarPublicacion(Publicacion publicacion){
        listaPublicaciones.add(publicacion);
    }*/
    
    public void Matricularse(Usuario estudiante ){
        listaEstudiantes.add(estudiante);
    }
    
    public void Desvincularse(Usuario estudiante){
            listaEstudiantes.remove(estudiante);
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
