package cse360group7project1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("serial")
public class FileSelectBox extends JPanel implements ActionListener {

	public File chosenFile;
	private JLabel label;
	private int dialogType;
	
	public FileSelectBox(boolean input) {
		super();
		
		if(input)
			dialogType = JFileChooser.OPEN_DIALOG;
		else
			dialogType = JFileChooser.SAVE_DIALOG;
		
		JPanel panel = this;
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		JPanel inner = new JPanel();
		inner.setLayout(new BoxLayout(inner, BoxLayout.LINE_AXIS));
		inner.setPreferredSize(new Dimension(600,30));
		inner.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
		
		JButton inputButton = new JButton("Browse...");
		inputButton.addActionListener(this);
		label = new JLabel("No file selected.");
		
		inner.add(inputButton);
		inner.add(Box.createHorizontalStrut(5));
		inner.add(label);
		panel.add(inner);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogType(dialogType);
		if(dialogType == JFileChooser.SAVE_DIALOG) chooser.setDialogTitle("Save");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Text Documents", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       chosenFile = chooser.getSelectedFile();
	       label.setText(chosenFile.getName());
	    }
	}

}
