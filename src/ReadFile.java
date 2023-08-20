import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ReadFile {
		
		public static void main(String[] args)
		{
		String inName = JOptionPane.showInputDialog("Enter input file name");
		//String outName = JOptionPane.showInputDialog("Enter output file name");
		
		int linecount = 0; 
		int charCount = 0;
	
		
		// Open the input file 
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inName));
			String line;
			while((line = reader.readLine()) != null) { // while there are lines, read lines
				JOptionPane.showMessageDialog(null, line); // prints out the line in the file -  not needed but good practice
				linecount++; // counts lines
				charCount += line.length(); // counts chars by giving the length of string
			}
			reader.close(); // close file
		}catch(FileNotFoundException f) {
			JOptionPane.showMessageDialog(null, "The file to be opened does not exist. Details: \n"+ f);
					System.exit(0);
					f.printStackTrace(); // trace exception to system.err - good practice
		} catch (IOException e) { // used parent exception 
			JOptionPane.showMessageDialog(null, "Error while reading file. Details: \n" + e);
			System.exit(0);
			e.printStackTrace();
		}
		
		JOptionPane.showMessageDialog(null, "The number of lines in the text file is: " + linecount + 
				"\n The number characters in the file is: " + charCount);	

	}// end main

}// end class
