/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dbtest;

import data.AlquilerViviendaData;
import db.AlquilerDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author isabe
 */
public class AlquilerTest {

    public AlquilerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test

    public void listarAlquiler() {
        AlquilerDAO daoTest = new AlquilerDAO();
        
        //Preparo datos
        String codReferencia = "v6001";
        int numExpediente = 400210;
        java.sql.Date fechaEntrada = java.sql.Date.valueOf("2025-01-12");
        java.sql.Date fechaSalida = java.sql.Date.valueOf("2025-01-14");
        String estado = "pagado";
        
        List<AlquilerViviendaData> salidaTest = daoTest.listarAlquilerViv(codReferencia, numExpediente, fechaEntrada, fechaSalida, estado);
        assertNotNull("La lista no debe contener valores null", salidaTest);
        assertFalse("La lista no debe estar vacía en caso de que contenga datos", salidaTest.isEmpty());
        
        //Salida
        for(AlquilerViviendaData salida : salidaTest){
            assertEquals("Debe ser v6001. ", "v6001", salida.getCodReferencia()); //Para el codigo de referencia
            assertEquals("Debe ser 400210. ", 400210, salida.getNumExpediente()); //Para el expediente
            assertEquals("Debe ser 2025-01-13", java.sql.Date.valueOf("2025-01-13"), salida.getFechaEntrada()); //Para las fechas
            assertEquals("Debe ser pagado. ", "pagado", salida.getEstado()); //Para el estado
        }
    }
}
