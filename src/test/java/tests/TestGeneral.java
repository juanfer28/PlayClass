/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import persistencia.ConexionBD;

/**
 *
 * @author Sirius
 * Se tuvo que poner mayusculas en los metodos porque Gabriel 
 * los cambio en ConexionDB.
 */
public class TestGeneral {
    
    @Test
    public void verificarConexion() {
        ConexionBD con = new ConexionBD();
        Assert.assertTrue(con.IsConectado(), "No hay conexión creada. ");
        con.Desconectar();
        Assert.assertFalse(con.IsConectado(), "No se cerró conexión. ");
    }
}