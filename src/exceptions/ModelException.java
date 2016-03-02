package exceptions;

public class ModelException extends Exception{
	
	public ModelException(){
		super("Model Exception");
	}
	
	public ModelException(String msg){
		super(msg);
	}
}
