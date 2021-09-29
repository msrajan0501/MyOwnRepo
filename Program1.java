import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Receive input from the user
		System.out.println("Enter the numbers");
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// Enumerating the numbers between the entered inputs

		for (int i = num1; i <= num2; i++) {
			// System.out.println(i);
			if (i%3==0)
			{
			System.out.println("Fizz");
			}
			else if (i%5==0)
			{
			System.out.println("Buzz");
			}
			else if ((i%3==0) && (i%5==0))
			{
			System.out.println("Fizz Buzz");
			}
			else
			{
			System.out.println(i);
			}
		}

	}

}
