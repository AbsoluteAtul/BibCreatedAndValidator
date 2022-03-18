public class FileInvalidException extends Exception{
    //Just a simple exception used in case the file is invalid

	// here we are using this as a default constructor
    public FileInvalidException() {
        super("Error: Input file cannot be parsed due to missing information\n" +
                "(i.e. month={}, title={}, etc.)");
    }

  //getMessage returns the error message from the default constructor
    public String getMessage () {
        return super.getMessage();
    }
}