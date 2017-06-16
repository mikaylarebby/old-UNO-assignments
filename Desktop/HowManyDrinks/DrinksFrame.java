import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinksFrame extends JFrame
{
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JLabel weightLabel;
	private JLabel drinkTypeLabel;
	private JLabel drinkNumLabel;
	private JLabel hoursLabel;
	private JLabel resultLabel;
	
	private JTextField ageTextField;
	private JTextField weightTextField;
	private JTextField drinkNumTextField;
	private JTextField hoursTextField;
	
	private JComboBox<String> genderComboBox;
	private JComboBox<String> drinkTypeComboBox;
	
	private JPanel panel;
	private JPanel agePanel;
	private JPanel genderPanel;
	private JPanel weightPanel;
	private JPanel drinkPanel;
	private JPanel hoursPanel;
	private JPanel submitPanel;
	
	private JButton submit;
	
	
	

	public DrinksFrame(){
	
		//Call JFrame's constructor
		super("How Many Drinks?");
		//Set the Frame's Layout
		setLayout(new FlowLayout());
		GridLayout experimentLayout = new GridLayout(4,2);
		

		//Labels and Text Fields
		ageLabel = new JLabel("Enter age");
		genderLabel = new JLabel("Select gender");
		weightLabel = new JLabel("Enter weight");
		drinkTypeLabel = new JLabel("Whatcha drinkin'?");
		drinkNumLabel = new JLabel("How many have you had?");
		hoursLabel = new JLabel("How many hours ago did you begin drinking?");
		
		ageTextField = new JTextField(3);
		weightTextField = new JTextField(3);
		drinkNumTextField = new JTextField(3);
		hoursTextField = new JTextField(2);
		
		
		//String Arrays
		String[] genderChoices = {"Male","Female"};
		String[] drinkChoices = {"Wine", "Beer", "The Hard Stuff"};
		
		//Lists&Combo Boxes
		genderComboBox = new JComboBox<String>(genderChoices);
		drinkTypeComboBox = new JComboBox<String>(drinkChoices);
		
		//Panels
		submitPanel = new JPanel();
		genderPanel = new JPanel();
		agePanel = new JPanel();
		weightPanel = new JPanel();
		drinkPanel = new JPanel();
		hoursPanel = new JPanel();
		
		
		//Buttons
		submit = new JButton("Can I Drive?");
		
		JFrame frame = new JFrame();
		frame.setSize(400,300);
		
		submit.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        
			int age = Integer.parseInt(ageTextField.getText());
			int weight = Integer.parseInt(weightTextField.getText());
			int drinkNum = Integer.parseInt(drinkNumTextField.getText());
			int hours = Integer.parseInt(hoursTextField.getText());
			String gender = genderComboBox.getSelectedItem().toString();
			String drinkType = drinkTypeComboBox.getSelectedItem().toString();
			
			resultLabel = new JLabel(HowManyDrinks.calculateDrinks(age, weight, gender, drinkType, drinkNum, hours));
			
			frame.getContentPane().setLayout(new FlowLayout());
			frame.add(resultLabel);
		    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    frame.setPreferredSize(new Dimension(300, 200));
		    frame.pack();
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	      }
	    });
		
		

		//Add components to the Frame
		agePanel.add(ageLabel); 
		agePanel.add(ageTextField);
		genderPanel.add(genderLabel);
		genderPanel.add(genderComboBox);
		weightPanel.add(weightLabel);
		weightPanel.add(weightTextField);
		drinkPanel.add(drinkTypeLabel);
		drinkPanel.add(drinkTypeComboBox);
		drinkPanel.add(drinkNumLabel);
		drinkPanel.add(drinkNumTextField);
		hoursPanel.add(hoursLabel);
		hoursPanel.add(hoursTextField);
		submitPanel.add(submit);
		
		
		add(agePanel);
		add(genderPanel);
		add(weightPanel);
		add(drinkPanel);
		add(hoursPanel);
		add(submitPanel);
	}
}



