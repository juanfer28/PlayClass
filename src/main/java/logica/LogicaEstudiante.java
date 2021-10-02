/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.TreeMap;
import persistencia.EstudianteDAO;

/**
 * Contiene la lógica requerida para gestionar la información de los Estudiantes
 * @author SIRIUS
 */
public class LogicaEstudiante {
    private ArrayList<Estudiante> lista;
    
    
     /**
     * Obtiene una lista de Estudiantes
     * @return una estructura de datos con los datos de los Estudiantes requeridos
     */
    public ArrayList<Estudiante> getLista() {
        return lista;
    }
    
     /**
     * Obtiene el nombre del curso dado el id correspondiente
     * @param key el id del tipo
     * @return el nombre del tipo de juguete
     */
    public String getCursos(int key) {
        EstudianteDAO dao = new EstudianteDAO();
        TreeMap<Integer, String> listaCursos = dao.cargarCursoEstudiante();
        String value = listaCursos.get(key);
        return value;
    }
    
    /**
     * Obtiene la lista de los tipos de juguetes
     * @return un treemap con los tipos de juguetes
     */
    public TreeMap<Integer, String> getCursos() {
        EstudianteDAO dao = new EstudianteDAO();
        TreeMap<Integer, String> listaCursos = dao.cargarCursoEstudiante();
        return listaCursos;
    }
    
    /**
     * Carga la información de todos los juguetes de la base de datos
     * @return true si carga los juguetes, o false si no se logró cargar
     */
    public boolean cargarTodosLosEstudiantes() {
        EstudianteDAO dao = new EstudianteDAO();
        lista = dao.consultarEstudiante();
        if (lista.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
     /**
     * Carga la información de un solo juguete de la base de datos
     * @return true si carga los juguetes, o false si no se logró cargar
     */
    public Estudiante cargarUnEstudiante(int id) {
        EstudianteDAO dao = new EstudianteDAO();
        Estudiante e = dao.consultarEstudiante(id);
        return e;
    }
    
    /**
     * Carga la información de ciertos juguetes de la base de datos mediante filtro
     * @return true si carga los juguetes, o false si no se logró cargar
     */
    public boolean cargarEstudiantePorFiltro(String filtro) {
        EstudianteDAO dao = new EstudianteDAO();
        lista = dao.consultarestudiantesPorFiltro(filtro);
        if (lista.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Guarda la información de un juguete capturada desde el formulario
     * @param j un objeto con los datos de un juguete específico
     * @return true si guarda el juguete en la base de datos, o false si no lo guarda
     */
    public boolean guardarEstudiante(Estudiante e) {
        EstudianteDAO dao = new EstudianteDAO();
        if (e.getId() == 0) {
            int id = dao.guardarEstudianteExistente(e);
            if (id > 0) {
                return true;
            } else {
                return false;
            }
        }
        else {
            int filas = dao.guardarEstudianteExistente(e);
            if (filas == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
