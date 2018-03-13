package cse360group7project1;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class TextFormatter implements ActionListener {
	
	private JTextArea results;
	private JCheckBox rightJustifyBox;
	private FileSelectBox inputBox;
	private FileSelectBox outputBox;
	
	public TextFormatter() {
		//declare fonts
		Font boldFont = new Font(Font.SANS_SERIF, Font.BOLD, 15);
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		
		//magic code from java page to make this look less garbage
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		       if ("Nimbus".equals(info.getName())) {
		           UIManager.setLookAndFeel(info.getClassName());
		           break;
		        }
		    }
		} catch (Exception e) {} //nimbus not found? just leave it default
		
		//setup frame
		JFrame frame = new JFrame("Text Formatter Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//define components
		//input area
		JLabel inputLabel = new JLabel("Select your input file:");
		inputLabel.setFont(boldFont);
		inputLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputBox = new FileSelectBox(true);
		
		//output area
		JLabel outputLabel = new JLabel("Select your output file:");
		outputLabel.setFont(boldFont);
		outputLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		outputBox = new FileSelectBox(false);
		
		//options
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.LINE_AXIS));
		optionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		JButton submitButton = new JButton("Format");
		submitButton.addActionListener(this);
		rightJustifyBox = new JCheckBox("Right Justified");
		optionPanel.add(submitButton);
		optionPanel.add(Box.createHorizontalGlue());
		optionPanel.add(rightJustifyBox);
		
		//results
		JLabel resultLabel = new JLabel(" Result:");
		resultLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		resultLabel.setFont(font);
		results = new JTextArea(8,6);
		JScrollPane resultsPane = new JScrollPane(results); 
		resultsPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		results.setEditable(false);
		
		//add everything to frame
		panel.add(inputLabel);
		panel.add(inputBox);
		panel.add(Box.createVerticalStrut(5));
		panel.add(outputLabel);
		panel.add(outputBox);
		panel.add(Box.createVerticalStrut(6));
		panel.add(optionPanel);
		panel.add(Box.createVerticalStrut(5));
		panel.add(new JSeparator(SwingConstants.HORIZONTAL));
		panel.add(Box.createVerticalStrut(5));
		panel.add(resultLabel);
		panel.add(resultsPane);
		
		//make frame visible
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//user clicked "Format"
		//delegate to other class or just do it here?
	}
	
	public static void main(String[] args) {
		new TextFormatter();
	}
}
