package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import helpers.SourceCodeLoader;
import interfaces.ITabbedPanel;
import interfaces.ValueSubmittedListener;
import strategys.shadertoy;

public class DownloadPanel extends JPanel implements ITabbedPanel {
	JTextField textfield_url;
	
	public DownloadPanel() {
		
		JButton button_activate = new JButton("Download");
		textfield_url = new JTextField(50);
		textfield_url.setSize(20, 200); //textfield_url.getHeight()
        //Action Listener
		button_activate.addActionListener(new java.awt.event.ActionListener() {
			// Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
			public void actionPerformed(java.awt.event.ActionEvent e) {

				SourceCodeLoader scl = new SourceCodeLoader();

				if (scl.load(textfield_url.getText()) == null) {
					String[] optional_shaders = new String[] {};
					optional_shaders = scl.getOptionalShaders();
					String selection = showDialog(optional_shaders);

					if ( (selection!= null) && (scl.load(selection) != null)) {}
					else{
						System.out.println("ERROR: Could not load Shader %s".format(selection));
					}
				}
				System.out.println("Download Finished");
			}
		});

		this.add(textfield_url);
		textfield_url.setSize(500, 700); 
		this.add(button_activate);

	}
	

	public String showDialog(String[] optional_shaders) {
		ImageIcon icon = new ImageIcon();
    	Object[] possibilities = {"ham", "spam", "yam"};
    	String s = (String)JOptionPane.showInputDialog(
    	                    this,
    	                    "There is more than one Shader\n"
    	                    + "\"at this URL available, choose one:\"",
    	                    "Select Shader",
    	                    JOptionPane.PLAIN_MESSAGE,
    	                    icon,
    	                    optional_shaders,
    	                    "");

    	//If a string was returned, say so.
    	if ((s != null) && (s.length() > 0)) {
    		System.out.println("Dialog, selected: %s".format(s));
    		return s;
    	}
    	return null;

	}

	
	
	private List<ValueSubmittedListener> listeners = new ArrayList<ValueSubmittedListener>();

    public void addListener(ValueSubmittedListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
    	for (ValueSubmittedListener listener : listeners) {
    		listener.onSubmitted("");
    	}
    }
    
    @Override
	public void onTabSelected() {
		System.out.println("selected download");
	}

}


