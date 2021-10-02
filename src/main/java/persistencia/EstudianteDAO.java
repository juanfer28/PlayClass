/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import logica.Estudiante;

/**
 *
 * @author SIRIUS
 */
public class EstudianteDAO {

    /**
     * Envía la sentencia SQL para obtener la lista de todos los Estudiante y
     * estructura la respuesta en una estructura de datos
     *
     * @return una estructura de datos con los objetos de tipo Estudiante
     */
    public ArrayList<Estudiante> consultarEstudiante() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT IDEstudiante, Nombre_Estudiante, Apellido_Estudiante, Email_Estudiante, Teléfono, Fecha_de_Inicio, IDCurso "
                + "FROM estudiantes ";
        ResultSet rs = con.EjecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("IDEstudiante");
                String nombre = rs.getString("Nombre_Estudiante");
                String apellido = rs.getString("Apellido_Estudiante");
                String email = rs.getString("Email_Estudiante");
                int telefono = rs.getInt("Teléfono");
                String fecha = rs.getString("Fecha_de_Inicio");
                int idcurso = rs.getInt("IDCurso");
                Estudiante e = new Estudiante(id, nombre, apellido, email, telefono, fecha, idcurso);
                lista.add(e);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return null;
        }
        con.Desconectar();
        return lista;

    }

    /**
     * Envía la sentencia SQL para obtener la información de 1 estudiante
     * específico y estructura la respuesta en un objeto de tipo estudiante
     *
     * @param idAConsultar el id del Estudiante para consultar
     * @return un objeto de tipo Estudiante con la información cargada o null
     */
    public Estudiante consultarEstudiante(int idAConsultar) {
        Estudiante e = null;
        ConexionBD con = new ConexionBD();
        String sql = "SELECT IDEstudiante, Nombre_Estudiante, Apellido_Estudiante, Email_Estudiante, Teléfono, Fecha_de_Inicio, IDCurso "
                + "FROM estudiantes "
                + "WHERE IDEstudiante = " + idAConsultar + " ";
        ResultSet rs = con.EjecutarQuery(sql);
        try {
            if (rs.next()) {
                int id = rs.getInt("IDEstudiante");
                String nombre = rs.getString("Nombre_Estudiante");
                String apellido = rs.getString("Apellido_Estudiante");
                String email = rs.getString("Email_Estudiante");
                int telefono = rs.getInt("Teléfono");
                String fecha = rs.getString("Fecha_de_Inicio");
                int idcurso = rs.getInt("IDCurso");
                e = new Estudiante(id, nombre, apellido, email, telefono, fecha, idcurso);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return e;
        }
        con.Desconectar();
        return e;
    }

    /**
     * Envía la sentencia SQL para obtener la información de ciertos estudiante
     * mediante filtro y estructura la respuesta en una lista de tipo Estudiante
     *
     * @param filtro el filtro para buscar datos en la lista de juguetes para
     * consultar
     * @return un arraylist de tipo Juguete con la información cargada
     */
    public ArrayList<Estudiante> consultarestudiantesPorFiltro(String filtro) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT e.IDEstudiante, e.Nombre_Estudiante, e.Apellido_Estudiante, e.Email_Estudiante, e.Teléfono, e.Fecha_de_Inicio, e.IDCurso "
                + "FROM estudiantes e "
                + "JOIN matriculas m ON (e.IDEstudiante = m.IDEstudiante) "
                + "JOIN cursos c ON (e.IDCurso = c.IDCurso) "
                + "WHERE e.Nombre_Estudiante LIKE '%" + filtro + "%' "
                + "OR e.Apellido_Estudiante LIKE '%" + filtro + "%' "
                + "OR e.Email_Estudiante LIKE '%" + filtro + "%' "
                + "OR e.Teléfono LIKE '%" + filtro + "%' "
                + "OR e.Fecha_de_Inicio LIKE '%" + filtro + "%' "
                + "OR e.IDCurso LIKE '%" + filtro + "%' ";
        ResultSet rs = con.EjecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("IDEstudiante");
                String nombre = rs.getString("Nombre_Estudiante");
                String apellido = rs.getString("Apellido_Estudiante");
                String email = rs.getString("Email_Estudiante");
                int telefono = rs.getInt("Teléfono");
                String fecha = rs.getString("Fecha_de_Inicio");
                int idcurso = rs.getInt("IDCurso");
                Estudiante e = new Estudiante(id, nombre, apellido, email, telefono, fecha, idcurso);
                lista.add(e);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return null;
        }
        con.Desconectar();
        return lista;
    }

    /**
     * Envía la sentencia SQL para almacenar el dato de un estudiante
     *
     * @param e un objeto de tipo Estudiante
     * @return en número indicando el id generado por la base de datos
     */
    public int guardarNuevoEstudiante(Estudiante e) {
        ConexionBD con = new ConexionBD();
        String nombre = e.getNombre();
        String apellido = e.getApellido();
        String email = e.getEmail();
        int telefono = e.getTelefono();
        String fecha = e.getFechaInicio();
        int idcurso = e.getIdcurso();

        String sql = "INSERT INTO estudiantes (Nombre_Estudiante, Apellido_Estudiante, Email_Estudiante, Teléfono, Fecha_de_Inicio, IDCurso ) "
                + "VALUES ('" + nombre + "', '" + apellido + "', '" + email + "', '" + telefono + "', '" + fecha + "', '" + idcurso + "') ";
        ResultSet rs = con.EjecutarInsert(sql);
        int id = 0;
        try {
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return 0;
        }
        con.Desconectar();
        return id;
    }

    /**
     * Envía la sentencia SQL para actualizar el dato de un estudiante existente
     * @param e un objeto de tipo estudiante
     * @return un número indicando la cantidad de registros afectados
     */
    public int guardarEstudianteExistente(Estudiante e) {
        ConexionBD con = new ConexionBD();
        int id = e.getId();
        String nombre = e.getNombre();
        String apellido = e.getApellido();
        String email = e.getEmail();
        int telefono = e.getTelefono();
        String fecha = e.getFechaInicio();
        int idcurso = e.getIdcurso();
        
        String sql = "UPDATE estudiantes "+
                     "SET Nombre_Estudiante = '" + nombre + "' , Apellido_Estudiante = '" + apellido + "' , Email_Estudiante = '" + email + "', Teléfono = '" + telefono + "', Fecha_de_Inicio = '" + fecha + "',  IDCurso = '" + idcurso + "' " + 
                     "WHERE IDEstudiante = " + id + " ";
        int filas = con.EjecutarUpdate(sql);
        con.Desconectar();
        return filas;
    }
    
    /**
     * Cargar los diferentes tipos de juguetes desde la BD
     * @return un treemap con la lista de los tipos de juguetes
     */
    public TreeMap<Integer, String> cargarCursoEstudiante() {
        TreeMap<Integer, String> listaCursos = new TreeMap<Integer, String>();
        ConexionBD con = new ConexionBD();
        ResultSet rs = con.EjecutarQuery("SELECT IDCurso, Nombre_Curso FROM cursos ");
        try {
            while (rs.next()) {
                int id = rs.getInt("IDCurso");
                String curso = rs.getString("Nombre_Curso");
                listaCursos.put(id, curso);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return null;
        }
        con.Desconectar();
        return listaCursos;
    }
}
