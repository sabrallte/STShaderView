package initSetups;



import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.*;

import java.awt.image.BufferedImage;
import java.io.*;
import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.nio.IntBuffer;

public class ImageSetup {

	// Hinweis: Ein Texturname kann erst dann wieder durch glGenTextures zurückgeliefert werden, wenn er zuvor mittels glDeleteTextures freigegeben wurde.
	
    public static int loadImageSource(String location)
    {
        int texture = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texture);

        try {
            BufferedImage bi = ImageIO.read(new File(location));
            int width = bi.getWidth(), height = bi.getHeight();
            IntBuffer intBuffer = BufferUtils.createByteBuffer(4 * width * height).asIntBuffer();
            intBuffer.put(bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(),
                    new int[bi.getWidth() * bi.getHeight()], 0, bi.getWidth()));
            intBuffer.rewind();
            //intBuffer.flip();

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB8, width, height, 0, GL_BGRA,
                    GL_UNSIGNED_BYTE, intBuffer);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S,  GL_REPEAT);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
            glEnable(GL_TEXTURE_2D);
        } catch (FileNotFoundException e) {
            System.err.println("Texture file could not be found.");
            e.printStackTrace();
            return -1;
        } catch (IOException ex) {
            System.err.print("Failed to load the texture file.");
            ex.printStackTrace();
            return -1;
        }
        glBindTexture(GL_TEXTURE_2D, 0);
        return texture;
    }
    
    
    public static int loadBufferedImage(BufferedImage bi, int texture_nr)
    {
        //int texture = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, texture_nr);

        int width = bi.getWidth(), height = bi.getHeight();
		IntBuffer intBuffer = BufferUtils.createByteBuffer(4 * width * height).asIntBuffer();
		intBuffer.put(bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(),
		        new int[bi.getWidth() * bi.getHeight()], 0, bi.getWidth()));
		intBuffer.rewind();
		//intBuffer.flip();

		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB8, width, height, 0, GL_BGRA,
		        GL_UNSIGNED_BYTE, intBuffer);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S,  GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		glEnable(GL_TEXTURE_2D);
        glBindTexture(GL_TEXTURE_2D, 0);
        return texture_nr;
    }

}
