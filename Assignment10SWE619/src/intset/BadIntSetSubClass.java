package intset;

public class BadIntSetSubClass extends BadIntSet
{
	private String bad;
	
	public BadIntSetSubClass(String toTheBone)
	{
		this.bad = toTheBone;
	}
	
    @Override
    public int hashCode() 
    {
    	return super.hashCode() + this.bad.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) 
    {
    	if(!(obj instanceof BadIntSetSubClass))
    	{
    		return false;
    	}
    	
    	BadIntSetSubClass sub = (BadIntSetSubClass)obj;
    	return super.equals(obj) && this.bad.equals(sub.bad);
    }
}
