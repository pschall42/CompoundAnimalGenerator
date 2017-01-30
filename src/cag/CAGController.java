package cag;

public class CAGController {
	private CAGModel model;
	private CAGView view;
	
	public CAGController(CAGModel model, CAGView view)
	{
		this.model = model;
		this.view = view;
		this.view.AddController(this);
	}
	
	/**
	 * Receives input from the view, uses that to get data from the controller,
	 * which is sent back to the view for output.
	 * @param num2gen 
	 * @param compoundNum
	 */
	public void Generate (int num2gen, int compoundNum)
	{
		for(int i = 0; i < num2gen; i++)
		{
			this.view.Output(this.model.getNextCompoundAnimal(compoundNum));
		} 
	}
}
