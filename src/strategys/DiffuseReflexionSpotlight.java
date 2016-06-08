package strategys;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform1f;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class DiffuseReflexionSpotlight  extends DiffuseReflexion{
	

	
	public DiffuseReflexionSpotlight(){
		
		VERTEX_SHADER_LOCATION = "res/diffuse_reflexion_mit_positionslicht.vs";
		FRAGMENT_SHADER_LOCATION = "res/diffuse_reflexion.fs";
		
	}

}