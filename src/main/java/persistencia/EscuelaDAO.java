
package persistencia;

import Logica.Curso;
import Logica.Escuela;
import java.sql.*;
import java.util.ArrayList;

public class EscuelaDAO {
    public ArrayList<Curso> ConsultarCursos(){
        ArrayList lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "--- Busqueda en base de datos ---"; // CAMBIAR
        ResultSet rs = con.EjecutarQuery(sql);
        
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                Curso c = new Curso(nombre, descripcion, id);
                lista.add(c);
            }
        }catch(SQLException e){
            con.Desconectar();
            return null;
        }
        
        con.Desconectar();
        return lista;
    }
    
    public Curso ConsultarCurso(int idConsultar){
        Curso c = null;
        ConexionBD con = new ConexionBD();
        String sql = "--- Busqueda en base de datos ---";// CAMBIAR (WHERE id = idConsultar)
        ResultSet rs = con.EjecutarQuery(sql);
        
        try{
            if(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                c = new Curso(nombre, descripcion, id);
            }
        }catch(SQLException e){
            con.Desconectar();
            return c;
        }
        con.Desconectar();
        return c;
    }
    
    public int GuardarNuevaEscuela(Escuela e){
        ConexionBD con = new ConexionBD();
        String nombre = e.getNombre();
        String sql = "-----";//CAMBIAR (VALUES (valores a agregar))
        ResultSet rs = con.EjecutarQuery(sql);
        
        int id = 0;
        try {
            if(rs.next()){
                id = rs.getInt("0");
                e.setId(id);
            }
        } catch (SQLException ex) {
            return 0;
        }
        return id;
    }
}
