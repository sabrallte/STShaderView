package model;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import generators.BaseValueGenerator;
import generators.BoolGenerator;
import generators.MouseWGenerator;
import generators.MouseYGenerator;
import generators.MouseZGenerator;
import ui.dialog.FIGeneratorDialog;

public class BoolComboBoxModel implements ComboBoxModel<String> {
	
	
	String [] model = {"True", "False", "Left Mouse", "Right Mouse"};
	Object selection;
	BaseValueGenerator generator = null;
	
	@Override
	public Object getSelectedItem() {
		//Liefert das Objekt zurück (z.B. einen String), welcher als ausgewählter Eintrag in der JComboBox angezeigt werden soll.
		return selection;
	}
	
	public  BaseValueGenerator getGenerator() {
		return this.generator;
		}
	
	@Override
	public void setSelectedItem(Object anItem) {
		//Die Funktion wird aufgerufen, wenn ein Eintrag in der JComboBox selektiert wird.
		//-> Dialog anzeigen
		
		switch(anItem.toString()) {
			case "True":{
				this.generator = new BoolGenerator(1);
				System.out.println("BoolComboBoxModel: TRUE");break;
			}
			case "False":{
				this.generator = new BoolGenerator(0);
				System.out.println("BoolComboBoxModel: FALSE");break;
			}
			case "Left Mouse":{
				this.generator = new MouseZGenerator();
				System.out.println("BoolComboBoxModel: Left Mouse");break;
			}
			case "Right Mouse":{
				this.generator = new MouseWGenerator();
				System.out.println("BoolComboBoxModel: Right Mouse");break;
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
