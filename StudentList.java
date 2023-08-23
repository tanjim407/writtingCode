import java.io.*;
import java.text.DateFormat;
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
		if (args[0].equals("a")) 
		{
			System.out.println("Loading data ...");
			try {				
				
				for (String j : getLineFromFile().split(", ")) {
					System.out.println(j.trim());
		                           }
			}
			 catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		} else if (args[0].equals("r"))
		 {
			System.out.println("Loading data ...");
			try {
				
				
				String i[] =  getLineFromFile().split(", ");
				System.out.println(i[new Random().nextInt(i.length)]);
			}
			 catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
		 else if (args[0].contains("+"))
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
		 else if (args[0].contains("?")) 
		 {
			System.out.println("Loading data ...");
			try {
				
				
				String i[] = getLineFromFile().split(", ");
				boolean done = false;
				String t = args[0].substring(1);
				for (int idx = 0; idx < i.length && !done; idx++) {
					if (i[idx].equals(t)) {
						System.out.println("We found it!");
						done = true;
					}
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
				
				boolean in_word = false;
				int count = 0;
				for (char c : getLineFromFile().toCharArray()) {
					if (c == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						} else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(s) found " + a.length);
			} 
			catch (Exception e) {
			}
			System.out.println("Data Loaded.");
		}
	}
}