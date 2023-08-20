import javax.swing.JOptionPane;

public class UniqueValues {
	/*
	 * Use a 1-D array to solve the following problem: Write an application that asks the user to input five numbers, 
	 * each between 10 and 100 (inclusive). As each number is read, display it only if it is not a duplicate of a number
	 * already read. Provide for the "worst case” in which all five numbers are different. Use the smallest possible array 
	 * to solve this problem. Display the complete set of unique values input after the user inputs each new value.
	 */
	 public static void main(String[] args) {
		 
			int[] tempArray = new int[5]; // temporary array of size 5 
			boolean duplicate; // is the input a duplicate?
			int arrayCount = 0; // count for array -  "Use the smallest possible array to solve this problem"

			for (int i = 0; i < tempArray.length; i++) {
				
				duplicate = false;
				int num;
				
				// take user inputs from 10 to 100
				do {
					String input = JOptionPane.showInputDialog(null, "Input: Enter a number between 10 and 100");
					try {
					num = Integer.parseInt(input);
					if (num < 10 || num > 100) 
						JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between 10 and 100.");
					}catch(NumberFormatException e) { //InputMismatchException is specific for the Scanner. 
						JOptionPane.showMessageDialog(null, "Invalid input. Enter a number between 10 and 100.");
						num = 0; // ensure we can try again
					}
				} while (num < 10 || num > 100);
				
				
				// find if input is a duplicate
				for(int j=0; j < tempArray.length; j++) {
					
					if(tempArray[j] == num) {
						duplicate = true;
					}		
				}
				
			
				// if it is not a duplicate, add to tempArray
				if(duplicate == false) {
					JOptionPane.showMessageDialog(null, num + " is not a duplicate");
						tempArray[i] = num;
						arrayCount++;
				}								
			}// end for
			
			// create final array for unique inputs 
			int[] numbers = new int [arrayCount];
			int counter = 0; // counter for moving numbers to array
			
			// move unique numbers from tempArray to numbers array
			for(int i = 0; i < tempArray.length; i++) {
				if(tempArray[i] >9) { // this could have been >0 as the tempArray[i] holds 0 when there was a duplicate
					numbers[counter] = tempArray[i];
					counter++; // 
				}
			}
			
			// delete the tempArray
			tempArray = null; 
			
			
			// create a string that shows all the unique numbers
			String uniqueValues = "The unique values are: ";
	        for (int i = 0; i < arrayCount; i++) {
	            uniqueValues += numbers[i] + " ";
	        }
	        
	        // display non duplicate values
	        JOptionPane.showMessageDialog(null, uniqueValues);
	        	

		}// end main
	} //end class
