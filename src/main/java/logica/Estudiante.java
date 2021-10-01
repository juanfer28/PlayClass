/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Juanfer
 */
public class Estudiante {
    private int id = 0;
    private String nombre;
    private String apellido;
    private String email;
    private int telefono;
    private String nombreCurso;
    private String fechaInicio;  //dd/mm/aaaa

    public Estudiante() {
    }

    
    public Estudiante(String nombre, String apellido, String email, int telefono, String nombreCurso, String fechaInicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.nombreCurso = nombreCurso;
        this.fechaInicio = fechaInicio;
    }
    public Estudiante(int id, String nombre, String apellido, String email, int telefono, String nombreCurso, String fechaInicio) {
        this(nombre,apellido,email,telefono,nombreCurso,fechaInicio);
        this.id = id;
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
   
    
}
