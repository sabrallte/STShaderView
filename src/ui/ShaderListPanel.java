package ui;

import java.awt.Color;
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

import helpers.SourceCodeLoader;
import interfaces.ITabbedPanel;
import interfaces.IValueSubmittedListener;
import strategys.shadertoy;

public class ShaderListPanel extends JPanel  implements ITabbedPanel{
	
	
	shadertoy shader;
	List<String> shader_list;
	List<String> shader_list_fullpath;
	JList list;
	
	public ShaderListPanel() {
		
		JButton button_activate = new JButton("Activate");
		JButton button_delete = new JButton("Delete");
		JButton button_reload = new JButton("Reload");;
		

		
		shader_list = readShaderDir();
		list = new JList(shader_list.toArray());
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				notifyListeners();
			}
		});
		
		
		button_reload.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
        		shader_list = readShaderDir();
        		
        		DefaultListModel<String> model = new DefaultListModel<>();
        				 for(String val : shader_list)
        				         model.addElement(val);
			 	list.clearSelection();
        		list.setModel(model);
        		System.out.println("Reload Shader lIst;");
        		
            }
        });
		
		
		
		this.add(new JScrollPane(list));
		this.add(button_activate);
		this.add(button_reload);
		this.add(button_delete);

	}
	
	
	public List<String> readShaderDir() {
		
		Path p1 = Paths.get("res/shader/fragment/");
		shader_list = new ArrayList<String>();
		shader_list_fullpath = new ArrayList<String>();
		
		try {
			int count = 0;
			Files.walk(Paths.get(p1.toAbsolutePath().toString())).forEach(filePath -> {
			    if (Files.isRegularFile(filePath)) {
			    	shader_list.add(Paths.get(filePath.toString()).getFileName().toString());
			    	shader_list_fullpath.add(Paths.get(filePath.toString()).toString());
			    }
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shader_list;
		
	}
	
	
	private List<IValueSubmittedListener> listeners = new ArrayList<IValueSubmittedListener>();


    public void addListener(IValueSubmittedListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
    	
    	if (list.getSelectedIndex() < 0) {return;}
    	
        for (IValueSubmittedListener listener : listeners) {
            listener.onSubmitted(shader_list_fullpath.get(list.getSelectedIndex()));
        }
    }


	@Override
	public void onTabSelected() {
		System.out.println("selected available shaders");
		
	}


	@Override
	public void setActiveShader(shadertoy shader) {
		shader = (shadertoy) shader;
		
	}

}
