package webcam;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

public class WebcamController {
	Webcam webcam;
	boolean running = true;
	public WebcamController() {
		// get default webcam and open it
		webcam = Webcam.getDefault();
		webcam.open();
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
		WebcamController wc = new WebcamController();
		BufferedImage image  = wc.takePicture();
	    wc.saveBufferedImageToFile(image, "test.png");

	}

}
