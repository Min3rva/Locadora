package exceptions;

public class AppException extends Exception{
	
	public AppException(){
		super("App Exception");
	}
	
	public AppException(String msg){
		super(msg);
	}
}
