
import java.util.*;

public class StringPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		   {
		      
		      Scanner sc = new Scanner(System.in);
		 		      System.out.println("Enter a string:");
		      String input = new String("");
		      input = sc.next();
		      String man= new String("");
		      int length = input.length();
		 
		      for ( int i = length - 1; i >= 0; i-- )
		         man = man + input.charAt(i);
		 
		      if (input.equals(man))
		         System.out.println(input+" is a palindrome");
		      else
		         System.out.println(input+" is not a palindrome");
		 
		   }
	}
}

