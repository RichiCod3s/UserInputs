import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class UniqueValuesSet {

	public static void main(String[] args) {
		// Re-write the program above, this time using a collection class derived from Set (e.g. HashSet). 
		//As you will have discovered in your Research, sets handle duplicates differently from arrays, 
		//so your program's algorithm may be quite different using a set
				
		Set<Integer> uniqueValues = new TreeSet<>();

		for (int i = 0; i < 5; i++) {
			int num; //  user input 

			// take user inputs from 10 to 100 - same as previous code
			do {
				String input = JOptionPane.showInputDialog(null,"Input: Enter a number between 10 and 100");
				try {
					num = Integer.parseInt(input);
					if (num < 10 || num > 100)
						JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between 10 and 100.");
					else {
						if (!uniqueValues.contains(num)) { // needed only to show duplicate message
	                        uniqueValues.add(num); 	// add the number to set
	                        JOptionPane.showMessageDialog(null, num + " is not a duplicate");
					}//end if
						}// end else
				} catch (NumberFormatException e) { // InputMismatchException is specific for the Scanner.
					JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between 10 and 100.");
					num = 0; // ensure we can try again
				}
			} while (num < 10 || num > 100);

			// add the number to set
			
		} // end for

		// set does not allow duplicates so we can go ahead and print
		// tree-set is slower but automatically orders
		JOptionPane.showMessageDialog(null, "The unique number are " + uniqueValues);
	}// end main
}// end class
