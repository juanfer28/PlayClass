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
}
