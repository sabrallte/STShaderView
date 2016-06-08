package strategys;

import static org.lwjgl.opengl.GL20.glGetUniformLocation;
import static org.lwjgl.opengl.GL20.glUniform1f;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import org.lwjgl.opengl.GL20;

public class PhongShader extends BaseStrategy{
	

	
	//GUI
    JSlider sliderAmbient = new JSlider();
    JSlider sliderdiffuseWeight = new JSlider();
    JSlider sliderspecularWeight = new JSlider();
    JSlider sliderspecularPow = new JSlider();
    JLabel labelVector = new JLabel("lightDirection:");
    JTextField text_x = new JTextField();
    JTextField text_y = new JTextField();
    JTextField text_z = new JTextField();

    List<JSlider> sliders = new ArrayList<JSlider>();

    
    
    //GUI - Parameter
    float valOftextSliderMultiplicator = 0;
	
	public PhongShader() {
		init_options_panel();
		VERTEX_SHADER_LOCATION = "res/phongVertexShader.vs";
		FRAGMENT_SHADER_LOCATION = "res/phongFragmentShader.fs";
	}

	
    public void pass_uniforms(){
    	
//    	uniform float ambient;
//    	uniform float diffuseWeight;
//    	uniform float specularWeight;
//    	uniform float specularPow;
//    	uniform vec3 lightDirection;  <----- fehlt noch!
        
        int diffuseWeight = glGetUniformLocation(shaderProgram, "diffuseWeight");
        glUniform1f(diffuseWeight, (float)sliderdiffuseWeight.getValue() / 100 );

        
        int ambient = glGetUniformLocation(shaderProgram, "ambient");
        glUniform1f(ambient, (float)sliderAmbient.getValue() / 100 );
        
        int specularWeight = glGetUniformLocation(shaderProgram, "specularWeight");
        glUniform1f(specularWeight, (float)sliderspecularWeight.getValue() / 100 );
        
        int specularPow = glGetUniformLocation(shaderProgram, "specularPow");
        glUniform1f(specularPow, (float)sliderspecularPow.getValue() / 10 );

        int lightDirection = glGetUniformLocation(shaderProgram, "lightDirection");
        
        try {
        	GL20.glUniform3f(lightDirection, Float.parseFloat(text_x.getText()),Float.parseFloat(text_y.getText()),Float.parseFloat(text_z.getText()));
        }
        catch (NumberFormatException e) {
        	GL20.glUniform3f(lightDirection, (float)1.,(float)1.,(float)1. );
        }
        
        }
	
    private void init_options_panel() {
    	
    	optionsPanel.setLayout(new GridLayout(2,0));
        int MAXI = 100;
        sliderAmbient.setBorder(BorderFactory.createTitledBorder("Ambient"));
        sliderdiffuseWeight.setBorder(BorderFactory.createTitledBorder("DiffuseWeight"));
        sliderspecularWeight.setBorder(BorderFactory.createTitledBorder("SpecularWeight"));
        sliderspecularPow.setBorder(BorderFactory.createTitledBorder("SpecularPow"));
        
        sliders.add(sliderAmbient);
        sliders.add(sliderdiffuseWeight);
        sliders.add(sliderspecularWeight);
        sliders.add(sliderspecularPow);
        
        for (JSlider element : sliders) {
        	element.setMaximum(MAXI);
        	element.setValue(50);
        	element.setMajorTickSpacing(MAXI / 5);
        	element.setMinorTickSpacing(MAXI / 20);
        	element.setPaintTicks(true);
        	element.setPaintLabels(true);
        }
        
        

        optionsPanel.add(sliderAmbient);
        optionsPanel.add(sliderdiffuseWeight);
        optionsPanel.add(sliderspecularWeight);
        optionsPanel.add(sliderspecularPow);
        optionsPanel.add(labelVector);
        optionsPanel.add(text_x);
        optionsPanel.add(text_y);
        optionsPanel.add(text_z);
        

    	
    }
    
	
	

}
