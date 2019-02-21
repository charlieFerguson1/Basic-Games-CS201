package lab1;
import java.util.Scanner;

public class Area {
	final static double PI = 3.14159; //constant value
	public static void main (String[] args)
	{
		double radius;
		double area;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter radius: ");
		radius = scan.nextDouble();
		
		area = PI*radius*radius;
		
		System.out.println("area of circle with radius " + radius + " is: " + area);
		
		scan.close();
	}

}


