
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;



import initSetups.ShaderSetup;
import interfaces.ITabbedPanel;
import interfaces.ITextureGenerator;
import interfaces.IValueSubmittedListener;
import strategys.BaseStrategy;
import strategys.shadertoy;
import ui.DownloadPanel;
import ui.EditorPanel;
import ui.NodeEditorPanel;
import ui.ShaderListPanel;
import webcam.WebcamController;
import initSetups.Geometry;
import initSetups.BufferSetup;
import initSetups.ImageSetup;

public class Main  implements IValueSubmittedListener{

    private Geometry geometry;
    private ShaderSetup shaderSetup;
    private ImageSetup loadTex;
    private int shaderProgram;
    private int windowWidth;
    private int windowHeight;
    private int texture;
    public shadertoy active_shader = new shadertoy();
    public Canvas webgl_container;
    public boolean reload_complete_shader__from_file_requested = false;
    public boolean running = true;
    
    // GUI
    JTabbedPane tabpane;
    JFrame f_controll;
    JFrame f_visual= new JFrame();
    
    //GUI - Parameter
    float valOftextSliderMultiplicator = 0;
    
    
    //Monitoring
    long lastFPS = 0;
    long fps = 0;
    
    long fp10ms = 0;
    long lastFP10ms = 0;
    
    public Main() {
    	
    }

    public void onSubmitted(String value) {
        System.out.println("Change Shader to: " + value);
        active_shader.setFragmentShaderLocation(value);
        reload_complete_shader__from_file_requested = true;
    }
    
    private void setUpShader()
    {
    	// Liest die Shader aus der in active_shader angegebenen Datei und lädt sie ein.
    	
    	glDeleteProgram(shaderProgram);
    	if (active_shader.getVertexShaderLocation()== null || active_shader.getFragmentShaderLocation() == null){
    		shaderProgram = 0;
    		return;
    	}
    	
        shaderProgram = ShaderSetup.readAndloadShadersFromFile(active_shader.getVertexShaderLocation(),active_shader.getFragmentShaderLocation());
        
        // Shader ist erst nach dem laden verfügbar
        active_shader.set_shader_program(shaderProgram);
    }
    
    
    private void refreshFragmentShader() {
    	glDeleteProgram(shaderProgram);
    	shaderProgram = ShaderSetup.ReadAndloadFragmentShaderFromString(active_shader.getFragmentShader());
        // Shader ist erst nach dem laden verfügbar
        active_shader.set_shader_program(shaderProgram);
    }
    

    private void setUpTextures()
    {
    	
		if (active_shader.getUniformProvider().iChannel0.needsRefresh()) {
			loadTex.loadBufferedImage(((ITextureGenerator)active_shader.getUniformProvider().getiChannel0()).getBufferedImage(), 1);
			((ITextureGenerator)active_shader.getUniformProvider().getiChannel0()).setRefreshDone();
		}
		
		if (active_shader.getUniformProvider().iChannel1.needsRefresh()) {
			loadTex.loadBufferedImage(((ITextureGenerator)active_shader.getUniformProvider().getiChannel1()).getBufferedImage(), 2);
			((ITextureGenerator)active_shader.getUniformProvider().getiChannel1()).setRefreshDone();
		}
		
		if (active_shader.getUniformProvider().iChannel2.needsRefresh()) {
			loadTex.loadBufferedImage(((ITextureGenerator)active_shader.getUniformProvider().getiChannel2()).getBufferedImage(), 3);
			((ITextureGenerator)active_shader.getUniformProvider().getiChannel2()).setRefreshDone();
		}
		
		if (active_shader.getUniformProvider().iChannel3.needsRefresh()) {
			loadTex.loadBufferedImage(((ITextureGenerator)active_shader.getUniformProvider().getiChannel3()).getBufferedImage(), 4);
			((ITextureGenerator)active_shader.getUniformProvider().getiChannel3()).setRefreshDone();
		}
    }

