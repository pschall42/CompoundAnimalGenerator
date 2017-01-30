package cag;
import java.awt.*;
import java.awt.event.*;

public class CAGView extends Frame implements ActionListener {
	private static final long serialVersionUID = -5893019573405570904L;
	private TextField num2gen, numComp; // input text fields
	private TextArea compAnim; // output text field
	private Button gen; // "Generate" button
	private Label l1, l2; // labels indicating what the inputs are
	private CAGController controller;

	public CAGView()
	{
		gen=new Button("Generate");
        
        // set button position on screen
        gen.setBounds(282,175,75,25);
        
        // create labels and set their positions
        l1 = new Label();
        l1.setBounds(100, 110, 150, 20);
        l1.setText("Number to generate:");
        l2 = new Label();
        l2.setBounds(390, 110, 150, 20);
        l2.setText("Number to combine:");
        
        // create editable (input) text fields and set their position
        num2gen = new TextField();
        num2gen.setBounds(100, 150, 150, 20);
        numComp = new TextField();
        numComp.setBounds(390, 150, 150, 20);
        num2gen.setText("1");
        numComp.setText("2");
        
        // create non-editable (output) text field and set it's position
        compAnim = new TextArea();
        compAnim.setBounds(95, 220, 450, 200);
        compAnim.setEditable(false);
        
        // add button, text fields, and labels to the frame
        add(gen);
        add(num2gen);
        add(numComp);
        add(compAnim);
        add(l1);
        add(l2);
        
        // set frame width and height
        setSize(640,480);
        
        // set title of the frame
        setTitle("Compound-Animal Generator"); 
        
        // setting the layout for the Frame
        //setLayout(new FlowLayout());
        setLayout(null);
        
        // make frame visible
        setVisible(true);
        
        // window listener to close the window
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent close)
        {
                dispose();
             }
        });
        
        // sets the button to listen for a click event
        gen.addActionListener(this);
	}
	
	/**
	 * Allows the view to send data to the controller.
	 * @param controller - the controller
	 */
	public void AddController(CAGController controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Handles action events, in this case only click events on the "Generate"
	 * button.
	 */
	public void actionPerformed(ActionEvent e)
	{
		this.controller.Generate(Integer.parseInt(this.num2gen.getText()), Integer.parseInt(this.numComp.getText()));
	}
	
	/**
	 * Prints data to the non-editable (output) text field.
	 * @param out - the string to output
	 */
	public void Output(String out)
	{
		compAnim.append(out);
		compAnim.append("\n");
	}
}
