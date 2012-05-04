package techbysample.junit4.sample1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author TechBySample.com
 *
 */

public class MyMathTest {

	private MyMath myMath = null;
	
	@Before
	public  void initialize() {
		
		System.out.println("@Before- initialize()");
		myMath = new MyMath();
	}
	

	@Test
	public void testAdd()
	{
		System.out.println("@Test- testAdd()");
		int x=1;
		int y=2;
		
		int z = myMath.add(x, y);
		Assert.assertEquals(3, z);
	}
	
	@Test
	public void testMultiply()
	{
		System.out.println("@Test- testMultiply()");
		int x=3;
		int y=2;
		
		int z = myMath.multiply(x, y);
		Assert.assertEquals(6, z);
	}
	
	@After
	public void tearDown()
	{
		System.out.println("@After- tearDown()");
		
	}
}
