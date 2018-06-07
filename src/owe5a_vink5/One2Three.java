package owe5a_vink5;

/**
 *
 * @author karin
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class One2Three extends JFrame implements ActionListener{
	private JLabel label1;
	private JLabel label2;
	private JTextField field1;
	private JTextField field2;
	private JButton button1;
	private JButton button2;
	
	public static void main(String[] args) {
		One2Three frame = new One2Three();
		frame.setTitle("AA-Translator");
        frame.setSize(350,130);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        
        label1 = new JLabel("1-lettercode:");        
        label2 = new JLabel("3-lettercode:");
        field1 = new JTextField(20);
        field2 = new JTextField(20);
        button1 = new JButton("Translate");
        button2 = new JButton("Translate to Amino Acid");

        window.add(label1);
        window.add(field1);
        window.add(button1);
        window.add(button2);
        window.add(label2);
        window.add(field2);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent event) {
    	String input1 = field1.getText();
    	String input2 = field2.getText();
    	Object buttonPressed = event.getSource();
    	
    	if (button1 == buttonPressed){ 
        	if (input1.length() > 0){
            	Translator trans = new Translator(input1);
            	field2.setText(trans.threeLetter());
        	} else if (input2.length() > 0){
            	Translator trans = new Translator(input2);
            	field1.setText(trans.oneLetter());
            	}
        } else if (button2 == buttonPressed){
           	Translator trans = new Translator(input1);
           	field2.setText(trans.fullName());
           	}
    }
}
