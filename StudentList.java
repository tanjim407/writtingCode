import java.io.*;
import java.util.Arrays;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;

public class StudentList {

	

//Refactoring duplicate file and call getLineFromFile function for getting data
	public static String getLineFromFile()throws Exception{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String line = bufferedReader.readLine();
			return line;
	}

	public static BufferedWriter getFileBufferedWriter() throws Exception {
        return new BufferedWriter(new FileWriter("students.txt", true));
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// number of arg is invaild
		if (args.length != 1) {
            System.err.println("Invalid number of arguments");
            return;
        }
		// Check arguments
		else if (args[0].equals(Constants.ARG_LIST_DATA)) 
		{
			System.out.println(Constants.MSG_LOADED_DATA);
			try {				
				//printing student name
				for (String j : getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)) {
					System.out.println(j.trim());
		                           }
			}
			 catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
			//check arg r
		} else if (args[0].equals(Constants.ARG_SHOW_RANDOM_DATA))
		 {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				
				//print a random data
				String i[] =  getLineFromFile().split(Constants.WORDS_SPLIT_REGEX);
				System.out.println(i[new Random().nextInt(i.length)]);
			}
			 catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		//check arg '+'
		 else if (args[0].contains(Constants.ARG_ADD_DATA))
		  {
			System.out.println("Loading data ...");
			try {
				
				
				String t = args[0].substring(1);
				
				String format = "dd/mm/yyyy-hh:mm:ss a";

				String str = ", " + t + "\nList last updated on " + new SimpleDateFormat(format).format(new Date());
				s.write(str);
				s.close();
			} 
			catch (Exception e) {
			}

			System.out.println("Data Loaded.");
		}
		 else if (args[0].contains(Constants.ARG_FIND_DATA)) 
		 {
			System.out.println("Loading data ...");
			try {
				//listing data in array and check for finding data in substring			 	
		         if (Arrays.asList(getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)).contains(args[0].substring(1))) {
                    System.out.println(Constants.MSG_DATA_FOUND);
                } else {
                    System.out.println(Constants.MSG_DATA_NOT_FOUND);
					}
				}
			
			 catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} 
		else if (args[0].contains("c"))
		 {
			System.out.println("Loading data ...");
			try {
				
				
				//counting number of string and words.  
				System.out.println(getLineFromFile().split(Constants.WORDS_SPLIT_REGEX).length/2 + " word(s) found " + Constants.MSG_WORDS_FOUND);

			} 
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}

		else{
			 
				System.err.println("invaild arg");
				System.exit(2);
		}
	}
}