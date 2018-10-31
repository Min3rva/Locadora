package exceptions;

public class AppException extends Exception{
	
	// Super constructor
	public AppException(){
		super("App Exception");
	}
	
	public AppException(String msg){
		super(msg);
	}
}
