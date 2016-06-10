package strategys;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform2f;

import javax.swing.JPanel;

import org.lwjgl.Sys;

import model.UniformProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
public class BaseStrategy {
	
	protected JPanel optionsPanel = new JPanel();
	String VERTEX_SHADER_LOCATION = null;
	String FRAGMENT_SHADER_LOCATION = null;
	int shaderProgram = -1;
	int viewport_width = 0;
	int viewport_height = 0;
	long start_time = (Sys.getTime()) / Sys.getTimerResolution();
	int frame = 0; 
	UniformProvider uniform_provider = null;
	
	//System Zeit in mms
	
	private void init_options_panel() {throw new NotImplementedException();}

	public void pass_uniforms(){throw new NotImplementedException();}
	

	public JPanel get_options_panel() {
		return optionsPanel;
	}
	
	public String getVertexShaderLocation(){
		return VERTEX_SHADER_LOCATION;
	}
	
	public String getFragmentShaderLocation(){
		return FRAGMENT_SHADER_LOCATION;
	}
	
	public void setFragmentShaderLocation(String value){
		 FRAGMENT_SHADER_LOCATION = value;
	}
	
    public void set_shader_program(int number) {
    	shaderProgram = number;
    }
    
    public void set_viewport_width(int width) {
    	viewport_width = width;
    }
    
    public void set_viewport_height(int height) {
    	viewport_height = height;
    }
    public void setUniformProvider(UniformProvider uniform_provider) {
    	this.uniform_provider = uniform_provider;
    }
    public UniformProvider getUniformProvider() {
    	return this.uniform_provider;
    }


}
