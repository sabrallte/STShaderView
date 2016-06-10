package strategys;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL20.*;

import java.awt.AWTEvent;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.time.LocalDateTime;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL21;

import com.sun.javafx.geom.Vec3d;

import generators.BaseValueGenerator;
import model.UniformProvider;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;;

public class shadertoy  extends BaseStrategy{
	
	
	
	
	//GUI
    JSlider sliderAmbient = new JSlider();
    JLabel labelDiffuseWeight = new JLabel("diffuseWeight");
    String vertex_shader = null;
    String fragment_shader = null;
    public boolean need_fragment_shader_refresh = false;
	
    
    
    public String getFragmentShader() {
		return fragment_shader;
	}


	public void setFragmentShader(String fragment_shader) {
		this.fragment_shader = fragment_shader;
		this.need_fragment_shader_refresh = true;
	}
	
	public void fragmentShaderRefreshDone() {
		this.need_fragment_shader_refresh = false;
	}
	
	
	public shadertoy() {
		init_options_panel();
		VERTEX_SHADER_LOCATION = "res/shader/vertex/shadertoy.vs";
		FRAGMENT_SHADER_LOCATION = "res/shader/fragment/shadertoy2.fs";
	}

	
    public void pass_uniforms(){
    	frame++;
    	
    	//uniform float diffuseWeight;
    	int tex[] = {1,2,3,4}; //static GLenum tex[4];
    	Random randomno = new Random();
    	   // check next float value  
    	
    	uniform_provider.setX(frame);
    	
    	float rand = randomno.nextFloat();
        int iResolution = glGetUniformLocation(shaderProgram, "iResolution");
        int iGlobalTime = glGetUniformLocation(shaderProgram, "iGlobalTime");
        int iTimeDelta = glGetUniformLocation(shaderProgram, "iTimeDelta");
        int iFrame = glGetUniformLocation(shaderProgram, "iFrame");
        int iChannelTime = glGetUniformLocation(shaderProgram, "iChannelTime");
        int iChannelResolution = glGetUniformLocation(shaderProgram, "iChannelResolution");
        int iMouse = glGetUniformLocation(shaderProgram, "iMouse");
        int iChannel0 = glGetUniformLocation(shaderProgram, "iChannel0");
        int iChannel1 = glGetUniformLocation(shaderProgram, "iChannel1");
        int iChannel2 = glGetUniformLocation(shaderProgram, "iChannel2");
        int iChannel3 = glGetUniformLocation(shaderProgram, "iChannel3");
        int iDate = glGetUniformLocation(shaderProgram, "iDate");
        int iSampleRate = glGetUniformLocation(shaderProgram, "iSampleRate");
        
        //Floats
        glUniform1f(iGlobalTime,  (float)(((float) Sys.getTime()) / Sys.getTimerResolution()  - start_time)  ); //auf 4 Stellen genau
        glUniform1f(iTimeDelta, randomno.nextFloat() );
        glUniform4f(iChannelTime, (float)randomno.nextFloat() , (float)randomno.nextFloat() , (float)randomno.nextFloat() , (float)randomno.nextFloat() );
        glUniform1f(iSampleRate, randomno.nextFloat() * 44100);

        //vec3
    	glUniform3f(iResolution,  uniform_provider.getiResolution().x, uniform_provider.getiResolution().y, uniform_provider.getiResolution().z);
        	
        // Auflösung von jedem der 4 Kanäle
    	
/*    	java.nio.FloatBuffer iChannelResolutionXX_buffer = BufferUtils.createFloatBuffer(12);; 
    	iChannelResolutionXX_buffer.reset();
    	
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().x);
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().y);
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().z);
    	
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().x);
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().y);
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().z);
    	
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().x);
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().y);
    	iChannelResolutionXX_buffer.put(uniform_provider.getiChannelResolution0X().z);
    	GL21.glUniformMatrix4x3(iChannelResolution, false, iChannelResolutionXX_buffer);*/
    	
    	//vec4
        try {
        	glUniform4f(iMouse, uniform_provider.getiMouse().x,uniform_provider.getiMouse().y,  uniform_provider.getiMouse().z, uniform_provider.getiMouse().w);
        	}
        catch (Exception e) {
        	System.out.println("Error while passing MouseInfo into the Shader");
        	glUniform4f(iMouse, 0,0,0,0);
        }
        
        glUniform4i(iDate, uniform_provider.getiDateX(), uniform_provider.getiDateY(), uniform_provider.getiDateZ(), uniform_provider.getiDateW()); //(year, month, day, time in seconds)
        
        //int
        glUniform1i(iFrame, uniform_provider.getiFrame());
        
        //iChannel
        glActiveTexture (GL_TEXTURE0 + 0);
        glBindTexture (GL_TEXTURE_2D, tex[0]);
        glUniform1i (iChannel0, 0);
        
        glActiveTexture (GL_TEXTURE0 + 1);
        glBindTexture (GL_TEXTURE_2D, tex[1]);
        glUniform1i (iChannel1, 1);
        
        glActiveTexture (GL_TEXTURE0 + 2);
        glBindTexture (GL_TEXTURE_2D, tex[2]);
        glUniform1i (iChannel2, 2);
        
        glActiveTexture (GL_TEXTURE0 + 3);
        glBindTexture (GL_TEXTURE_2D, tex[3]);
        glUniform1i (iChannel3, 3);
        
        /*
         	uniform vec3      iResolution;           // viewport resolution (in pixels)
			uniform float     iGlobalTime;           // shader playback time (in seconds)
			uniform float     iTimeDelta;            // render time (in seconds)
			uniform int       iFrame;                // shader playback frame
			uniform float     iChannelTime[4];       // channel playback time (in seconds)
			uniform vec3      iChannelResolution[4]; // channel resolution (in pixels)
			uniform vec4      iMouse;                // mouse pixel coords. xy: current (if MLB down), zw: click
			
			//uniform samplerXX iChannel0..3;          // input channel. XX = 2D/Cube
			
			uniform sampler2D iChannel1;
			uniform sampler2D iChannel2;
			uniform sampler2D iChannel3;
			
			uniform vec4      iDate;                 // (year, month, day, time in seconds)
			uniform float     iSampleRate;           // sound sample rate (i.e., 44100)
         */
        
    }
    
    public void initUniformProvider() {
    	
    	uniform_provider = new UniformProvider();
    	uniform_provider.iResolutionX.setValue(viewport_width);
    	uniform_provider.iResolutionY.setValue(viewport_height);
    	uniform_provider.iResolutionZ.setValue(1);
    }
	
    private void init_options_panel() {
        int MAXI = 100;
        sliderAmbient.setBorder(BorderFactory.createTitledBorder("diffuseWeight"));
        sliderAmbient.setMaximum(MAXI);
        sliderAmbient.setValue(50);
        sliderAmbient.setMajorTickSpacing(MAXI / 5);
        sliderAmbient.setMinorTickSpacing(MAXI / 20);
        sliderAmbient.setPaintTicks(true);
        sliderAmbient.setPaintLabels(true);
        

        optionsPanel.add(labelDiffuseWeight);
        optionsPanel.add(sliderAmbient);

    	
    }
    
}
