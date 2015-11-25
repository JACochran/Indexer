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
	
	@Theory
	public void isEqualsReflexive(Object a)
	{
		Assume.assumeTrue(a != null);
		Assert.assertTrue(a.equals(a));
	}
	
	@Theory
	public void isEqualsTransitive(Object x, Object y, Object z)
	{
		Assume.assumeTrue(x != null && x.equals(y) && y.equals(z));
		Assert.assertTrue(x.equals(z));
	}
	
	@Theory
	public void hashCode(Object a, Object b)
	{
		Assume.assumeTrue(a != null && a.equals(b));
		Assert.assertTrue(a.hashCode() == b.hashCode());
	}
	
	@Theory
	public void equalsNullAlwaysFalse(Object a)
	{
		Assume.assumeTrue(a != null);
		Assert.assertFalse(a.equals(null));
	}

}
