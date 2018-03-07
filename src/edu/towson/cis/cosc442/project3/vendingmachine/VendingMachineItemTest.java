package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class VendingMachineItemTest {
	
	/**necessary objects for setup**/
	VendingMachineItem item1, item2;
	
	/**
	 * sets up the test by instantiating vending machine item objects, tests 
	 * @throws VendingMachineException
	 */
	@Before
	public void setUp() throws VendingMachineException {
		item1 = new VendingMachineItem("marley", 420);
		item2 = new VendingMachineItem("@53n2 h\n24378", 0);
		
		//test exception in instantiation
		try {
			VendingMachineItem error = new VendingMachineItem("dontmatter", -4);
		}
		catch(VendingMachineException e) {
			//test succeeds
		}
	}
	
	/**
	 * tests thatt the item name is properly instantiated and retrieved
	 */
	@Test
	public void testGetName() {
		assertEquals("marley", item1.getName());
		assertEquals("@53n2 h\n24378", item2.getName());
	}
	
	@Test
	public void testGetPrice() {
		assertEquals(420, item1.getPrice(), 0.001);
		assertEquals(0, item2.getPrice(), 0.001);
		//check to ensure price isn't null
		assertNotEquals(null, item1.getPrice());
		assertNotEquals(null, item2.getPrice());
	}
	
	
	/**
	 * clean up
	 */
	@After
	public void tearDown(){
		item1 = null;
		item2 = null;
	}

}
