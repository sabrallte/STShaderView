package interfaces;

import java.awt.image.BufferedImage;

public interface ITextureGenerator {

	
	public BufferedImage getBufferedImage();
	
	public boolean needsRefresh(); // Sollen Daten neu ausgelesenw werden?
	
	public void requestRefresh(); // Neue Daten wurden in das Objekt geschrieben und sollen ausgelesen werden
	
	public void setRefreshDone(); // Aktuelle informationen wurden ausgelesesn
	
}
