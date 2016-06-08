package demos;


import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.TimeUnit;
import javax.swing.JFileChooser;
import org.gstreamer.ClockTime;
import org.gstreamer.io.ReadableByteChannelSrc;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author Christopher Probst
 */
public class BasicLWJGLTest2 {

    final OpenGLMediaPlayer player = new OpenGLMediaPlayer();
    int k = 0;

    public BasicLWJGLTest2() throws Exception {
        JFileChooser f = new JFileChooser();
        f.showOpenDialog(null);
        File ff = f.getSelectedFile();


        int targetWidth = 800;
        int targetHeight = 600;

        DisplayMode chosenMode = null;

        try {
            DisplayMode[] modes = Display.getAvailableDisplayModes();

            for (int i = 0; i < modes.length; i++) {
                if ((modes[i].getWidth() == targetWidth) && (modes[i].getHeight() == targetHeight)) {
                    chosenMode = modes[i];
                    break;
                }
            }
        } catch (LWJGLException e) {
            Sys.alert("Error", "Unable to determine display modes.");
            System.exit(0);
        }

        if (chosenMode == null) {
            Sys.alert("Error", "Unable to find appropriate display mode.");
            System.exit(0);
        }

        try {
            Display.setDisplayMode(chosenMode);
            Display.setTitle("An example title...");
            Display.setVSyncEnabled(true);
            Display.create();


        } catch (LWJGLException e) {
            System.exit(0);
        }


        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();

        float ratio = (float) Display.getDisplayMode().getWidth() / Display.getDisplayMode().getHeight();

        //Perspective etc...
        GL11.glFrustum(-ratio, ratio, -1, 1, 1, 100);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glViewport(0, 0, Display.getDisplayMode().getWidth(), Display.getDisplayMode().getHeight());

        GL11.glClearColor(1, 1, 1, 1);

        boolean gameRunning = true;

        //Enable textures
        GL11.glEnable(GL11.GL_TEXTURE_2D);



        System.out.println(player.getGStreamerPlayer().getPipeline().getClock().getTime());


        ReadableByteChannelSrc srcChannel = new ReadableByteChannelSrc(new ReadableByteChannel() {

            public int read(ByteBuffer dst) throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public boolean isOpen() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void close() throws IOException {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }, "bla");

        player.getGStreamerPlayer().setURI(null);

        player.getGStreamerPlayer().play();



        float scale = 10;
        float rotate = 0;


        GL11.glClearColor(0, 0, 0, 0);

        while (gameRunning) {



            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            if (Mouse.isButtonDown(0)) {
                int x = Mouse.getX();
                float percent = ((float) x) / Display.getDisplayMode().getWidth();


                player.getGStreamerPlayer().pause();

                long dur = player.getGStreamerPlayer().getPipeline().queryDuration(TimeUnit.SECONDS);

                long secs = Math.round(dur * percent);


                player.getGStreamerPlayer().getPipeline().seek(ClockTime.fromSeconds(secs));

                player.getGStreamerPlayer().play();
            }

            //keyinput
            if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                rotate += 0.3f;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                rotate -= 0.3f;
            }

            //keyinput
            if (Keyboard.isKeyDown(Keyboard.KEY_ADD)) {
                scale += 0.07f;
            } else if (Keyboard.isKeyDown(Keyboard.KEY_MINUS)) {
                scale -= 0.07f;
            }

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }


            player.getPBO().render();


            float ratio2 = player.getPBO().getRatio();
            GL11.glPushMatrix();
            GL11.glTranslatef(0, 0, -15);
            GL11.glRotatef(rotate, 0, 1, 0);
            GL11.glScalef(scale, scale, 0);

            if (player.getPBO().getPBOTexture() != null) {
                player.getPBO().getPBOTexture().bind();


                GL11.glBegin(GL11.GL_QUADS);
                GL11.glTexCoord2f(0, 0);

                GL11.glVertex3f(-1, ratio2, -2);

                GL11.glTexCoord2f(1, 0);

                GL11.glVertex3f(1, ratio2, -2);

                GL11.glTexCoord2f(1, 1);

                GL11.glVertex3f(1, -ratio2, -2);

                GL11.glTexCoord2f(0, 1);

                GL11.glVertex3f(-1, -ratio2, -2);
                GL11.glEnd();

                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
            // now tell the screen to update
            GL11.glPopMatrix();

            Display.update();

            // finally check if the user has requested that the display be
            // shutdown
            if (Display.isCloseRequested()) {
                gameRunning = false;
                player.getPBO().dispose();
                player.getGStreamerPlayer().stop();

                Display.destroy();
                System.exit(0);
            }
        }
    }
}
 