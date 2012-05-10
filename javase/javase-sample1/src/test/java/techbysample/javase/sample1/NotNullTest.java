package techbysample.javase.sample1;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import techbysample.javase.sample1.annotation.validator.NotNullableValidator;
import techbysample.javase.sample1.model.Employee;

/**
 * 
 * @author TechBySample.com
 *
 */

public class NotNullTest {

	
	@Test
	public void testEmployeeNotNull()
	{
        Employee employee = new Employee();
        employee.setFirstName("Scott");
        List errors = NotNullableValidator.validate(employee);
        Assert.assertEquals("Error(s): " + errors.toString(),0,errors.size());
	}
	
}
