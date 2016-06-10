package webcam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class WebcamController {
	Webcam webcam;
	boolean running = true;
	
	
	  // Eine (versteckte) Klassenvariable vom Typ der eigene Klasse
	  private static WebcamController instance;
	  // Verhindere die Erzeugung des Objektes über andere Methoden
	  private WebcamController () {
			// get default webcam and open it
		  System.out.println("Start Webcam");
			webcam = Webcam.getDefault();
			webcam.open();
	  }
	  // Eine Zugriffsmethode auf Klassenebene, welches dir '''einmal''' ein konkretes 
	  // Objekt erzeugt und dieses zurückliefert.
	  // Durch 'synchronized' wird sichergestellt dass diese Methode nur von einem Thread 
	  // zu einer Zeit durchlaufen wird. Der nächste Thread erhält immer eine komplett 
	  // initialisierte Instanz.
	  public static synchronized WebcamController getInstance () {
	    if (WebcamController.instance == null) {
	    	WebcamController.instance = new WebcamController();
	    }
	    return WebcamController.instance;
	  }
	

	
	public boolean isReady() {
		if (webcam == null || !running) {
			return false;
		}
		else {return true;}
	}
	
	public void deactivate() {
		running = false;
	}
	
	public BufferedImage takePicture() {

		// get image
		BufferedImage image = webcam.getImage();
		return image;

	}
	
	public void saveBufferedImageToFile(BufferedImage image, String path) {
		// save image to PNG file
		try {
			ImageIO.write(image, "PNG", new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void destroy() {
		webcam.close();
		webcam = null;
	}
	
	public static void main(String[] args) {
		WebcamController wc = WebcamController.getInstance();
		BufferedImage image  = wc.takePicture();
	    wc.saveBufferedImageToFile(image, "test.png");

	}

}
