package eg.edu.alexu.csd.datastructure.stack.cs79;

import java.util.Scanner;

/**
 * 
 * @author YOUSSEF
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator{

	/** 
	 * Takes a symbolic/numeric infix expression as input and converts it to
	 * postfix notation. There is no assumption on spaces between terms or the 
	 * length of the term (e.g., two digits symbolic or numeric term) 
	 * @param expression 
	 *   infix expression 
	 * @return postfix expression 
	 */ 
	public String infixToPostfix(String expression) {

		expression=expression.replace(" ","");
		expression=expression.replace("++", "+");
		expression=expression.replace("--", "+");
		expression=expression.replace("+-", "-");
		expression=expression.replace("*+","*");
		expression=expression.replace("/+", "/");
		expression=expression.replace("(-", "(0-");
		expression=expression.replace(")(", ")*(");

		if(expression.contains("-*") || expression.contains("-/") || expression.contains("+*") || expression.contains("+/"))
		{
			System.out.println("Syntax error");
			return null;
		}
		if(expression.contains("*-") || expression.contains("/-") || expression.charAt(0)=='-')
		{
			System.out.println("Syntax error, please put negative values between brackets");
			return null;
		}
		if(highOp(expression.charAt(0)) && expression.charAt(0)!='(')
		{
			System.out.println("Syntax error");
			return null;
		}
		if(lowOp(expression.charAt(expression.length()-1)) || highOp(expression.charAt(expression.length()-1)))
		{
			System.out.println("Syntax error");
			return null;
		}
	
		int n=expression.length();
		
	
		/**
		 * Stack used for the conversion between Infix to Postfix notation
		 */
		Stack s = new Stack();
		
		/**
		 * The expression in Postfix notation
		 */
		StringBuilder newExpression = new StringBuilder();
		
		for(int i=0;i<n;i++)
		{
			char x=expression.charAt(i);
			if(num(x))
			{
				while(i<n && num(x))
				{
					newExpression.append(x);
					i++;
					if(i==n || !num(expression.charAt(i)))
					{
						break;
					}
					x=expression.charAt(i);
				}
				newExpression.append(' ');
				i--;
			}
			else if(variable(x))
			{
				newExpression.append(x);
				newExpression.append(' ');
				if(i+1<n && variable(expression.charAt(i+1)))
				{
					newExpression.append(expression.charAt(i+1));
					newExpression.append(' ');
					newExpression.append('*');
					newExpression.append(' ');
					i++;
				}
			}
			else if(x=='(')
			{
				s.push(x);
			}
			else if(x==')')
			{
				boolean flag=false;
				while(!s.isEmpty())
				{
					if((char)s.peek()=='(')
					{
						s.pop();
						flag=true;
						break;
					}
					else
					{
						newExpression.append((char)s.pop());
						newExpression.append(' ');
					}
				}
				if(!flag)
				{
					System.out.println("Unbalanced expression");
					return null;
				}
			}
			else if(   (s.isEmpty()||((char)s.peek()=='(')   &&  ( highOp(x) || lowOp(x) )   ) || (highOp(x)&&lowOp((char)s.peek())) )
			{
				s.push(x);
			}
			else if( (lowOp(x) && highOp((char)s.peek())) || (lowOp(x) && lowOp((char)s.peek())) || (highOp(x) && highOp((char)s.peek()) ))  
			{
				newExpression.append((char)s.pop());
				newExpression.append(' ');
				i--;
			}
			else
			{
				System.out.println("Undefined expression");
				return null;
			}
			
		}
		
		
		while(!s.isEmpty())
		{
			if((char)s.peek()=='(')
			{
				System.out.println("Unbalanced expression");
				return null;
			}
			newExpression.append((char)s.pop());
			newExpression.append(' ');
		}
		
		return newExpression.toString();
		
	}

	/** 
	* Evaluate a postfix numeric expression, with a single space separator * 
	* @param expression 
	*    postfix expression 
	* @return the expression evaluated value 
	*/ 
	public int evaluate(String expression) {

		/**
		 * Stack used for calculation of postfix expression
		 */
		Stack s = new Stack();
		int n=0;
		if(expression!=null)
		{
			n=expression.length();
			
			Scanner scan = new Scanner(System.in);
			
			for(int i=0;i<n;i++)
			{
				if(variable(expression.charAt(i)))
				{
					System.out.println("Enter the value of "+expression.charAt(i));
					int temp = scan.nextInt();
					expression=expression.replace(String.valueOf(expression.charAt(i)), String.valueOf(temp) );
				}
			}
			
			for(int i=0;i<n-1;i++)
			{
				if(lowOp(expression.charAt(i)) || highOp(expression.charAt(i)))
				{
					double f2= Double.valueOf((double) s.pop());
					double f1= Double.valueOf((double) s.pop());
					
					double r=0;
					switch(expression.charAt(i))
					{
					case '+':
						r=f1+f2;
						break;
					case '-':
						r=f1-f2;
						break;
					case '*':
						r=f1*f2;
						break;
					case '/':
						if(Math.abs(f2-0.0)<Math.pow(10, -8))
						{
							System.out.println("Math error");
							return 0;
						}
						r=f1/f2;
					}
					
					s.push(r);
				}
				else if(expression.charAt(i)==' ')
					;
				else
				{
					/**
					 * Stack to transform a char sequence describing a number of many digits
					 * into a one integer
					 */
					Stack temp = new Stack();
					int power=0;
					int sum=0;
					
					char x=expression.charAt(i);
					
					while(i<n && num(x))
					{
						temp.push((int)expression.charAt(i)-48);
						i++;
						if(i==n || expression.charAt(i)==' ')
						{
							break;
						}
						x=expression.charAt(i);
					}
					
					int n2=temp.size();
					for(int j=0;j<n2;j++)
					{
						sum+=((int)temp.pop())*Math.pow(10, power);
						power++;
					}
					s.push(Double.valueOf(sum));
				}
			}
			return (int) Math.round(((double)s.pop()));
		}
		
		return 0;
	}
	
	/**
	 * Checks if a character is a digit
	 * @param x
	 *      character to be checked
	 * @return true if character is a digit
	 */
	private boolean num(char x)
	{
		switch (x)
		{
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			return true;
		}
		return false;
	}

	/**
	 * Checks if a character is an operator of high precedence
	 * @param x
	 *     character to be checked
	 * @return true if character is an operator of high precedence
	 */
	private boolean highOp(char x)
	{
		switch(x)
		{
		case '*':
		case '/':
		case '(':
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a character is an operator of low precedence
	 * @param x
	 *      character to be checked
	 * @return true if character is an operator of low precedence
	 */
	private boolean lowOp(char x)
	{
		switch(x)
		{
		case '+':
		case '-':
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if a character is a variable
	 * @param x
	 *     character to be checked
	 * @return true if character is a variable
	 */
	private boolean variable(char x)
	{
		int X = (int)x;
		if( X>=65 && X<=90 )
			return true;
		if( X>=97 && X<=122)
			return true;
		return false;
	}
}
