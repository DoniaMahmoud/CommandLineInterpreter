import java.io.IOException;
import java.io.*;
import java.util.*;

	public class Parser {
	
		ArrayList<String> args = new ArrayList<String>();
		String cmd;
		
		
		
		public boolean Parse(String input) throws IOException{
			String[] arrOfStr = input.split(" "); 
			for(int i=0; i<arrOfStr.length; i++) {
				for(int j=0; j<arrOfStr[i].length(); j++) {
					if(arrOfStr[i].charAt(j)=='│') {
						System.out.println("Please leave space before and after you use pipeline operator.");
						return false;
					}
				}
			}
					switch(arrOfStr[0]){
				case "cd":
					if(arrOfStr.length==2) {
						args.add(arrOfStr[1]);
						cmd = "cd";
						Terminal.cd(args);
					}
					else if(arrOfStr.length==1) {
						args.add("0");                //in case no args were sent, return the user to the current directory.
						cmd = "cd";
						Terminal.cd(args);
					}
					else {
						System.out.println("Too many arguments for cd command, cd command requires 1 or 0 arguments.");
						return false;
					}
					break;
					
					
					
			case "ls":
				if(arrOfStr.length>=2) {
					int pos = -1;
					for(int i=1; i<arrOfStr.length; i++) {
						if(arrOfStr[i].equals(">")) {
							pos=i;
							break;
						}
						
						
					}
					if(pos!=arrOfStr.length-2 && pos!=-1) {
						System.out.println("Wrong syntax. You can only redirect to one file.");
						System.out.println("1");
						return false;
					}
					
					else if(pos==-1){
						for(int i=1; i<arrOfStr.length; i++) {
							args.add(arrOfStr[i]);
							System.out.println("2");
						}
						 cmd = "ls";
						Terminal.ls(args);
					}
					
					else {
						for(int i=1; i<arrOfStr.length; i++) {
							args.add(arrOfStr[i]);
						}
						cmd = "ls";
						System.out.println("3");
						Terminal.lsRedirect_rep(args);

						
					}
				
					
				}
				else {
					args.add("0");                //in case no args were sent, list the contents of the current directory.       
					cmd = "ls";
					System.out.println("4");
					Terminal.ls(args);
				}
				break;
					
				
			case "cp":
				if(arrOfStr.length==3) {
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "cp";
				    Terminal.cp(args);
				}
				else if(arrOfStr.length>3) {
					String s = arrOfStr[arrOfStr.length-1];
					char[] chars = s.toCharArray();
					
					for (char ch : chars) {
						if(ch==('.')) {
								System.out.println("The destination must be a directory if more than one file is given to be copied.");
								return false;
							}
							else {
								
								 continue;
							}
						}
						
					
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "cp";
					Terminal.cp(args);
				}
				else {
					System.out.println("Too few arguments; cp command requires at least 2 arguments.");
					return false;
				}
				break;
					
			case "cat": 
				if(arrOfStr.length>=2) {
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "cat";
					Terminal.cat(args);
				}
				else {
					System.out.println("Too few arguments; cat command requires at least 1 argument.");
					return false;
				}
				break;
				
				
			case "more":
				if(arrOfStr.length==2) {
					args.add(arrOfStr[1]);
					cmd = "more";
					Terminal.more(args);
				}
				else {
					System.out.println("Wrong number of arguments entered, please check args/help command for more details on more command.");
					return false;
				}
				break;
					
					
			case "mkdir":
				if(arrOfStr.length>=2) {
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "mkdir";
					Terminal.mkdir(args);
				}
				else {
					System.out.println("mkdir command takes at least 1 argument.");
					return false;
				}
				break;
					
					
			case "rmdir":
				if(arrOfStr.length>=2) {
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "rmdir";
					Terminal.rmdir(args);
				}
				else {
					System.out.println("rmdir command takes at least 1 argument.");
					return false;
				}
				break;
				
					
			case "mv":
				if(arrOfStr.length==3) {
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "mv";
					Terminal.mv(args);
				}
				else if(arrOfStr.length>3) {
					String s = arrOfStr[arrOfStr.length-1];
					char[] chars = s.toCharArray();
					
					for (char ch : chars) {
						if(ch==('.')) {
								System.out.println("The destination must be a directory if more than one file is given to be copied.");
								return false;
							}
							else {
								continue;
							}
						}
					
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "mv";
					Terminal.mv(args);
				}
				else {
					System.out.println("Too few arguments; mv command requires at least 2 arguments.");
					return false;
				}
				break;
				
					
			case "rm":
				if(arrOfStr.length>=2) {
					for(int i=1; i<arrOfStr.length; i++) {
						args.add(arrOfStr[i]);
					}
					cmd = "rm";
					Terminal.rm(args);
				}
				else {
					System.out.println("Too few arguments; rm command requires at least 1 argument.");
					return false;
				}
				break;
					
					
			case "date":
				if(arrOfStr.length>1) {
					System.out.println("Too many arguments; rm command requires NO arguments.");
					return false;
				}
				else {
					cmd = "date";
					Terminal.date();
				}
			    break;
				    
				    
			case "pwd":
				if(arrOfStr.length>1) {
					System.out.println("Too many arguments; pwd command requires NO arguments.");
					return false;
				}
				else {
					cmd = "pwd";
					Terminal.pwd();
				}
			    break;
				
					
			case "help":
				if(arrOfStr.length>1) {
					System.out.println("Too many arguments; help command requires NO arguments.");
					return false;
				}
				else {
					cmd = "help";
					Terminal.help();
				}
			    break;
				    
				    
			case "args":
				if(arrOfStr.length==2) {
					args.add(arrOfStr[1]);
					cmd="args";
					Terminal.args(args);
				}
				else {
					System.out.println("Wrong number of arguments; args command requires 1 argument.");
					return false;
				}
			    break;
				    
				    
			case "clear":
				if(arrOfStr.length>1) {
					System.out.println("Too many arguments; clear command requires NO arguments.");
					return false;
				}
				else {
					cmd = "clear";
					Terminal.clear();
				}
			    break;
				    
				    
			case "exit":
				cmd = "exit";
				Terminal.exit();
				break;
				  
					
			 default: 
	             System.out.print("Misspelled command "); 
	             System.out.print(arrOfStr[0]);
	             System.out.println(" Please type 'args' command to see the right syntax for each command and its arguments.");
			}
				
return true;
}
				
			
			
			
	
		public String getCmd(){
			return cmd;
		}
		
		public ArrayList<String> getArguments() {
			return args;
		}
	
			
			
			
			
			
			
		}
	
	
