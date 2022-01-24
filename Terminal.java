import java.util.*;
import java.io.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.IOException; 
import java.nio.file.*; 
  

public class Terminal {
	
	public static String DefaultPath ="D:\\1st TERM Year(3)\\Operating Systems\\Labs";
	private static PrintStream outputStream = System.out;
	static File src= new File ("C:\\Users\\Youss\\Desktop\\wara2\\reen.txt");
	static File dest= new File ("C:\\Users\\Youss\\Desktop\\Assignment(1)OS");
	
	public static void exit() {
		System.out.println("Process Terminated Successfully.");
		System.exit(0);
	}
	
	public static void date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
	}
	
	public static void help() {
		System.out.println("args : List all command arguments");
		System.out.println("date :  Current date/time");
		System.out.println("exit  : Stop all ");
	}
	
	public static void args(ArrayList<String> arg) {
		String r = arg.get(0);
		switch(r) {
		case "cd":
			System.out.println("Arg1: Destination Path.");
			System.out.println("NoArg: Default Path.");
			break;
			
		case "pwd":
			System.out.println("NoArg: Prints Working Directory.");
			break;
			
		case "ls":
			System.out.println("Arg1: Source Path.");
			System.out.println("ManyArgs: Source Paths appended.");
			break;
			
		case "cp":
			System.out.println("Arg1: Source Path , Arg2: Destination Path.");
			System.out.println("Arg1: Source Path , Arg2: Source Path , Arg3: Destination Directory Path.");
			System.out.println("Arg1: Source Path , Arg2: Source Path , Arg3: Source Path , ......, Arg(i): Destination Directory Path.");
			break;
			
		case "cat":
			System.out.println("Arg1: Source Path.");
			System.out.println("Arg1: Source Path , Arg2: Source Path , Arg3: Source Path , ......, Arg(i): Source Path.");
			break;
		
		case "more":
			System.out.println("Arg1: Source Path.");
			break;
			
		case "mkdir":
			System.out.println("Arg1: Directory Path to be created.");
			System.out.println("Arg1: Directory Path to be created , Arg2: Directory Path to be created , Arg3: Directory Path to be created , ......, Arg(i): Directory Path to be created.");
			break;
			
		case "rmdir":
			System.out.println("Arg1: Directory Path to be removed.");
			System.out.println("Arg1: Directory Path to be removed , Arg2: Directory Path to be removed , Arg3: Directory Path to be removed , ......, Arg(i): Directory Path to be removed.");
			break;
		
		case "mv":
			System.out.println("Arg1: Source Path , Arg2: Destination Path.");
			System.out.println("Arg1: Source Path , Arg2: Source Path , Arg3: Destination Directory Path.");
			System.out.println("Arg1: Source Path , Arg2: Source Path , Arg3: Source Path , ......, Arg(i): Destination Directory Path.");
			break;
		
		case "rm":
			System.out.println("Arg1: Source Directory/File Path");
			System.out.println("Arg1: Source Directory/File Path , Arg2: Source Directory/File Path , Arg3: Source Directory/File Path ,....., Arg(i): Source Directory/File Path");
			break;
		
		case "clear":
			System.out.println("NoArgs: Clear Terminal.");
			break;
		}
	}
	
	
	public static void clear() {
		for(int i = 0;i < 100000;i++){
            outputStream.println();
        }
	}
	
	
	public static void pwd()
    {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        
    }
	
	
	
	public static void cd(ArrayList<String> arg) {
		String d = arg.get(0);
		if(d=="0") {
			System.setProperty( "user.dir", DefaultPath);
		}
		else {
			System.setProperty( "user.dir", d);
		}
	}
	

	public static String ls(ArrayList<String> args){
		String d= args.get(0);
		if(d=="0") {
			File dir = new File(System.getProperty("user.dir"));
		 	String[] childs = dir.list();
            for( String child: childs){
                 System.out.println(child);
            }
		}
		
		else {
			String current = System.getProperty("user.dir");
			ArrayList<String> temp = new ArrayList<String>( Arrays.asList(current) ); 
			for(int i=0; i<args.size(); i++) {
				cd(args);
				File file;
				file = new File(args.get(i));
				File[] filesList = file.listFiles();
	            for(File f : filesList){
	            	if (f.isDirectory()) {
	    				System.out.print("--Directory: ");
	    			} else {
	    				System.out.print("--File: ");
	    			}
	            	System.out.println(f.getName());
	        }
		}
		
		cd(temp);
		}
		
	
	
	

return "End Of Display";
	}
	
	public static void lsRedirect_rep(ArrayList<String> args){
		String d = args.get(args.size()-1);
		String current1 = System.getProperty("user.dir");
		ArrayList<String> temp = new ArrayList<String>( Arrays.asList(current1) ); 
		//String fileFullPath = null;
		 int pos = -1;
		 for(int i=0; i<d.length(); i++) {
			 if(d.charAt(i)==':') {
				String fileFullPath = (args.get(args.size()-1)); 
				 pos = i;
				if(args.get(0).equals(">")) {
					File dir = new File(System.getProperty("user.dir"));
				 	String[] childs = dir.list();
				 	try{    
				 		FileWriter fw=new FileWriter(fileFullPath);       
				          //catch(Exception e){System.out.println(e);}    
		            for( String child: childs){
		            	fw.write(child);  	
		            	fw.write("\n");
				}
		            fw.close();
				 	}
		            catch(Exception e){System.out.println(e);}    
		            break;
				 	}
				
				else {
					
					for(int j=0; j<args.size(); j++) {
						if(args.get(j)==">") {
							break;
					}
						else {
							cd(args);
							File file;
							file = new File(args.get(j));
							File[] filesList = file.listFiles();
							try{    
						 		FileWriter fw=new FileWriter(fileFullPath);       
						          //catch(Exception e){System.out.println(e);} 
				            for(File f : filesList){
				            	fw.write(f.getName());
				            	fw.write("\n");
				            	System.out.println(f.getName());
				        }
				            fw.close();
						 	}
				           catch(Exception e){System.out.println(e);}    

						}
											
			 
			 
		 }
				}

			
		 }
			 else {
				 continue;
			 }
			 
			 }
		 
		 if(pos==-1) {
			String current = System.getProperty("user.dir"); 
			 String s3=current.concat("\\"); 
			 String fileFullPath= s3.concat(args.get(args.size()-1));
			 if(args.get(0).equals(">")) {
					File dir = new File(System.getProperty("user.dir"));
				 	String[] childs = dir.list();
				 	try{    
				 		FileWriter fw=new FileWriter(fileFullPath);       
				          //catch(Exception e){System.out.println(e);}    
		            for( String child: childs){
		            	fw.write(child);  	
		            	fw.write("\n");
				}
		            fw.close();
				 	}
		            catch(Exception e){System.out.println(e);}
			 }
			 else {
				 for(int i=0; i<args.size(); i++) {
						if(args.get(i)==">") {
							break;
					}
					else {
						 cd(args);
							File file;
							file = new File(args.get(i));
							File[] filesList = file.listFiles();
							try{    
						 		FileWriter fw=new FileWriter(fileFullPath);       
						          //catch(Exception e){System.out.println(e);} 
				            for(File f : filesList) {
				            	fw.write(f.getName());
				            	fw.write("\n");
				            	System.out.println(f.getName());
				        }
				            fw.close();
						 	}
				           catch(Exception e){System.out.println(e);}    
					}
					 

				 }
			 }
			
		
	}
		 cd(temp);
	}

	
	
	public static void mkdir(ArrayList<String> args) {
	
		for(int i=0; i<args.size(); i++) {
			new File(args.get(i)).mkdir();
		}
        
        
}
	
	
	public static void rmdir(ArrayList<String> args){
		for(int i=0; i<args.size(); i++) {
		File f = new File(args.get(i));
		if(f.isDirectory() && f.exists()) {
			f.delete();
		}
		else {
			System.out.println("Please make sure you are entering a directory path and this directory exists.");
		}
	}
   
}
	
	
	
	
	
	public static void rm(ArrayList<String> args) {
		File file = null;
		String finalPath= null;
		for(int i=0; i<args.size(); i++) {
			 String d = args.get(i);
			 int pos = -1;
			 for(int j=0; j<d.length(); j++) {
				 if(d.charAt(j)==':') {
					 pos=i;
					 finalPath=args.get(i);
					 break;
				 }
				 else {
					 continue;
				 }
			 }
			 if(pos==-1) {
				 String current = System.getProperty("user.dir"); 
				 String s3=current.concat("\\"); 
				 finalPath=s3.concat(args.get(i));
			 }
		  file = new File(finalPath);
          file.delete();
		
		}
	}
	
	public static void mv(ArrayList<String> args) throws IOException,NoSuchFileException {
		for(int i=0; i<args.size(); i++) {
			 File file1=new File (args.get(i));
		     file1.renameTo(new File(args.get(args.size()-1)));
		     src = new File(args.get(i));
			 dest=new File(args.get(args.size()-1));
			 
			 /*
			 if(args.size()==2 && !dest.isDirectory()) {
				 File file3=new File (args.get(i));
			     file3.renameTo(new File(args.get(args.size()-1)));
			     
			     if(!src.exists())
				     throw new NoSuchFileException(src.getAbsolutePath(),null,"does not exist");
				 else if(!dest.exists())
				       throw new NoSuchFileException(dest.getAbsolutePath(),null,"does not exist");
					 else
					 Files.move(src.toPath(),dest.toPath().resolve(src.toPath().getFileName()),StandardCopyOption.REPLACE_EXISTING);
					 
			 }
			 
			 
			*/
			 
			 
			  if(args.size()>=2 && dest.isDirectory() )  { // moves multiple files to directory
					for(int j=0; j<args.size(); j++) {
					src = new File(args.get(j));
					dest=new File(args.get(args.size()-1));
					if(!src.exists())
					     throw new NoSuchFileException(src.getAbsolutePath(),null,"does not exist");
					 //else if(!dest.exists())
					   //    throw new NoSuchFileException(dest.getAbsolutePath(),null,"does not exist");
						 else
						 Files.move(src.toPath(),dest.toPath().resolve(src.toPath().getFileName()),StandardCopyOption.REPLACE_EXISTING);
						 
					}
					
			 }
			
			 
			}
		
		}
	
	
	
	
	
	 public static void cat(ArrayList<String> args) throws IOException {
		 BufferedReader buf = null;
		 String finalPath = null;
		 int pos = -1;
		 for(int i=0; i<args.size(); i++) {
			 String d = args.get(i);
			 for(int j=0; j<d.length(); j++) {
				 if(d.charAt(j)==':') {
					 pos=i;
					 finalPath=args.get(i);
					 break;
				 }
				 else {
					 continue;
				 }
			 }
			 if(pos==-1) {
				 String current = System.getProperty("user.dir"); 
				 String s3=current.concat("\\"); 
				 finalPath=s3.concat(args.get(i));
			 }
			 
			 buf = new BufferedReader(new FileReader(finalPath));
			 String r;
			 
			 if (finalPath.equals(""))
			       r = null;
			 else {
				 r = buf.readLine();
			 }
			 while (r != null) 
			    {
			     System.out.println(r);
			     r = buf.readLine();
			    }
			 
	
	
}
buf.close();
 }
	 

	 
	 public static void cp(ArrayList<String> args) throws NoSuchFileException{
			for(int i=0; i<args.size(); i++) {
			 src = new File(args.get(i));
			 dest=new File(args.get(args.size()-1));
			 if(args.size()==2) {
				 if(!src.exists())
				     throw new NoSuchFileException(src.getAbsolutePath(),null,"does not exist");
				 else if(!dest.exists())
				       throw new NoSuchFileException(dest.getAbsolutePath(),null,"does not exist");
				 
				 if(src.isDirectory() && dest.isDirectory()) {
					 System.out.println("cannot copy directories");
				 }
				 try {
				     
					    BufferedReader in = new BufferedReader(new FileReader(args.get(0)));
				        BufferedWriter out = new BufferedWriter(new FileWriter(args.get(1), true));
				        
				        String str;
				        while ((str = in.readLine()) != null) {
				        	 out.write("\n" + str);
				            }
				        in.close();
				        out.close();
				        } catch (IOException e) {
				        }
				 
			 }
			 
			 
			 if(!src.exists())
			     throw new NoSuchFileException(src.getAbsolutePath(),null,"does not exist");
			 else if(!dest.exists())
			       throw new NoSuchFileException(dest.getAbsolutePath(),null,"does not exist");
			else
				try {
					Files.copy(src.toPath(),dest.toPath().resolve(src.toPath().getFileName()),StandardCopyOption.REPLACE_EXISTING);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		}
	 
	 
	 public static void more(ArrayList<String> args)
	   {
		 String d = args.get(0);
		 File f = null;
		 int pos = -1;
		 for(int i=0; i<d.length(); i++) {
			 if(d.charAt(i)==':') {
				 f = new File(args.get(0)); 
				 pos = i;
				 break;
			 }
			 else {
				 continue;
			 }
		 }
		 if(pos==-1) {
			 String current = System.getProperty("user.dir"); 
			 String s3=current.concat("\\"); 
			 String finalPath=s3.concat(args.get(0));
			 f = new File(finalPath);
		 }
		 
	   
		if (f.exists()) 
		{
			 try 
			 {
				  FileInputStream a = new FileInputStream(f);
				  BufferedReader br = new BufferedReader(new InputStreamReader(a));
				  String l;
				  int count = 0;
				  int choice;
				  Scanner in = new Scanner(System.in);
				  while ((l = br.readLine()) != null) {
					   System.out.println(l);
					   count++;
					   if (count % 10 == 0) 
					   {
					    System.out.print("--->  Press 1 to scroll down or press 0 to quit <----");
					    choice = in.nextInt();
						if (choice == 0)
						break;
						
					
					   }
			  }
		 
		  br.close();
		 }
		 
		 catch (FileNotFoundException e) 
		 {
		  e.printStackTrace();
		 } 
		 catch (IOException e) 
		 {
		  e.printStackTrace();
		 }
		 
		} 
	}
	 
	 
	 
	 public static void reDirect(String r1, String r2) throws IOException 
	   {
	
		    FileReader file1 = null;
		    FileWriter file2 = null;
		    try 
		    {
		     file1 = new FileReader(r1);
		     file2 = new FileWriter(r2);
		     int store = file1.read();
		     while(store!=-1) 
		     {
		      file2.write(store);
		      store = file1.read();
		     }
		    } 
		    catch(IOException e) 
		    {
		     System.out.println("file not found");
		    }
		    file1.close();
		    file2.close();
	   
	   }
		
		
		
	   public static void reDirectAppend(String r1,String r2) throws IOException 
	   {
		    BufferedReader file1 = null;
		    BufferedReader file2 = null;
		    ArrayList<String> list = new ArrayList<>();
		    try 
		    {
		     file1 = new BufferedReader(new FileReader(r1));
		     file2 = new BufferedReader(new FileReader(r2));
		     String line1 = file1.readLine();
		     String line2 = file2.readLine();
		     while(line1!=null)
		     {
		      list.add(line1);
		      line1 = file1.readLine();
		     }
		     while(line2!=null)
		     {
		      list.add(line2);
		      line2 = file2.readLine();
		     }
		    } 
		    catch(IOException e) 
		    {
		     System.out.println("file not found");
		    }
		    file1.close();
		    file2.close();
		    BufferedWriter fileWrite = new BufferedWriter(new FileWriter(r2));
		    for(int i=0; i<list.size(); i++)
		    {
		     fileWrite.write(list.get(i));
		     fileWrite.newLine();
		    }
		    fileWrite.close();
		   }
	 
}