    private void setUpLight(double now)
    {

        glShadeModel(GL_SMOOTH);
        glEnable(GL_DEPTH_TEST);
        glEnable(GL_LIGHTING);
        //glDisable(GL_LIGHTING);
        
        glEnable(GL_LIGHT0);
        glLightModel(GL_LIGHT_MODEL_AMBIENT, BufferSetup.asFlippedFloatBuffer(new float[]{0.0f, 0.0f, 0.0f, 1f}));
        //glLight(GL_LIGHT0, GL_POSITION, BufferSetup.asFlippedFloatBuffer(new float[]{5, 5, 2, 0.5f}));
        
        //dynamisches Licht
        glLight(GL_LIGHT0, GL_POSITION, BufferSetup.asFlippedFloatBuffer(new float[]{(float)Math.sin(now)*10, (float)Math.cos(now)*10, 1, 0.9f}));
     
        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);
        glEnable(GL_COLOR_MATERIAL);
        glColorMaterial(GL_FRONT, GL_DIFFUSE);
        glColor3f(1.0f, 1.0f, 1.0f);
    }
    


    public void render(double now)
    {

        glPushMatrix();
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glUseProgram(shaderProgram);
        active_shader.pass_uniforms();
        //geometry.drawTorus(0.5f,2.0f,12,24, now);
        geometry.drawPlane(10, 10, 0);
        
        glUseProgram(0);
        glPopMatrix();
    }
    
    
    

    private void initGui(){
    	
    	f_controll = new JFrame();
    	f_visual= new JFrame();
    	
    	webgl_container = new Canvas();
        windowWidth = 800;
        windowHeight = 600;
        
        tabpane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.WRAP_TAB_LAYOUT );
        
        ShaderListPanel shaderlistPanel = new ShaderListPanel();
        EditorPanel editorPanel = new EditorPanel();
        DownloadPanel downloadPanel = new DownloadPanel();
        NodeEditorPanel nodePanel = new NodeEditorPanel();
        
        tabpane.addTab("Available Shaders",shaderlistPanel);
        tabpane.addTab("Live Coding",editorPanel);
        tabpane.addTab("Download new Shaders",downloadPanel);
        tabpane.addTab("Node Editor", nodePanel);
        
        f_visual.getContentPane().add(webgl_container);
        f_controll.getContentPane().add(tabpane);
        
        f_controll.setBounds(windowWidth, 0, 600, windowHeight);
        f_controll.setVisible(true);
        f_controll.setResizable(true);
        
        f_visual.setBounds(0, 0, windowWidth, windowHeight);
        f_visual.setVisible(true);
        f_visual.setResizable(true);
        
        
        active_shader =  new shadertoy();
  		active_shader.set_viewport_width(webgl_container.getWidth());
  		active_shader.set_viewport_height(webgl_container.getHeight());
  		active_shader.initUniformProvider();
        
        
        
        // LISTENER
        
        shaderlistPanel.addListener(this);
        
        tabpane.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
        		ITabbedPanel selected_tab = (ITabbedPanel) tabpane.getComponentAt(tabpane.getSelectedIndex());
        		selected_tab.setActiveShader(active_shader);
        		selected_tab.onTabSelected();
        	}
        });
        

        f_controll.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
            	destroy();
            }
        });
        
        f_visual.addComponentListener(new ComponentListener() {
        	   @Override
        	   public void componentHidden(ComponentEvent e) {
        		   System.out.println("Hidden");
        	   }
        	   @Override
        	   public void componentMoved(ComponentEvent e) {
        	   }
        	   @Override
        	   public void componentResized(ComponentEvent e) {
        	      windowWidth = f_visual.getWidth();
        	      windowHeight = f_visual.getHeight();
        	      
        	      active_shader.set_viewport_width(Display.getWidth());
        	      active_shader.set_viewport_height(Display.getHeight());
        	   }
        	   @Override
        	   public void componentShown(ComponentEvent e) {
        	   }
        	});
        
        
        try {
        	Display.setParent(webgl_container);
            Display.create();
            Display.makeCurrent();      
            //Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            //Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.err.println("The display wasn't initialized correctly. :(");
            Display.destroy();
            System.exit(1);
        }
    }
    
    public void destroy() {
    	running = false;
    	
    	if (WebcamController.getInstance()!=null && WebcamController.getInstance().isReady()) {
    		WebcamController.getInstance().deactivate();
    	}
    	
    	try {
    	    Thread.sleep(1000);                 //1000 milliseconds is one second.
    	} catch(InterruptedException ex) {
    	    Thread.currentThread().interrupt();
    	}
        System.exit(0);//cierra aplicacion
    }
    
    public void run()
    {
    	initGui();
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float r = windowHeight/(float)windowWidth;
        glFrustum(-1,1,-r,r,1,1100);
        //PerspectiveCamera
        //gluPerspective(45f, (float) (windowWidth/windowHeight), 0.3f, 1500f);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_DEPTH_TEST);

        shaderSetup = new ShaderSetup();
        //geometry = new Geometry();
        //loadTex = new ImageSetup();
        setUpShader();
        setUpTextures();
        //setUpLight();

        long start = System.nanoTime();
        lastFPS = getTime();
        lastFP10ms = getTime();
        while(running && !Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
        	
        {
        	//Resize des Frames im Viewport anpassen
        	if (Display.wasResized()) GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
        	
            double now = (System.nanoTime()-start)/1e9;
            render(now);
            Display.update();
            updateFPS();
            setUpLight(now);
        	Display.sync(60);
            //Display.setVSyncEnabled(false);
            //Display.sync(60);
        	
            //Shader in jedem Frame neuladen, das ermöglicht Live im Shadercode änderungen vorzunehmen
        	if (reload_complete_shader__from_file_requested) {setUpShader();}
        	if (active_shader.need_fragment_shader_refresh) {refreshFragmentShader();}
        	
        	setUpTextures();
        	
        }

        glDeleteProgram(shaderProgram);
        Display.destroy();
        //System.exit(0);
    }

    public void updateFPS() {
    	//System.out.println(getTime() - lastFPS );
    	
    	//1x Pro Sekunde FPS updaten
    	
    	
    	if (getTime() - lastFP10ms > 10) { //10ms
    		fp10ms = 0;
    		lastFP10ms+=10;
    	}
    	
    	
    	if (getTime() - lastFPS > 1000) {
    		Display.setTitle("FPS:" + fps);
    		//analyser.setFPS(fps);
    		//tabpane.setTitleAt(1, "Monitoring, FPS:" +fps);
    		f_controll.setTitle("FPS: " +fps);
    		fps = 0;
    		lastFPS += 1000; // eine sekunde hinzufügen
    		
    		// Hier könnte nach 10 sek der Shader gewechselt werden
    		//
    		
    	}
    	fps++;
    	fp10ms++;
    }
    
    public long getTime() {
    	//System Zeit in mms
    	return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }
    
    public static void main(String[] args) throws Exception
    {
        new Main().run();

    }
   }
    


