import java.io.IOException;
import java.util.Scanner;
import java.io.*;


public class Main {
	public static void main(String args[]) throws IOException{
		Scanner scanner = new Scanner(System.in);
		String choice="";
		while(choice!="exit") {
			System.out.println("Enter your command: ");
			String userInput = scanner.nextLine();
			choice = userInput;
			String [] splittedPipe = userInput.split("│ ");
			Parser p = new Parser();
			for(int i=0; i<splittedPipe.length; i++) {
				p.Parse(splittedPipe[i]);
			}
			
			}
			
		
	 }
	
		
			
}
		

	
	
	

