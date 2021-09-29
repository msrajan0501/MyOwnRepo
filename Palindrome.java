import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// get the string input from user
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();

		// split the string into individual characters & loop through the character
		// array and store it in a string
		// int num2 = 0;
		String numtotext = new String();
		numtotext = String.valueOf(num1);
		int len = numtotext.length();
		String manStr = new String();
		for (int i = len - 1; i >= 0; i--) {
			manStr = manStr + numtotext.charAt(i);

		}
		System.out.println("Manipulated number is:" + manStr);
		// compare the user inputted string with the manipulated string
		if (numtotext.equals(manStr)) {
			System.out.println("Entered number is a palindrome");

		} else {
			System.out.println("Entered number is not a palindrome");

		}
	}

}