//TODO:
// 0. convertShaderToyToGLSL muss noch die Uniform in den shadercode schreiben!
// 01. Restliche Uniforms auslesen und in den Shader übertragen (Texture etc)
// 1.Shader nicht in jedem Frame neu auslesen bzw nur wenn live editor pane offen ist!
// 2.Nur die benötigten Uniforms generieren und übertragen
// 4. 4 Buffer wie bei https://www.shadertoy.com/view/lst3Df unterstützen
// 5. keine VR shader erlauben bzw so anpassen dass diese wieder funktionieren
//	-> void mainVR( , in vec3 fragRayOri, in vec3 fragRayDir ) {
//	    gl_FragColor = render(fragRayOri, fragRayDir);
//	}
// 6. Performance optimieren (Uniforms nur wenn notwendig erfassen und weiterreichen, etc)
// 7. Mehr Informationen zu den Shadern berreitstellen (mgl. Inputs, shader selber bennenen)
//    MousePos nur abfragen wenn sie auch im Canvas ist
// 8. refreshWebcamPicture nur wenn ein Shader aktiv der auch die Webcam nutzt
// 9. Visualisierungs Fenster von ControllerFenster abkoppeln
// 10. Cache Ebene zw. uniformprovider und shadertoy einbauen 
// 11. iChannelResolution in den Shader übertragen glUniform4v existiert aber leider nicht. wie dann??


