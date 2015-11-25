package bag;

import org.junit.runner.RunWith;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

@RunWith(Theories.class)
public class AdvanceJUnitTests 
{
	@DataPoint
	public static String GOOD_UserName ="opt";
	
	
	@Theory
	public void isEqualsSymmetric(Object a, Object b)
	{
		Assume.assumeTrue(a != null && a.equals(b));
		Assert.assertTrue(b.equals(a));
	}
	
	
	

}
