import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileValidation {

    //Here we will be doing file validation and displaying the files which are invalid.
	
    // attribute counter counts the number of operations
    
	public static int counter=0;

	 //WE WILL BE TAKING ADVANTAGE OF THE STATIC THROUGH OUT
    public static void processFilesForValidation(int latexFileNumber) {
            
        String error = null; // gives the error indicating to the field that is empty
      
        //Fields as attributes
        
        String title=null;
        String year=null;
        String volume=null;
        String number=null;
        String pages=null;
        String keywords=null;
        String doi=null;
        String ISSN=null;
        String month=null;
        String journal=null;
        
     // use these attributes to extract characters of only author from IEEE, NJ, ACM  
        
        String IEEEOfAuthorOnly=null;
        String ACMOfAuthorOnly=null;
        String NJOfAuthorOnly=null;
        
        
     // FileLine for verifying characters by line in file
        String FileLine;
        
        //Print writing IEEE, ACM, NJ
        
        PrintWriter pwIEEE=null;
        PrintWriter pwACM=null;
        PrintWriter pwNJ=null;
        
        
        int countACM=0;

        try {
// Reading the file
        	
        	//If the entered file is valid, then our program will open this file for reading using the
        	//BufferedReader class
            BufferedReader ReadFile = new BufferedReader(new FileReader("Latex" + latexFileNumber + ".bib"));
            
         // Creating File object for all three file types
            File TypeFileACM = new File("ACM" + latexFileNumber + ".json");
            File TypeFileIEEE = new File("IEEE" + latexFileNumber + ".json");
            File TypeFileNJ = new File("NJ" + latexFileNumber + ".json");
            
            
          //Output the new format through PrintWriter   
            pwIEEE = new PrintWriter(new FileOutputStream("IEEE" + latexFileNumber + ".json",true));
            pwACM = new PrintWriter(new FileOutputStream("ACM" + latexFileNumber + ".json",true));
            pwNJ = new PrintWriter(new FileOutputStream("NJ" + latexFileNumber + ".json",true));
            
            // while the file is not empty
            while ((FileLine = ReadFile.readLine()) != null) {
                boolean ErrorInFileLineBool=true;
                if (FileLine.equals("")) 
                    
                {
                    //print nothing
                } 
                
             
            // if file line has doi field as empty then showing the invalid empty field 
                
                 
                else if (FileLine.contains("doi={}")) 
                    
                {
                	error = "doi";
                	ErrorInFileLineBool=false;
                    
                // removing files
                	
                    TypeFileIEEE.delete(); 
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                    // throwing custom exception 
                    throw new FileInvalidException();
                }
                
           // if file line has title field as empty then showing the invalid empty field
                
                else if (FileLine.contains("title={}")) 
                {
                	error = "title";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                } 
                
                
           // if file line has year field as empty then showing the invalid empty field
                
                else if (FileLine.contains("year={}")) 
                {
                	error = "year";
                	ErrorInFileLineBool=false;
                    
                // removing files
                	
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                } 
                
            // if file line has author field as empty then showing the invalid empty field
                
                else if (FileLine.contains("author={}")) 
                {
                	error = "author";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                }
                
            // if file line has journal field as empty then showing the invalid empty field
                
                else if (FileLine.contains("journal={}")) 
                {
                	ErrorInFileLineBool=false;
                    error = "journal";
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                }
                
             // if file line has volume field as empty then showing the invalid empty field  
                
                else if (FileLine.contains("volume={}")) 
                {
                	 error = "volume";
                     ErrorInFileLineBool=false;
                   
                  // removing files
                     
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                } 
                
             // if file line has number field as empty then showing the invalid empty field
                
                else if (FileLine.contains("number={}")) 
                {
                	error = "number";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                } 
                
             // if file line has keywords field as empty then showing the invalid empty field
                
                else if (FileLine.contains("keywords={}"))
                
                {
                	error = "keywords";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                } 
                
             // if file line has pages field as empty then showing the invalid empty field
                
                else if (FileLine.contains("pages={}")) 
                {
                	error = "pages";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                }
                
             // if file line has ISSN field as empty then showing the invalid empty field
                
                else if (FileLine.contains("ISSN={}")) 
                {
                	error = "ISSN";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                } 
                
             // if file line has month field as empty then showing the invalid empty field
                
                else if (FileLine.contains("month={}")) 
                {
                	error = "month";
                    ErrorInFileLineBool=false;
                    
                 // removing files
                    
                    TypeFileIEEE.delete();
                    TypeFileNJ.delete();
                    TypeFileACM.delete();
                    
                 // throwing custom exception 
                    throw new FileInvalidException();
                }
                 
                
                
                else if (ErrorInFileLineBool && FileLine.contains("author={")) 
                {
                    
                	//returns new String object containing the substring of the given string																																																																																																										
                	
                    ACMOfAuthorOnly = FileLine.substring(8,FileLine.indexOf("}"));
                    
                    NJOfAuthorOnly = FileLine.substring(8,FileLine.indexOf("}"));
                    
                    IEEEOfAuthorOnly = FileLine.substring(8,FileLine.indexOf("}"));
           
                    
                    // Here we can't use StringBuilder replace(start, end, replacement) method because we 
                    // want to replaces all occurrences so we will be using replaceAll method with the replacement I provide
                    
                    IEEEOfAuthorOnly = IEEEOfAuthorOnly.replaceAll("and",",");
                    
                    NJOfAuthorOnly = NJOfAuthorOnly.replaceAll("and","&");
                    
                    
                    if (FileLine.contains("and")) 
                    {
                    	ACMOfAuthorOnly = ACMOfAuthorOnly.substring(0, ACMOfAuthorOnly.indexOf("and")-1) + " et al";
                    }
                        
                    else 
                    {
                    	ACMOfAuthorOnly = ACMOfAuthorOnly+ "et al";
                    }
                        
                    // incrementing the counter
                    
                    countACM++;
                } 
                 
                
                else if (ErrorInFileLineBool && FileLine.contains("pages={") ) 
                {
                	
                    pages = FileLine.substring(7, FileLine.indexOf("}") );
                }
                
                else if (ErrorInFileLineBool && FileLine.contains("title={") ) 
                {
                    title = FileLine.substring(7, FileLine.indexOf("}") );
                } 
                
                else if (ErrorInFileLineBool && FileLine.contains("year={") ) 
                {
                    year = FileLine.substring(6, FileLine.indexOf("}") );
                } 
                
                else if (ErrorInFileLineBool && FileLine.contains("number={") ) 
                {
                    number = FileLine.substring(8, FileLine.indexOf("}") );
                } 
                
                else if (ErrorInFileLineBool && FileLine.contains("month={") ) 
                {
                    month = FileLine.substring(7, FileLine.indexOf("}"));
                    
                    //Formating the charaters in the Printwriters according to the file format.
                    pwIEEE.println(IEEEOfAuthorOnly+". "+"\" "+ title +"\" "+ ", " 
                    +journal+ ", vol. " +volume+", no. "+number+", p. "+pages+", "+month+
                    " "+year+".\n");
                    
                    
                    pwACM.println("["+ countACM +"] "+ACMOfAuthorOnly+". "+title+". "+year+". "+journal+". "+volume+", "+number+" ("+year+")"+", "+pages+". DOI:https://doi.org/"+doi+".\n");
                    
                   
                    pwNJ.println( NJOfAuthorOnly+". "+title+". "+journal+". "+volume+", "+pages+"("+year+")"+".\n");
                }
                
                else if (ErrorInFileLineBool && FileLine.contains("ISSN={") ) {
                	
                    ISSN = FileLine.substring(6, FileLine.indexOf("}") );
                } 
                
                else if (ErrorInFileLineBool && FileLine.contains("keywords={") ) 
                {
                    keywords = FileLine.substring(10, FileLine.indexOf("}") );
                } 
                
                else if (ErrorInFileLineBool && FileLine.contains("doi={") ) 
                {
                    doi = FileLine.substring(5, FileLine.indexOf("}") );
                } 
                
                else if (ErrorInFileLineBool && FileLine.contains("volume={") ) 
                {
                    volume = FileLine.substring(8, FileLine.indexOf("}") );
                }
               
                else if (ErrorInFileLineBool && FileLine.contains("journal={") ) 
                {
                    journal = FileLine.substring(9, FileLine.indexOf("}") );
                }
                
            }
            
            // Closing the BufferedReader
            ReadFile.close();
            
            } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File Latex" + latexFileNumber + ".bib not found! Program shall terminate now.");
            System.exit(0);
        } 
        
        catch (FileInvalidException e) {
            counter++;
            System.out.println("Error: Detected Empty Filed!");
            System.out.println("============================");
            System.out.println("\nerror detected with file Latex" + latexFileNumber + ".bib");
            System.out.println(e.getMessage());
            System.out.println("File is Invalid: Field \"" + error + "\" is Empty. Processing has stopped at this point. Other empty fields may be present as well!\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }finally {
            pwIEEE.close();
            pwACM.close();
            pwNJ.close();
            
        }

    }
 // Reading and print the wanted file using BufferedReader which will later be called in main class BibCreator.java
    
    // Throws exception FileNotFoundException and IOException
    public static void OpenFile(BufferedReader br, String line, Scanner scan) throws FileNotFoundException,IOException{
        
    	
    	System.out.print("\nPlease enter the name of a file you would like to review: ");
       
    	String FileReview = scan.next();
        
    	br = new BufferedReader(new FileReader(FileReview));
        
    	while((line=br.readLine())!=null) 
    	{
            System.out.println(line);
        }
        System.out.println("Thank you for using Atul and Hardik's BibCreator!");
       
        br.close();
        
        System.exit(0);
    }
}