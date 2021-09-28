
package persistencia;

import Logica.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    
    public int GuardarNuevoUsuario(Usuario u){
        ConexionBD con = new ConexionBD();
        String nombreUsuario = u.getNombreUsuario();
        String correo = u.getCorreo();
        String contraseña = u.getContraseña();
        Boolean esProfesor = u.getEsProfesor();
    
        String sql = "-----";//CAMBIAR (VALUES (valores a agregar))
        ResultSet rs = con.EjecutarQuery(sql);
        
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
