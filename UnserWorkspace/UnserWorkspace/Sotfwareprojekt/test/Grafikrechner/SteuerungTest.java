package Grafikrechner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SteuerungTest {

	@Test
	public void testZerlegeFunktionsgleichungEins() {
		Steuerung steuerung = new Steuerung();

		ArrayList<String> retval = steuerung.zerlegeFunktionsgleichungEins("x+2");

		assertEquals(1, retval.size());

		retval = steuerung.zerlegeFunktionsgleichungEins("x+2 * 5");

		assertEquals(1, retval.size());
		assertEquals("x", retval.get(0));
		assertEquals("2 * 5", retval.get(0));

		retval = steuerung.zerlegeFunktionsgleichungEins("x+2*5");

		assertEquals(2, retval.size());
		assertEquals("x", retval.get(0));
		assertEquals("2*5", retval.get(0));
	}

	@Test
	public void testzFG() {
		Steuerung steuerung = new Steuerung();

		List<String> liste = steuerung.zFG("2x+6");

		assertEquals(2, liste.size());

		liste = steuerung.zFG("2x-6");

		assertEquals(2, liste.size());

		
		liste = steuerung.zFG("2x-6+9");

		assertEquals(3, liste.size());
	}
}
