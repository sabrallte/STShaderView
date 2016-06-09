package model;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class IComboBoxModel implements ComboBoxModel<String> {
	
	@Override
	public Object getSelectedItem() {
		//Liefert das Objekt zurück (z.B. einen String), welcher als ausgewählter Eintrag in der JComboBox angezeigt werden soll.
		return "nulL";
	}
	
	@Override
	public void setSelectedItem(Object anItem) {
		//Die Funktion wird aufgerufen, wenn ein Eintrag in der JComboBox selektiert wird.
		//-> Dialog anzeigen
	}
	
	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getElementAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
