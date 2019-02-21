package lab1;
import java.util.Scanner;

public class ModifyString {
	
	public static void main(String[] args)
	{
		String phrase;
		String newPhrase;
		Scanner scan = new Scanner(System.in);

		String oldLetter;
		String newLetter = "x";
		
		System.out.println("Enter phrase: ");
		phrase = scan.nextLine();
		
		System.out.println("Enter letter: ");
		oldLetter = scan.nextLine();
		newPhrase = phrase.replace(oldLetter, newLetter);
		
		System.out.println("New phrase is: " + newPhrase);
		
		scan.close();
		
	}

}
