package eg.edu.alexu.csd.datastructure.iceHockey.cs79;

import java.awt.Point;
import java.util.Vector;

public class PlayersFinder implements IPlayersFinder{
	
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		
		int ny =photo.length;
		int nx =photo[0].length();
		
		char[][] newphoto = new char[ny][nx];
		
		/*Converting the string array into a 2D char array*/
		for(int i=0;i<ny;i++)
		{
			for(int j=0;j<nx;j++)
			{
				newphoto[i][j] = photo[i].charAt(j);
			}
		}
		
		
		
		int[][] objectNumber = new int [ny][nx];
		int num=0;
		
		
		/*Converting the photo into a group of objects having the same number*/
		for(int i=0;i<ny;i++)
		{
			for (int j=0;j<nx;j++)
			{
				if((int)newphoto[i][j]-48== team && objectNumber[i][j]==0)
				{
					num++;
					objectNumber=searchandUpdate(newphoto,team,num,objectNumber,i,j,nx,ny);
				}
			}
		}
		
		
		
		
		Vector v = new Vector();
		
		
		
		/*Counting the number of objects whose areas are larger than the threshold*/
		int validObjectsNumber=0;
		for(int k=1;k<=num;k++)
		{
			int count=0;
			for(int i=0;i<ny;i++)
			{
				for(int j=0;j<nx;j++)
				{
					if(objectNumber[i][j]==k)
						count++;
				}
			}
			if(4*count>=threshold)
			{
				v.add(validObjectsNumber,findCenter(k,objectNumber,nx,ny));
				validObjectsNumber++;
				
			}

		}
		
		Point[] positions = new Point[validObjectsNumber];
		
		
		/*Copying the points and sorting them */
		for(int i=0;i<validObjectsNumber;i++)
			positions[i] = new Point((Point)v.get(i));
		positions = sort(positions,validObjectsNumber);
		
		
		
		return positions;
	}
	
	private int[][] searchandUpdate(char[][] photo,int team, int num, int[][] objectNumber, int i, int j, int nx, int ny)
	{
		if(i>=0 && i<ny && j>=0 && j<nx && objectNumber[i][j]==0 && (int)photo[i][j]-48==team)
		{
			objectNumber[i][j] = num;
			objectNumber=searchandUpdate(photo,team,num,objectNumber, i+1 , j ,nx,ny);
			objectNumber=searchandUpdate(photo,team,num,objectNumber, i , j+1 ,nx,ny);
			objectNumber=searchandUpdate(photo,team,num,objectNumber, i-1 , j ,nx,ny);
			objectNumber=searchandUpdate(photo,team,num,objectNumber, i , j-1 ,nx,ny);
		}
		return objectNumber;
	}
	
	private Point findCenter(int num, int[][] objectNumber,int nx, int ny)
	{
		int smallestx=nx-1 , smallesty=ny-1 , largestx=0 , largesty=0;
		for(int i=0;i<ny;i++)
		{
			for(int j=0;j<nx;j++)
				if(objectNumber[i][j]==num)
				{
					if(i>largesty)
						largesty=i;
					if(i<smallesty)
						smallesty=i;
					
					if(j>largestx)
						largestx=j;
					if(j<smallestx)
						smallestx=j;
				}
		}
		
		
		Point p = new Point( smallestx+largestx+1   , smallesty+largesty+1 );
		
		return p;
		
		
	}

	private Point[] sort(Point[] positions, int n)
	{
		for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (positions[j].x > positions[j+1].x) 
                { 
                    
                    Point temp = positions[j]; 
                    positions[j] = positions[j+1]; 
                    positions[j+1] = temp; 
                } 
		for (int k=0;k<n-1;k++)
		{
			if(positions[k].x==positions[k+1].x)
			{
				int dup=positions[k].x;
				
				for (int i = 0; i < n-1-k; i++) 
		            for (int j = k; j < n-i-1; j++) 
		                if (positions[j].x ==dup && positions[j+1].x==dup && positions[j].y > positions[j+1].y) 
		                { 
		                    
		                    Point temp = positions[j]; 
		                    positions[j] = positions[j+1]; 
		                    positions[j+1] = temp; 
		                } 
			}
		}
		
		return positions;
	}

}
