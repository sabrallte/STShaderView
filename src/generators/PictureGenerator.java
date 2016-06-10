package generators;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import interfaces.ITextureGenerator;
import webcam.WebcamController;

public class PictureGenerator extends BaseValueGenerator implements ITextureGenerator{
	
    boolean refresh_requested = false;
    BufferedImage picture;
    String path;
	
	public PictureGenerator(String path){
		this.path = path;
		try {
			picture = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		requestRefresh();
	}
	
	@Override
	public BufferedImage getBufferedImage() {
		return picture;
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
		this.refresh_requested = false;
		
	}
}
