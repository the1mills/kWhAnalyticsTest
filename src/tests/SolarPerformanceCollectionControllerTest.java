package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import allSolar.IndividualSolarPerformance;
import allSolar.SolarPerformanceCollectionController;

public class SolarPerformanceCollectionControllerTest {
	
	private  SolarPerformanceCollectionController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
        controller =  SolarPerformanceCollectionController.getInstance();
		
		controller.add(new IndividualSolarPerformance("rome",.49));
		controller.add(new IndividualSolarPerformance("florence",.33));
		controller.add(new IndividualSolarPerformance("milan",.64));
		controller.add(new IndividualSolarPerformance("turin",.89));
		controller.add(new IndividualSolarPerformance("bologna",.46));
		controller.add(new IndividualSolarPerformance("genoa",.39));
		controller.add(new IndividualSolarPerformance("palermo",.68));
		controller.add(new IndividualSolarPerformance("naples",.65));
		controller.add(new IndividualSolarPerformance("bari",.77));
		controller.add(new IndividualSolarPerformance("catania",.21));
		controller.add(new IndividualSolarPerformance("parma",.82));
		controller.add(new IndividualSolarPerformance("perugia",.84));
		controller.add(new IndividualSolarPerformance("verona",.25));
		controller.add(new IndividualSolarPerformance("messina",.79));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMax() {
		
		assertEquals(controller.getMax().getSystemName(),"turin");
	}
	
	@Test
	public void testMin() {
		assertEquals(controller.getMin().getSystemName(),"catania");
	}
	
	@Test
	public void testTop() {
		assertTrue(controller.getNthPercentile(.99).size() == 1);
		assertTrue(controller.getNthPercentile(.90).size() == 5);
		assertTrue(controller.getNthPercentile(.80).size() == 9);
		
	}
}
