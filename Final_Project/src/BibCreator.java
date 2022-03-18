
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class BibCreator {
   

    public static void main(String[] args){
        System.out.println("------------Welcome to Atul Rana BibCreator!------------\n");
  // we use scanner to read the files
        
        // creating Scanner object scan
        
        
        Scanner scan=new Scanner(System.in);
        // array of Scanner to read all the 10 files
        Scanner[] scanner=new Scanner[10];
        
        // initializing iterator
        int i=1;
        
        try {
            for (i = 1; i < 11;i++)
            	// for reading Latex1 to Latex 10  
                scanner[i-1] = new Scanner(new FileInputStream("Latex" + i + ".bib"));
        }
        // Exception if file not found
        catch(FileNotFoundException e){
            System.out.println("Could not open input file Latex"+i+".bib for reading. \nPlease check if file exists! \nProgram will terminate after closing any opened files.");
            System.exit(0);
        }
       
       // We then call the main processing function for all 10 latex files
        for(i=1;i<11;i++) {
            //calling/declaring from the class FileValidation
        	
        	//i as value in processFilesForValidation
            FileValidation.processFilesForValidation(i);
        }
        System.out.println("A total of "+FileValidation.counter+" files were invalid. There are only "+(10-FileValidation.counter)+" valid files processed");
      
        //Initializing BufferedReader object br to null
        BufferedReader br=null;
        String line=null;
        //Here we call and handle the function that scans and prints the files to review
        try{
            FileValidation.OpenFile(br,line,scan);
        } catch(FileNotFoundException e){
            System.out.println("Could not open input file. File does not exist; possibly it could not be created");
            try{
                FileValidation.OpenFile(br,line,scan);
                
            }
            catch(FileNotFoundException ex){
                System.out.println("Could not open input file. File does not exist!");
                System.out.println("This is your second attempt So now program will be terminated");
                System.exit(0);
            }
            catch (IOException ex){
                System.out.println("IO Exception occurred! Will now terminate program!");
                System.exit(0);
            }
        } catch (IOException e){
            System.out.println("IO Exception occurred! Will now terminate program!");
         
            System.exit(0);
        }
        


    }
}