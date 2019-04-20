package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs79;

import java.util.Scanner;

public class main {

	 public static void main (String[] args) {
		 int x;
		 do {
		 PolynomialSolver P = new PolynomialSolver();
		 System.out.println("Please choose an action");
		 System.out.println("-----------------------");
		 System.out.println("1- Set a polynomial variable");
		 System.out.println("2- Print the value of a polynomial variable");
		 System.out.println("3- Add two polynomials");
		 System.out.println("4- Subtract two polynomials");
		 System.out.println("5- Multiply two polynomials");
		 System.out.println("6- Evaluate a polynomial at some point");
		 System.out.println("7- Clear a polynomial variable");
		 System.out.println("0- Exit the program");
		 System.out.println("====================================================================");
		 Scanner scan = new Scanner(System.in);
		 x = scan.nextInt();
		 switch (x) {
		 case 1:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char poly = scan.next().charAt(0);
		
			 if (poly=='A' || poly=='B' || poly=='C')
			 {
				 System.out.println("Insert the polynomial terms in the form:");
				 System.out.println("(coeff1, exponent1),(coeff2, exponent2), ..");
				 Scanner d = new Scanner(System.in);
				 String s = d.nextLine();
				 s=s.replace("(", "");
				 s=s.replace(")", "");
				 s=s.replace(" ", "");
				 String[] S = s.split(",");
				 int v = ((S.length)/2);
				 int arr[][] = new int[v][2];
				 int j = 0 ;
				 for (int i=0; i<(v) ; i++) {
					 arr[i][0] = Integer.parseInt(S[j]);
					 j++;
					 arr[i][1] = Integer.parseInt(S[j]);
					 j++;
				 }
				 P.setPolynomial(poly, arr);
				 
				 System.out.printf("Polynomial %c is set",poly);
				 System.out.println(" ");
				 System.out.println("====================================================================");
			 
			 }
			 else
				 System.out.println("Incorrect Letter!");
		 }
		 break;
		 case 2:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char c = scan.next().charAt(0);
			 String s =P.print(c);
			 if (s == null) {
				 System.out.println("Invalid, "+c+" is not set");
			 }
			 else
				 System.out.println(s);
			 System.out.println("====================================================================");
		 }
		 break;
		 case 3:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char c = scan.next().charAt(0);
			 System.out.println("Insert the variable name: A, B or C");
			 char d = scan.next().charAt(0);
			 int arr[][] = P.add(c, d);
			 while (arr == null) {
				 System.out.println("Invalid");
				 System.out.println("Insert the variable name: A, B or C");
				 c = scan.next().charAt(0);
				 System.out.println("Insert the variable name: A, B or C");
				 d = scan.next().charAt(0);
				 arr = P.add(c, d);
			 }
			 P.setPolynomial('R', arr);
			 String s  = P.print('R');
			 System.out.println(" ");
			 System.out.println(s);
			 System.out.println("====================================================================");
		 }
		 break;
		 case 4:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char c = scan.next().charAt(0);
			 System.out.println("Insert the variable name: A, B or C");
			 char d = scan.next().charAt(0);
			 if (c==d) {
				 System.out.println("0");
				 System.out.println("====================================================================");
				 break;
			 }
			 int arr[][] = P.subtract(c, d);
			 while (arr == null) {
				 System.out.println("Invalid");
				 System.out.println("Insert the variable name: A, B or C");
				 c = scan.next().charAt(0);
				 System.out.println("Insert the variable name: A, B or C");
				 d = scan.next().charAt(0);
				 arr = P.subtract(c, d);
			 }
			 P.setPolynomial('R', arr);
			 String s  = P.print('R');
			 System.out.println(" ");
			 System.out.println(s);
			 System.out.println("====================================================================");
		 }
		 break;
		 case 5:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char c = scan.next().charAt(0);
			 System.out.println("Insert the variable name: A, B or C");
			 char d = scan.next().charAt(0);
			 int arr[][] = P.multiply(c, d);
			 while (arr == null) {
				 System.out.println("Invalid");
				 System.out.println("Insert the variable name: A, B or C");
				 c = scan.next().charAt(0);
				 System.out.println("Insert the variable name: A, B or C");
				 d = scan.next().charAt(0);
				 arr = P.multiply(c, d);
			 }
			 P.setPolynomial('R', arr);
			 String s  = P.print('R');
			 System.out.println(" ");
			 System.out.println(s); 
			 System.out.println("====================================================================");
		 }
		 break;
		 case 6:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char c = scan.next().charAt(0);
			 System.out.println("Insert the value to evaluate at:");
			 float fl = scan.nextFloat();
			 float f = P.evaluatePolynomial(c, fl);
			 System.out.println(f);
			 System.out.println("====================================================================");
		 }
		 break;
		 case 7:
		 {
			 System.out.println("Insert the variable name: A, B or C");
			 char c = scan.next().charAt(0);
			 System.out.println(c);
			 if (c == 'A' || c == 'B' || c == 'C' ) { 
				 P.clearPolynomial(c);
				 System.out.println(c+" is cleared");
				 System.out.println("====================================================================");
				 }
			 else {
				 System.out.println("Invalid");
				 System.out.println("====================================================================");
			 }
		 }
		 break;
		 case 0:
		 {}break;
		 default :
			 System.out.println("Invalid input");
		 }
		 }while(x != 0);
	 }

}
