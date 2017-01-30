package cag;

public class Program {
	
	/**
	 * Main entry point for the program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		CAGView view = new CAGView();
		CAGModel model = new CAGModel();
		CAGController controller = new CAGController(model, view);
	}
}
