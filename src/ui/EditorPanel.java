package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import helpers.IO;
import helpers.SourceCodeLoader;
import interfaces.ITabbedPanel;
import interfaces.IValueSubmittedListener;
import strategys.shadertoy;
import javax.swing.JEditorPane;

public class EditorPanel extends JPanel  implements ITabbedPanel{
	
	
	shadertoy shader;
	JEditorPane editor;
	
	
	public EditorPanel() {
		
		this.setLayout(new BorderLayout());
		JButton button_activate = new JButton("Activate");
		JButton button_delete = new JButton("Delete");
		JButton button_reload = new JButton("Reload");;
		editor = new JEditorPane();
		editor.setSize(10, Integer.MAX_VALUE);
		//this.setSize(100, 100);

		button_reload.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
            	editor.setText(readShaderCode());
        		
            }
        });
		
		this.add(new JScrollPane(editor));
		this.setMaximumSize(new Dimension(-1, 20));
//		this.add(new JScrollPane(list));
//		this.add(button_activate);
		//this.add(button_reload);
//		this.add(button_delete);

	}
	
	@Override
	public void onTabSelected() {
		editor.setText(readShaderCode());
	}
	
	public String readShaderCode() {
		if(shader == null) {return "ERROR: Kein aktiver Shader gesetzt!";}
		
		String path = shader.getFragmentShaderLocation();
		return IO.readFile(path);
	}

	@Override
	public void setActiveShader(shadertoy shader) {
			System.out.println("Shader gesetzt: "+ shader.toString());
			this.shader = (shadertoy) shader;
	}
	


}
