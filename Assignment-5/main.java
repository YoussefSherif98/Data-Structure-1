package eg.edu.alexu.csd.datastructure.stack.cs79;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * class containing the main method
 * @author YOUSSEF
 *
 */
public class main {

	/**
	 * Main method containing the UI for both: the stack implementation, and the application 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int x=0;

		System.out.println("Welcome to the Stack Tester");
		/**
		 * Stack to test the stack implementation
		 */
		Stack s = new Stack();
		do {
			System.out.println();
			System.out.println();
			System.out.println("Please choose an action:");
			System.out.println("------------------------");
			System.out.println("1- Push");
			System.out.println("2- Pop");
			System.out.println("3- Peek");
			System.out.println("4- Get size");
			System.out.println("5- Check if empty");
			System.out.println("6- Display Stack (Extra)");
			System.out.println("0- Exit and proceed to the application");
			System.out.println("============================");
			
	
			x=scan.nextInt();
			
			
			switch(x)
			{
			case 1:
				System.out.println("Enter Integer to push");
				s.push((int)scan.nextInt());
				break;
			case 2:
				System.out.println(s.pop()+" is popped");
				break;
			case 3:
				System.out.println(s.peek()+" is the peek");
				break;
			case 4:
				System.out.println("Size is "+s.size());
				break;
			case 5:
				System.out.println(s.isEmpty());
				break;
			case 6:
				s.display();
		}
			delay(1000);
			
		}
		while(x!=0);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Welcome to the Expression Calculator");
		System.out.println("-------------------------");
		
		boolean flag=true;
		while(flag==true)
		{
			System.out.println("Please enter the expression you wish to calculate");
			
			/**
			 * The expression the user wishes to calculate
			 */
			String str =" ";
			str=scan.nextLine();
			str+= scan.nextLine();

			
			ExpressionEvaluator e = new ExpressionEvaluator();
			str = e.infixToPostfix(str);
			System.out.println("The expression in Postfix Nottation is:");
			System.out.println(str);
			System.out.println();
			
			System.out.println("Answer is "+e.evaluate(str));
			delay(1000);
			System.out.println();
			System.out.println("Do you like to continue (Y/N)");
			while(true)
			{
				char cont = (scan.next()).charAt(0);
				if(cont=='Y' || cont=='y')
				{
					flag=true;
					break;
				}
				else if(cont=='N' || cont=='n')
				{
					flag=false;
					break;
				}
			}
		}
	}

	/**
	 * Delays the program of execution for a number of milliseconds
	 * @param n
	 *     number of milliseconds to be delayed
	 */
	private static void delay(int n)
	{
		long start = System.currentTimeMillis();
		while(start>=System.currentTimeMillis()-n);
	}
}
