import org.apache.commons.lang3.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
class Animal{
	String name="???";
	public void printName(){
		System.out.println(name);
	}
	public void pet(){
		System.out.println("pet a animal");
	}
}
class lion extends Animal{
	String name="lion";
	@Override     // @ symbol means annotation , override means this method has overridden version 
	public void printName(){
		System.out.println(name);
	}
	
	@Override public void pet(){  // the annotation can also be wrote in this position . 
		System.err.println("you cannot pet a lion");
	}
	public String toString(){  // there is a good third party library for us to use to implement toString()
		return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	}
	public boolean equals(Object obj){
		if(!(obj instanceof lion))return false;		//instanceof can help us to check if an object is instance of this type,if not ,there is no way for them to be equal
		lion lio=(lion)obj;
		return lio.name.equals("name");
	}
	public int hashCode(){
		return name.hashCode();  
	}
	// hash code has more rules to follow: 1. the values it use must be subset of equals() 2 the value in hashCode() should not change 3 if equals() return true, hashCode() should also return equals() 

}

public class Basics{
      final class parent{}   // use final on class mean this class cannot be subclassed 
      /*class son extends parent{        this will cause complie error	  
      }*/
      
      public static void main(String[] args){
    	  String ss= "s";
    	  System.out.println(ss instanceof String); // instanceof can check if an instance is a specific type 
    	  // System.out.println(ss instanceof StringBuilder);  if the instance is not related to the type at all , it will throw complie error.
      
    	  Animal lion=new lion();    
    	  lion.pet();					// when you call a method on an object, it will execute the overridden method if exists.
    	  lion.printName();		// but when you call an variable  on an obeject, it will always use the variable of reference type rather than instance type
    	 
      }
}
