package model;

import javax.swing.ComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.event.ListDataListener;

import generators.BaseValueGenerator;
import generators.BoolGenerator;
import generators.MouseWGenerator;
import generators.MouseZGenerator;
import generators.PictureGenerator;
import generators.WebcamGenerator;
import helpers.ImageFilter;
import interfaces.ITextureGenerator;

public class TextureComboBoxModel implements ComboBoxModel<String> {

	
	String [] model = {"Webcam", "Video", "Picture"};
	Object selection;
	ITextureGenerator generator = null;
	
	@Override
	public Object getSelectedItem() {
		//Liefert das Objekt zurück (z.B. einen String), welcher als ausgewählter Eintrag in der JComboBox angezeigt werden soll.
		return selection;
	}
	
	public  ITextureGenerator getGenerator() {
		return this.generator;
		}
	
	@Override
	public void setSelectedItem(Object anItem) {
		//Die Funktion wird aufgerufen, wenn ein Eintrag in der JComboBox selektiert wird.
		//-> Dialog anzeigen
		
		switch(anItem.toString()) {
			case "Webcam":{
				this.generator = new WebcamGenerator();
				break;
			}
			case "Video":{
				break;
			}
			case "Picture":{
				final JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.addChoosableFileFilter(new ImageFilter());
				if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					this.generator = new PictureGenerator(fc.getSelectedFile().getAbsolutePath());
				}
				break;
			}
			
		}
		selection=anItem;
		
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getElementAt(int arg0) {
		return model[arg0];
	}
	@Override
	public int getSize() {
		return model.length;
	}
	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
	}

}
