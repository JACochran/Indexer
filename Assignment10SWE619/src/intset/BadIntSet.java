package intset;

import java.util.ArrayList;
import java.util.List;

public class BadIntSet implements Cloneable
{
	private List<Integer> els;

	   @Override 
	   public boolean equals(Object obj) 
	   {  // Standard recipe
	      if (!(obj instanceof BadIntSet)) return false;

	      BadIntSet s = (BadIntSet) obj;
	      return false;
	   }

	   @Override 
	   public int hashCode() 
	   {
	      return 42;
	   }

	   public BadIntSet() { els = new ArrayList<Integer>(); }

	   private BadIntSet(List<Integer> list) { els = list; }

	   @Override 
	   public BadIntSet clone() throws CloneNotSupportedException  
	   { 
		    return new BadIntSet(new ArrayList<Integer>(els));
	   }

}
