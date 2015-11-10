package intset;

import java.util.*;

final public class IntSet implements Cloneable 
{  
   private List<Integer> els;

   @Override 
   public boolean equals(Object obj) 
   {  // Standard recipe
      if (!(obj instanceof IntSet)) return false;

      IntSet s = (IntSet) obj;
      
      return super.equals(obj) && this.els.containsAll(s.els) && s.els.containsAll(this.els);
   }

   @Override 
   public int hashCode() 
   { 
	  int sum = 0;
	  
	  for(Integer i : els)
	  {
		  sum += i.hashCode();
	  }
	  
      return sum;
   }

   public IntSet () { els = new ArrayList<Integer>(); }

   @Override 
   public IntSet clone() throws CloneNotSupportedException  
   { 
	    IntSet result = (IntSet) super.clone();
		result.els = new ArrayList<Integer>(els);
		
		return result;
   }
}
