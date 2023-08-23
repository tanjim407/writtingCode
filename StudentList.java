import java.io.*;
import java.text.DateFormat;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Random;

public class StudentList {

	public static String getLineFromFile()throws Exception{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			String line = bufferedReader.readLine();
			return line;
	}

	public static BufferedWriter getFileBufferedWriter() throws Exception {
        return new BufferedWriter(new FileWriter("students.txt", true));
    }
	
	public static void main(String[] args) {
		if (args.length != 1) {
            System.err.println("Invalid number of arguments");
            return;
        }
		// Check arguments
		else if (args[0].equals(Constants.ARG_LIST_DATA)) 
		{
			System.out.println(Constants.MSG_LOADED_DATA);
			try {				
				
				for (String j : getLineFromFile().split(Constants.WORDS_SPLIT_REGEX)) {
					System.out.println(j.trim());
		                           }
			}
			 catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		} else if (args[0].equals(Constants.ARG_SHOW_RANDOM_DATA))
		 {
			System.out.println(Constants.MSG_LOADING_DATA);
			try {
				
				
				String i[] =  getLineFromFile().split(Constants.WORDS_SPLIT_REGEX);
				System.out.println(i[new Random().nextInt(i.length)]);
			}
			 catch (Exception e) {
			}
			System.out.println(Constants.MSG_LOADED_DATA);
		}
		 else if (args[0].contains(Constants.ARG_ADD_DATA))
		  {
			System.out.println("Loading data ...");
			try {
				
				BufferedWriter bufferWritter=getFileBufferedWriter();
				String t = args[0].substring(1);
				
				String format = "dd/mm/yyyy-hh:mm:ss a";
				s.write(", " + t + "\nList last updated on " + new SimpleDateFormat(format).format(new Date()));
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