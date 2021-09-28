
package persistencia;

import Logica.Curso;
import Logica.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UsuarioDAO {
    
    public ArrayList<Curso> ConsultarUsuarios(){
        ArrayList lista = new ArrayList<>();
        ConexionBD con = new ConexionBD();
        String sql = "--- Busqueda en base de datos ---"; // CAMBIAR
        ResultSet rs = con.EjecutarQuery(sql);
        
        try{
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String contraseña = rs.getString("contraseña"); // Esta linea tal vez sea borrable
                boolean esProfesor = rs.getBoolean("es profesor");
                Usuario u = new Usuario(nombre, correo, contraseña, esProfesor);
                lista.add(u);
            }
        }catch(SQLException e){
            con.Desconectar();
            return null;
        }
        
        con.Desconectar();
        return lista;
    }
    
    public Usuario ConsultarUsuario(int idConsultar){
        Usuario u = null;
        ConexionBD con = new ConexionBD();
        String sql = "--- Busqueda en base de datos ---";// CAMBIAR (WHERE id = idConsultar)
        ResultSet rs = con.EjecutarQuery(sql);
        
        try{
            if(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String contraseña = rs.getString("contraseña"); // Esta linea tal vez sea borrable
                boolean esProfesor = rs.getBoolean("es profesor");
                u = new Usuario(nombre, correo, contraseña, esProfesor);
            }
        }catch(SQLException e){
            con.Desconectar();
            return u;
        }
        con.Desconectar();
        return u;
    }
    
    public void EditarUsuario(int id){
        
        ConexionBD con = new ConexionBD();
        String sql = "-----"; // CAMBIAR
        ResultSet rs = con.EjecutarInsert(sql);
        
        try{
            if(rs.next()){
                // El id no se cambia
                
                // Aqui revisar si la editacion de un usuario solo se logra con la sentencia qql o no
            }
        }catch(SQLException e){
            con.Desconectar();
            
        }
        con.Desconectar();
        
    }
    
    
    public int GuardarNuevoUsuario(Usuario u){
        ConexionBD con = new ConexionBD();
        String nombreUsuario = u.getNombreUsuario();
        String correo = u.getCorreo();
        String contraseña = u.getContraseña();
        Boolean esProfesor = u.getEsProfesor();
    
        String sql = "-----";//CAMBIAR (VALUES (valores a agregar))
        ResultSet rs = con.EjecutarInsert(sql);
        
        int id = 0;
        try {
            if(rs.next()){
                id = rs.getInt("0");
                u.setId(id);
            }
        } catch (SQLException ex) {
            return 0;
        }
        return id;
    }
}
