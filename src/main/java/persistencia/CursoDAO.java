
package persistencia;

import Logica.Curso;
import Logica.Usuario;
import java.sql.*;
import java.util.ArrayList;


public class CursoDAO {
    public ArrayList<Usuario> ConsultarEstudiantes(){
        ArrayList lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "--- Busqueda en base de datos ---"; // CAMBIAR
        ResultSet rs = con.EjecutarQuery(sql);
        
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                // La contraseña no se pide
                Boolean esProfesor = rs.getBoolean("esProfesor");
                Usuario u = new Usuario(nombre, correo, esProfesor, id);
                lista.add(u);
            }
        }catch(SQLException e){
            con.Desconectar();
            return null;
        }
        
        con.Desconectar();
        return lista;
    }
    
    public Usuario ConsultarEstudiante(int idConsultar){
        Usuario u = null;
        ConexionBD con = new ConexionBD();
        String sql = "--- Busqueda en base de datos ---";// CAMBIAR (WHERE id = idConsultar)
        ResultSet rs = con.EjecutarQuery(sql);
        
        try{
            if(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                u = new Usuario(nombre, correo, false, id);
            }
        }catch(SQLException e){
            con.Desconectar();
            return u;
        }
        con.Desconectar();
        return u;
    }
    
    public int GuardarNuevoCurso(Curso c){
        ConexionBD con = new ConexionBD();
        String nombre = c.getNombre();
        String descripcion = c.getDescripcion();
        String sql = "-----";//CAMBIAR (VALUES (valores a agregar))
        ResultSet rs = con.EjecutarQuery(sql);
        
        int id = 0;
        try {
            if(rs.next()){
                id = rs.getInt("0");
                c.setId(id);
            }
        } catch (SQLException ex) {
            return 0;
        }
        return id;
    }
}
