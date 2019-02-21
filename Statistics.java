import java.util.Scanner;

public class Statistics {
	public static int numInts;
	public static int[] numbers;
	static Scanner scan = new Scanner(System.in);

	/*
	 * Main: calls the methods and runs the program. The array "numbers" is gotten
	 * from the method "userInput()"
	 */
	public static void main(String[] args) {
		numbers = getUserInput();
		// printArray();
		analyzeUserChoice();
		scan.close();
	}

	/*
	 * getUserInput: Prompts user and gets length of array. Sets the array length
	 * and then prompts the user to populate the array. then it returns this array.
	 */
	public static int[] getUserInput() {
		System.out.println("How many ints would you like to implement?");
		numInts = scan.nextInt();
		int numbers[] = new int[numInts];

		if (numInts <= 0) // an array of length 0 or less would lead to null pointer errors and so this
							// makes those inputs invalid
		{
			System.out.println("You entered an invalid " + "number of intigers for the array, "
					+ "Please choose a number greater than 0.");
			getUserInput(); // when an invalid input is placed by a user, getUserInput is recursively
							// called.
		} 
		else 
		{
			for (int i = 0; i < numInts; i++) 
			{
				System.out.println("Enter int " + (i + 1));
				numbers[i] = scan.nextInt();
			}
		}
		return numbers;
	}

	/*
	 * printArray: this method returns nothing, but prints the full array out with
	 * its values. Used for debugging.
	 */
	public static void printArray() {
		for (int i = 0; i < numInts; i++) {
			System.out.println("element in position " + i + "is" + numbers[i]);
		}
	}

	/*
	 * giveUserOption: gives the user an option of statistics and returns the choice
	 * made.
	 */
	public static int giveUserOptions() {
		int choice = 0;
		if (numInts > 0) {
			// program will quit if this is not updated
			System.out.println("Please choose a desired statistic: " + "\n (1) average" + " \n (2) maximum"
					+ "\n (3) minimum" + "\n (4) range" + "\n (5) mode" + "\n (0) quit");
			choice = scan.nextInt();
		}
		return choice;

	}

	/*
	 * analyzeUserChoice: this is where the user's input is taken into account, and
	 * then the corresponding method is called. there is no return for this method
	 */
	public static void analyzeUserChoice() {
		int choice = giveUserOptions();
		if (choice == 0) 
		{
			System.out.println("Goodbye!");
		} 
		else if (choice == 1) 
		{
			double avg = getAverage();
			System.out.println("The average is: " + avg);
			analyzeUserChoice();
		} 
		else if (choice == 2) 
		{
			int max = getMax();
			System.out.println("The maximum value is: " + max);
			analyzeUserChoice();
		} 
		else if (choice == 3)
		{
			int min = getMin();
			System.out.println("The minimum value is: " + min);
			analyzeUserChoice();
		} 
		else if (choice == 4) 
		{
			int range = getRange();
			System.out.println("The range is: " + range);
			analyzeUserChoice();
		} 
		else if (choice == 5) 
		{
			int mode = getMax();
			System.out.println("The mode is: " + mode);
			analyzeUserChoice();
		} 
		else // if the user inputs an invalid number, the method analyzeUserChoice calls upon
				// itself and the user is prompted again to choose a method
		{
			System.out.println("Invalid command. Please choose a valid command");
			analyzeUserChoice();
		}

	}

	/*
	 * getSum: gets sum of the array. Returns an int.
	 */
	public static int getSum() {
		int sum = 0;
		for (int i = 0; i < numInts; i++) {
			sum = numbers[i] + sum;
		}
		return sum;
	}

	/*
	 * getAverage: scans the array and produces the average of the elements. Returns
	 * a double
	 */
	public static double getAverage() {
		double average = 0;
		double sum = getSum();
		average = sum / numInts;
		return average;
	}

	/*
	 * getMax: returns the maximum value of the elements in the array. The for loop
	 * starts at 1 because the max value is set to the first element in the array
	 */
	public static int getMax() {
		int max = numbers[0];
		for (int i = 1; i < numInts; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}
		return max;
	}

	/*
	 * getMin: scans through the array and holds the lowest value in a variable
	 * called min. The for loop starts at 1 because the min value is set to the
	 * first element in the array.
	 */
	public static int getMin() {
		int min = numbers[0];
		for (int i = 1; i < numInts; i++) {
			if (min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	}

	/*
	 * getRange: uses getMin and getMax to calculate and return the range
	 */
	public static int getRange() {
		int min = getMin();
		int max = getMax();
		int range = max - min;
		return range;
	}

	/*
	 * getMode: computes and returns the mode of a set of positive integers (i.e.
	 * the integer that appears most frequently). If there is a tie (or no integer
	 * appears more than once), If there are multiple numbers tied in number of
	 * occurrences then first number to the most occurrences is returned.
	 * 
	 * The two for loops used scan the array together to efficiently compare all of
	 * the values. For instance, if there are 5 elements in an array, the outer for
	 * loop would start at array[0], then the inner for loop scans the remaining
	 * four elements in the array. The outer loop then increments to the next
	 * element and the inner loop would then scan the remaining three elements and
	 * so on. The variable modeVal is the value of the most occurring element.
	 * modeCount keeps track of how many times the most occurring element has
	 * occurred. modeCount is only increased when internalModeCount is greater than
	 * it. this is checked in the second if statement inside of the inner for loop.
	 * If modeCount is updated, then modeVal is also updated. finally the modeVal is
	 * returned.
	 * 
	 */
	public static int getMode() {
		int modeVal = numbers[0];
		int modeCount = 1; // holds the number of instances of the most occurred element
		for (int i = 0; i < numInts - 1; i++) // increments up the value if i
		{
			for (int j = i + 1; j < numInts; i++) // i is at a value, and j is incremented up
			{
				int internalModeCount = 1; // counts the number of instances an i is equal to j
				if (i == j) {
					internalModeCount++;
				}
				if (internalModeCount > modeCount) {
					modeCount = internalModeCount;
					modeVal = numbers[i];
				}
			}
		}
		return modeVal;
	}

}
