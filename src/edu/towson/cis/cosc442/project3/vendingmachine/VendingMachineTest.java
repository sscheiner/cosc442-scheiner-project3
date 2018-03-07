package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

	private VendingMachine vend1, vend2, vend3;
	VendingMachineItem item1, item2, item3;
	
	@Before
	public void setUp(){
		vend1 = new VendingMachine();
		vend2 = new VendingMachine();
		vend3 = new VendingMachine();
		item1 = new VendingMachineItem("marley", 420);
		item2 = new VendingMachineItem("@53n2 h\n24378", 0);
		item3 = new VendingMachineItem("josh", 100);
	}

	/**
	 * test that item adds are processed and checked correctly
	 * @throws Exception
	 */
	@Test
	public void testAddItem(){
		vend1.addItem(item1, "A");
		vend1.addItem(item2, "B");
		vend1.addItem(item3, "C");
		vend1.addItem(item1, "D");
		//catch invalid slot
		try {
			vend2.addItem(item1, "Z");
			fail("exception not thrown");
		}
		catch(VendingMachineException e) {
			//test succeeds
		}
		
		//catch adding to occupied slot
		try {
			vend1.addItem(item1, "B");
			fail("exception not thrown");
		}
		catch(VendingMachineException e) {
			//test succeeds
		}

	}
	
	/**
	 * confirm proper removal of item from vending machine slot
	 * @throws Exception
	 */
	@Test
	public void testRemoveItem() throws Exception{
		
		vend3.addItem(item1, "A");
		vend3.removeItem("A");
		assertNull(vend3.getItem("A"));
		
	}
	
	
	/**
	 * tests money insertion method for checks and proper behavior
	 * @throws Exception
	 */
	@Test
	public void testInsertMoney(){
		vend1.insertMoney(99);
		assertEquals(vend1.getBalance(), 99, 0.000001);
		//try to insert negative money
		try {
			vend1.insertMoney(-46.2);
			fail("exception not thrown");
		}
		catch(VendingMachineException e) {
			//test succeeds
		}	
	}
	
	@Test
	public void testGetBalance(){
		
	}
	
	/**
	 * test purchasing success and failure based on balance and item cost
	 */
	@Test
	public void testMakePurchase(){
		
		vend2.addItem(item3, "A");
		vend2.insertMoney(101);
		assertTrue(vend2.makePurchase("A"));
		
	}


	
	/**
	 * not strictly necessary
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

}
