package homecad.model.exception;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Finance Exception
//-----------------------------------------------

public class FinanceException extends HomeCADException
{
	/**
	 * 
	 */
	
	public FinanceException()
	{
		super("DEFAULT HomeCAD Exception");
	}

	public FinanceException(String message)
	{
		super(message);
	}
}
