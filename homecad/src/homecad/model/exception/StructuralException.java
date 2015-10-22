package homecad.model.exception;

//-----------------------------------------------
//s3294287 Tim Hayward assignment 1b
//HomeCAD
//-----------------------------------------------
//Structural Exception
//-----------------------------------------------

public class StructuralException extends HomeCADException
{
	/**
	 * 
	 */

	public StructuralException()
	{
		super("DEFAULT HomeCAD Exception");
	}

	public StructuralException(String message)
	{
		super(message);
	}
}
