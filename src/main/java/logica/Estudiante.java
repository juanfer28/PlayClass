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
    private String fechaInicio;  //dd/mm/aaaa
    private int idcurso;

    public Estudiante() {
    }

    
    public Estudiante(String nombre, String apellido, String email, int telefono, String fechaInicio, int idcurso ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.idcurso = idcurso;
    }
    public Estudiante(int id, String nombre, String apellido, String email, int telefono, String fechaInicio, int idcurso) {
        this(nombre,apellido,email,telefono,fechaInicio, idcurso);
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

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }
    
}