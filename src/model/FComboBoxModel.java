package model;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import generators.BaseValueGenerator;
import ui.dialog.FIGeneratorDialog;

public class FComboBoxModel implements ComboBoxModel<String> {
	
	
	String [] ar = {"Generator", "Mouse", "iFrame", "iGlobalTime", "iTimeDelta"};
	int selection = 0;
	
	@Override
	public Object getSelectedItem() {
		//Liefert das Objekt zurück (z.B. einen String), welcher als ausgewählter Eintrag in der JComboBox angezeigt werden soll.
		return ar[selection];
	}
	
	@Override
	public void setSelectedItem(Object anItem) {
		//Die Funktion wird aufgerufen, wenn ein Eintrag in der JComboBox selektiert wird.
		//-> Dialog anzeigen
		
		System.out.println(anItem.toString());
		selection=1;
		System.out.println("setSelectedItem");
		FIGeneratorDialog dlg = new FIGeneratorDialog();
		dlg.setModal(true);
		dlg.setVisible(true);
		BaseValueGenerator gen = dlg.getValue();
		System.out.println(gen.getValue(3.0));
		
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return ar[arg0];
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return ar.length;
	}
	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
