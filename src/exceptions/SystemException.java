package exceptions;

public class SystemException extends Exception{
	
	public SystemException(){
		super("System Exception");
	}
	
	public SystemException(String msg){
		super(msg);
	}
}
