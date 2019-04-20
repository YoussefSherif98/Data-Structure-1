package eg.edu.alexu.csd.datastructure.linkedList.cs29_cs79;

import java.awt.Point;

public class PolynomialSolver implements IPolynomialSolver {

		public static MyLinkedList_Single A = new MyLinkedList_Single();
		public static MyLinkedList_Single B = new MyLinkedList_Single();
		public static MyLinkedList_Single C = new MyLinkedList_Single();
		public static MyLinkedList_Single R = new MyLinkedList_Single();

		public static MyLinkedList_Single[] Polys = new MyLinkedList_Single[4];{
			Polys[0] = A ;
			Polys[1] = B ;
			Polys[2] = C ;
			Polys[3] = R ;
		}
		
		
		
		public void setPolynomial(char poly, int[][] terms) {

			int active=charToNum(poly);
			if(active==-1)
				return ;
			
			Polys[active]=addSorted(Polys[active],terms);
		}

		
		public String print(char poly) {
			int active= charToNum(poly);
			if (active == -1) {
				return null;
			}
			if (Polys[active].size() == 0) {
				return null;
			}
			String s;
			Point p = new Point();
			int a = Polys[active].size();
			p=(Point)Polys[active].get(0);
			s=String.valueOf(p.x)+"x^"+String.valueOf(p.y);
			for  (int i =1;i<a;i++) {
				p=(Point)Polys[active].get(i);
				if (p.x > 0) {
					s+="+"+String.valueOf(p.x)+"x^"+String.valueOf(p.y);
				}
				else {
					s+=String.valueOf(p.x)+"x^"+String.valueOf(p.y);
				}
			}
			return s;
		}
		public void clearPolynomial(char poly) {
			int active = charToNum(poly);
			Polys[active].clear();
			return;
		}

