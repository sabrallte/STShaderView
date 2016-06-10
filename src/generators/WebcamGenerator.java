package generators;

import java.awt.image.BufferedImage;

import interfaces.ITextureGenerator;
import webcam.WebcamController;

public class WebcamGenerator extends BaseValueGenerator implements ITextureGenerator{
	
    //Webcam
    WebcamController webcam;
    boolean refresh_requested = true;
	
	public WebcamGenerator(){
		webcam = WebcamController.getInstance();
	}
	
	@Override
	public double getValue(double x) {
		return this.value;
	}

	@Override
	public BufferedImage getBufferedImage() {
		
		// TODO vlt. kann man hier dafür sorgen das nicht mehr als 25 Bilder/s neu geschossen werden,
		//		sondern bereits geschossene wieder ausgeliefert werden bzw. noch besser das needsRefresh() nur all 1s/25
		//		true retouniert
		
		if(webcam!=null && webcam.isReady()) {
			return webcam.takePicture();
		}
		return null;
	}

	@Override
	public boolean needsRefresh() {
		return this.refresh_requested;
	}


	@Override
	public void requestRefresh() {
		this.refresh_requested = true;
	}

	@Override
	public void setRefreshDone() {
		// TODO Auto-generated method stub
	}
}
