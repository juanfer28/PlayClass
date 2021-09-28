
package Logica;

import java.util.ArrayList;


public class Escuela {
    private String nombre;
    private int IDe; // ID escuela IDe
    private ArrayList<Curso> listaCursos;

    public Escuela(String nombre) {
        this.nombre = nombre;
    }
    
    public void BorrarCurso(Curso c){
        listaCursos.remove(c);
    }
    // Estas funciones va para el DAO
    
    public void AgregarCurso(Curso c){
        listaCursos.add(c);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return IDe;
    }

    public void setId(int IDe) {
        this.IDe = IDe;
    }
}