		public float evaluatePolynomial (char poly, float value) {
	        
			int active=charToNum(poly);
			if(active==-1)
				return 0;
			
			float result=0;
			for(int i=0;i<Polys[active].size();i++)
			{
				Point term = new Point((Point)Polys[active].get(i));
				result+= term.x*Math.pow(value, term.y);
			}
			
			return result;
		}

		
		public int[][] add(char poly1, char poly2) {
			
			int active1=charToNum(poly1),active2=charToNum(poly2);
			if( active1==-1 || active2==-1 )
				return null;
			
			MyLinkedList_Single tempResults = new MyLinkedList_Single();
			int count=0;
			
			MyLinkedList_Single sub1 = new MyLinkedList_Single();
			sub1=(MyLinkedList_Single) Polys[active1].sublist(0,Polys[active1].size()-1);
			
			MyLinkedList_Single sub2 = new MyLinkedList_Single();
			sub2=(MyLinkedList_Single) Polys[active2].sublist(0,Polys[active2].size()-1);
			
			int i,j;
			for(i=0;i<sub1.size();i++)
			{
				Point p1 = new Point((Point)sub1.get(i));
				for(j=0;j<sub2.size();j++)
				{
					Point p2 = new Point((Point)sub2.get(j));
					if(p1.y==p2.y)
					{
						int temp[][] = new int[1][2];
						temp[0][0] = p1.x+p2.x;
						temp[0][1] = p1.y;
						tempResults=addSorted(tempResults,temp);
						sub1.remove(i);
						sub2.remove(j);
						i--;
						j--;
						count++;
						break;
					}
				}
				if(j==sub2.size())
				{
					int temp[][] = new int[1][2];
					temp[0][0] = p1.x;
					temp[0][1] = p1.y;
					tempResults = addSorted(tempResults,temp);
					sub1.remove(i);
					i--;
					count++;
				}
			}
			for(j=0;j<sub2.size();j++)
			{
				Point p2 = new Point((Point)sub2.get(j));
				int temp[][] = new int[1][2];
				temp[0][0] = p2.x;
				temp[0][1] = p2.y;
				tempResults = addSorted(tempResults,temp);
				sub2.remove(j);
				j--;
				count++;
			}
			
			int results[][] = new int[count][2];
			
			for(i=0;i<count;i++)
			{
				results[i][0]=((Point)tempResults.get(i)).x;
				results[i][1]=((Point)tempResults.get(i)).y;
			}
			
			
			return results;
		}
		public int[][] subtract(char poly1, char poly2) {

			int active1=charToNum(poly1),active2=charToNum(poly2);
			if( active1==-1 || active2==-1 )
				return null;
			
			MyLinkedList_Single tempResults = new MyLinkedList_Single();
			int count=0;
			
			MyLinkedList_Single sub1 = new MyLinkedList_Single();
			sub1=(MyLinkedList_Single) Polys[active1].sublist(0,Polys[active1].size()-1);
			
			MyLinkedList_Single sub2 = new MyLinkedList_Single();
			sub2=(MyLinkedList_Single) Polys[active2].sublist(0,Polys[active2].size()-1);
			
			int i,j;
			for(i=0;i<sub1.size();i++)
			{
				Point p1 = new Point((Point)sub1.get(i));
				for(j=0;j<sub2.size();j++)
				{
					Point p2 = new Point((Point)sub2.get(j));
					if(p1.y==p2.y)
					{
						int temp[][] = new int[1][2];
						temp[0][0] = p1.x-p2.x;
						temp[0][1] = p1.y;
						tempResults=addSorted(tempResults,temp);
						sub1.remove(i);
						sub2.remove(j);
						i--;
						j--;
						count++;
						break;
					}
				}
				if(j==sub2.size())
				{
					int temp[][] = new int[1][2];
					temp[0][0] = p1.x;
					temp[0][1] = p1.y;
					tempResults = addSorted(tempResults,temp);
					sub1.remove(i);
					i--;
					count++;
				}
			}
			for(j=0;j<sub2.size();j++)
			{
				Point p2 = new Point((Point)sub2.get(j));
				int temp[][] = new int[1][2];
				temp[0][0] = -p2.x;
				temp[0][1] = p2.y;
				tempResults = addSorted(tempResults,temp);
				sub2.remove(j);
				j--;
				count++;
			}
			
			int results[][] = new int[count][2];
			
			for(i=0;i<count;i++)
			{
				results[i][0]=((Point)tempResults.get(i)).x;
				results[i][1]=((Point)tempResults.get(i)).y;
			}
			
			
			return results;
		}

		
		public int[][] multiply(char poly1, char poly2) {
			int active1 = charToNum(poly1);
			int active2 = charToNum(poly2);
			
			int count=0;
			MyLinkedList_Single Temp = new MyLinkedList_Single();
			
			for(int i=0;i<Polys[active1].size();i++)
			{
				for(int j=0;j<Polys[active2].size();j++)
				{
					Point p = new Point();
					p.x= ((Point)Polys[active1].get(i)).x *((Point)Polys[active2].get(j)).x;
					p.y= ((Point)Polys[active1].get(i)).y +((Point)Polys[active2].get(j)).y;
					
					boolean flag = false;
					int index=0;
					for(int k=0;k<count;k++)
					{
						if (((Point)Temp.get(k)).y==p.y)
						{
							flag=true;
							index=k;
							p.x+=((Point)Temp.get(k)).x;
						}
					}
					
					if(flag==true)
					{
						Temp.set(index, p);
					}
					else
					{
						int [][] term = new int[1][2];
						term[0][0] = p.x;
						term[0][1] = p.y;
						Temp=addSorted(Temp,term);
						count++;
					}
				}
			}
			
            int results[][] = new int[count][2];
			
			for(int i=0;i<count;i++)
			{
				results[i][0]=((Point)Temp.get(i)).x;
				results[i][1]=((Point)Temp.get(i)).y;
			}
			
			return results;
			
		}
		
		private int charToNum(char poly)
		{
			int active;
			switch(poly) {
			case 'A':
				active=0;
				break;
			case 'B':
				active=1;
				break;
			case 'C' :
				active=2;
				break;
			case 'R' :
				active=3;
				break;	
				default :
					System.out.println("Incorrect letter");
					return -1;
			}
			return active;
		}

		private MyLinkedList_Single addSorted(MyLinkedList_Single list, int[][] terms)
		{
			for(int i=0;i<terms.length;i++)
			{
				Point term = new Point();
				term.x=terms[i][0];
				term.y=terms[i][1];
				if(list.isEmpty())
					list.add(term);
				else
				{
					int pos=0;
					Node_S n = list.head;
					while(n!=null && term.y < ((Point)(n.value)).y )
					{
						n=n.next;
						pos++;
					}
					list.add(pos,term);
					
				}
			}
			return list;
		}


	}

