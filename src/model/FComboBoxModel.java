package model;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import generators.BaseValueGenerator;
import ui.dialog.FIGeneratorDialog;

public class FComboBoxModel implements ComboBoxModel<String> {
	
	
	String [] model = {"Standard", "Generator", "Mouse", "iFrame", "iGlobalTime", "iTimeDelta"};
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
		
		// TODO: Restlichen Funktionalitäten implementieren 
		
		switch(anItem.toString()) {
			case "Generator":{
				FIGeneratorDialog dlg = new FIGeneratorDialog();
				dlg.setModal(true);
				dlg.setVisible(true);
				this.generator = dlg.getValue();
				
				if (this.generator==null) {
					selection="Standard";
				}else {
					
				}
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
