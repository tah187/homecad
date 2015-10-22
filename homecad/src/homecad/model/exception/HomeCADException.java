package homecad.model.exception;

//-----------------------------------------------
//Programming 2 -- OUA Term 4, 2010
//-----------------------------------------------

public abstract class HomeCADException extends Exception
{
	/**
	 * 
	 */

	public HomeCADException()
	{
		super("DEFAULT HomeCAD Exception");
	}

	//NOTE: it is advisable to use this constructor when creating new exceptions
	public HomeCADException(String message)
	{
		super(message);
	}
}
