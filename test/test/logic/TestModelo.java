package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(""+i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO Listo
		setUp2();
		assertEquals(100, modelo.darTamano());
	}

	@Test
	public void testAgregar() {
		// TODO Completar la prueba Listo
		setUp1();
		
		modelo.agregar("hola");
		assertEquals( "hola", modelo.buscar("hola"));
	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba Listo
		
		assertEquals("0", modelo.buscar("0"));
		
	}

	@Test
	public void testEliminar() {
		setUp2();
		// TODO Completar la prueba Listo
		modelo.eliminar("99");
		modelo.eliminar("49");
		assertEquals(98, modelo.darTamano());
	}

}
