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
     * Envía la sentencia SQL para obtener la lista de todos los Estudiante y estructura
     * la respuesta en una estructura de datos
     * @return una estructura de datos con los objetos de tipo Estudiante
     */
    public ArrayList<Estudiante> consultarEstudiante() {
        ArrayList<Estudiante> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT IDEstudiante, Nombre_Estudiante, Apellido_Estudiante, Email_Estudiante, Teléfono, Fecha_de_Inicio, IDCurso " + 
                     "FROM estudiantes ";
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
     * Envía la sentencia SQL para obtener la información de 1 estudiante específico y estructura
     * la respuesta en un objeto de tipo estudiante
     * @param idAConsultar el id del Estudiante para consultar
     * @return un objeto de tipo Estudiante con la información cargada o null
     */
    public Estudiante consultarEstudiante(int idAConsultar) {
        Estudiante e = null;
        ConexionBD con = new ConexionBD();
        String sql = "SELECT IDEstudiante, Nombre_Estudiante, Apellido_Estudiante, Email_Estudiante, Teléfono, Fecha_de_Inicio, IDCurso " + 
                     "FROM estudiantes "+
                     "WHERE IDEstudiante = " + idAConsultar + " ";
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
     * @param filtro el filtro para buscar datos en la lista de juguetes para consultar
     * @return un arraylist de tipo Juguete con la información cargada
     */
     public ArrayList<Estudiante> consultarestudiantesPorFiltro(String filtro) {
        ArrayList<Estudiante> lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "SELECT e.IDEstudiante, e.Nombre_Estudiante, e.Apellido_Estudiante, e.Email_Estudiante, e.Teléfono, e.Fecha_de_Inicio, e.IDCurso " +
                     "FROM estudiantes e " +
                     "JOIN matriculas m ON (e.IDEstudiante = m.IDEstudiante) " +
                     "JOIN estados_juguetes e ON (j.estadojuguete_id = e.id) " +
                     "WHERE j.nombre LIKE '%" + filtro + "%' " +
                     "OR t.tipo LIKE '%" + filtro + "%' " +
                     "OR e.estado LIKE '%" + filtro + "%' " +
                     "OR j.disponibilidad LIKE '%" + filtro + "%' ";
        ResultSet rs = con.ejecutarQuery(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int idTipo = rs.getInt("tipojuguete_id");
                String fechaCompra = rs.getString("fechacompra");
                int idEstado = rs.getInt("estadojuguete_id");
                String disponibilidad = rs.getString("disponibilidad");
                Juguete j = new Juguete(id, nombre, idTipo, fechaCompra, idEstado, disponibilidad);
                lista.add(j);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return null;
        }
        con.Desconectar();
        return lista;
    }   
     
     
     
     
     
     
     
     
     
         /**
     * Envía la sentencia SQL para almacenar el dato de un juguete
     * @param j un objeto de tipo Juguete
     * @return in número indicando el id generado por la base de datos
     */
    public int guardarNuevoEstudiante(Estudiante e) {
        ConexionBD con = new ConexionBD();
        String nombre = e.getNombre();
        String apellido = e.getApellido();
        String email = e.getEmail();
        int telefono = e.getTelefono();
        String fecha = e.getFechaInicio();
        int idcurso = e.getIdcurso();
        
        String sql = "INSERT INTO estudiantes (nombre, apellido, email, telefono, fecha, idcurso ) "+
                     "VALUES ('"+nombre+"', "+apellido+", '"+email+"', "+telefono+", '"+fecha+"', '"+idcurso+"') ";
        ResultSet rs = con.EjecutarInsert(sql);
        int id = 0;
        try {
            if (rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            con.Desconectar();
            return 0; 
        }
        con.Desconectar();
        return id;
    }
    
}
