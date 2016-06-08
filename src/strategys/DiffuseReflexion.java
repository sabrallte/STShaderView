package strategys;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform1f;
import static org.lwjgl.opengl.GL20.glUniform2f;

import java.awt.MouseInfo;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class DiffuseReflexion  extends BaseStrategy{
	
	
	//GUI
    JSlider sliderAmbient = new JSlider();
    JLabel labelDiffuseWeight = new JLabel("diffuseWeight");
    
    
    //GUI - Parameter
    float valOftextSliderMultiplicator = 0;
	
	public DiffuseReflexion() {
		init_options_panel();
		VERTEX_SHADER_LOCATION = "res/diffuse_reflexion.vs";
		FRAGMENT_SHADER_LOCATION = "res/diffuse_reflexion.fs";
	}

	
    public void pass_uniforms(){
    	//uniform float diffuseWeight;
        
        int diffuseWeight = glGetUniformLocation(shaderProgram, "diffuseWeight");
        glUniform1f(diffuseWeight, (float)sliderAmbient.getValue() / 100 );
        
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
