package monopoly_take2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class NOCList {
	
        
	public static void main(String[] args) throws FileNotFoundException {
		
		ArrayList<String> lines = new ArrayList<String>();
		ArrayList<ArrayList<String>> newDads = new ArrayList<ArrayList<String>>();

		Path filePath = Paths.get("nocListPlaces.txt");
	    if (Files.exists(filePath)){

	     File objFile = filePath.toFile();
	     
	     try(BufferedReader in = new BufferedReader( new FileReader(objFile))){
	          String line = in.readLine();

	          while(line != null){ // loop till you have no more lines
	        	  
	        	  	line.split("\t");
	        	  	lines.add(line);
        	  		newDads.add(new ArrayList<String>(Arrays.asList(line.split("\t"))));
	              line = in.readLine(); // try to read another line
	          }
	          
	          newDads.remove(0);
	          Collections.shuffle(newDads);
	          for(ArrayList<String> ads : newDads) {
	        	  	System.out.println(ads.get(0));
	          }
	          

              //System.out.println(newDads);

	        }
	         catch(IOException e){

	             System.out.println(e);
	         }
	     
	    }
	    else
	    {
	      System.out.println(filePath.toAbsolutePath() + " doesn't exist");
	    }
	}
}
