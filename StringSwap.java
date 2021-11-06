import java.util.Scanner;

public class StringSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
	      System.out.println("Enter string1:");
 String s1 = new String("");
 s1 = sc.next();
 System.out.println("Enter string2:");
 String s2 = new String("");
 s2 = sc.next();
 System.out.println("string 1:"+s1);
 System.out.println("string 2:"+s2);
 s1=s1+s2;
s2 = s1.substring(0, s1.length() - s2.length());  
s1 = s1.substring(s2.length());  
System.out.println("string 1:"+s1);
System.out.println("string 2:"+s2);
	}

}
