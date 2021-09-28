
package Logica;

public class Usuario {
    private String nombreUsuario;
    private String correo;
    private String contraseña;
    private boolean esProfesor;
    private int id; // Para que la variable sea mas identificable

    public Usuario(String nombreUsuario, String correo, String contraseña, boolean esProfesor) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contraseña = contraseña;
        this.esProfesor = esProfesor;
        // El IDu es autogenerado
    }

    public Usuario(String nombreUsuario, String correo, boolean esProfesor, int id) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.esProfesor = esProfesor;
        this.id = id;
    }
    
    public void CambiarContraseña(String nueva){
        this.contraseña = nueva;
    }
    
    private void CrearEscuela(String nombre){ // Se supone que se crea UNA escuela por usuario
        if(this.esProfesor == true){
            Escuela escuelaUsuario = new Escuela(nombre); // OJO
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean getEsProfesor() {
        return esProfesor;
    }

    public void setEsProfesor(boolean esProfesor) {
        this.esProfesor = esProfesor;
    }
    
    
}
