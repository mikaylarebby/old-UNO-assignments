import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiftFrame extends JFrame
{
	private JLabel ageLabel;
	private JLabel genderLabel;
	private JLabel budgetLabel;
	private JLabel interestLabel;
	private JLabel nameLabel;
	
	private JTextField nameTextField;
	private JTextField ageTextField;
	
	private JComboBox<String> genderComboBox;
	private JComboBox<String> budgetComboBox;
	private JList<String> interestList;
	private JRadioButton[] interestButton;
	
	private JPanel panel;
	private JPanel budgetPanel;
	private JPanel namePanel;
	private JPanel agePanel;
	private JPanel genderPanel;
	private JPanel interestPanel;
	private JPanel submitPanel;
	
	private JButton submit;
	
	

	public GiftFrame(){
	
		//Call JFrame's constructor
		super("Christmas Gift Generator");
		//Set the Frame's Layout
		setLayout(new FlowLayout());
		GridLayout experimentLayout = new GridLayout(4,2);
		

		//Labels and Text Fields
		nameLabel = new JLabel("Enter Name of Recipient");
		ageLabel = new JLabel("Enter Age of Recipient");
		genderLabel = new JLabel("Select Gender of Recipient");
		budgetLabel = new JLabel("What is your budget?");
		interestLabel = new JLabel("What do they like? Select all that apply");
		ageTextField = new JTextField(3);
		nameTextField = new JTextField(8);
		
		//String Arrays
		String[] interestChoices = {"Video Games","Music","TV & Movies", "Jewelry", "Food","Board Games","Perfume/Cologne", "I have no idea"};
		String[] genderChoices = {"Male","Female"};
		String[] budgetChoices = {"Less than $25","$25-$50","$50-$100", "$100+"};
		
		//Lists&Combo Boxes
		interestList = new JList<String>(interestChoices);
		genderComboBox = new JComboBox<String>(genderChoices);
		budgetComboBox = new JComboBox<String>(budgetChoices);
		
		//Panels
		submitPanel = new JPanel();
		budgetPanel = new JPanel();
		namePanel = new JPanel();
		genderPanel = new JPanel();
		agePanel = new JPanel();
		interestPanel = new JPanel();
		
		interestPanel.setLayout(experimentLayout);
		
		//Buttons
		submit = new JButton("Generate My Gift!");
		
		JFrame frame = new JFrame();
		frame.setSize(250,250);
		
		submit.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
	        
	        frame.getContentPane().setLayout(new FlowLayout());
		    frame.add(namePanel);
		
		    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		    frame.setPreferredSize(new Dimension(300, 200));
		    frame.pack();
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	      }
	    });
		
		//Settings
		interestButton = new JRadioButton[interestChoices.length];
		for(int i = 0; i < interestChoices.length; i++) {
			interestButton[i] = new JRadioButton(interestChoices[i]);
		 }
		

		//Add components to the Frame
		namePanel.add(nameLabel); 
		namePanel.add(nameTextField);
		agePanel.add(ageLabel); 
		agePanel.add(ageTextField);
		genderPanel.add(genderLabel);
		genderPanel.add(genderComboBox);
		budgetPanel.add(budgetLabel);
		budgetPanel.add(budgetComboBox);
		for(int i = 0; i < interestButton.length; i++) {
			interestPanel.add(interestButton[i]);
		}
		submitPanel.add(submit);
		
		
		add(namePanel);
		add(agePanel);
		add(genderPanel);
		add(interestLabel);
		add(interestPanel);
		add(budgetPanel);
		add(submitPanel);
	}
}



