/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import logica.Estudiante;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import persistencia.ConexionBD;
import persistencia.EstudianteDAO;

/**
 *
 * @author Sirius
 * Se tuvo que poner mayusculas en los metodos porque Gabriel 
 * los cambio en ConexionDB.
 */
public class TestGeneral {
    
    @Ignore
    public void verificarConexion() {
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.IsConectado(), "No hay conexión creada. ");
        con.Desconectar();
        Assert.assertFalse(con.IsConectado(), "No se cerró conexión. ");
    }
    
    @Ignore
    public void verificarCargaEstudiantes() {
        EstudianteDAO dao = new EstudianteDAO();
        Assert.assertTrue(dao.consultarEstudiante().size() > 0, "No se cargaron datos de Estudiantes. ");
    }
    
    @Ignore
    public void verificarCargaCursosEstudiantes() {
        EstudianteDAO dao = new EstudianteDAO();
        Assert.assertTrue(dao.cargarCursoEstudiante().size() > 0, "No se cargaron datos de los Cursos. ");
    }
    
    @Test
    public void verificarInsercionEstudiante() {
        EstudianteDAO dao = new EstudianteDAO();
        Estudiante e = new Estudiante("Estudiante de Prueba", "Apellido de Prueba", "email de prueba", 2171729, "Fecha de inicio prueba", 1 );
        int id = dao.guardarNuevoEstudiante(e);
        Assert.assertTrue(id > 0, "No se guardó dato de un Estudiante. ");
        String sql = "DELETE FROM estudiantes WHERE IDEstudiante = " + id;
        ConexionBD con = new ConexionBD();
        int cant = con.EjecutarUpdate(sql);
        Assert.assertTrue(cant == 1, "No se logró hacer limpieza del dato de prueba de un Estudiante ingresado. ");
        con.Desconectar();
}
}