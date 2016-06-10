package initSetups; 
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL20.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShaderSetup {
	
	private static String fragment_shader = null;
	private static String vertex_shader = null;
	
	public static int ReadAndloadFragmentShaderFromString(String fs) {
		
		if(fragment_shader == null) {
			throw new NullPointerException();
		}
		
		fragment_shader = fs;
		return loadShaderSources(vertex_shader, fragment_shader );
	}
	
	
	public static int readAndloadShadersFromFile(String vertexShaderLocation, String fragmentShaderLocation) {
		
		 	StringBuilder vertexShaderSource = new StringBuilder();
	        StringBuilder fragmentShaderSource = new StringBuilder();
	        BufferedReader vertexShaderFileReader = null;

	        try {
	            vertexShaderFileReader = new BufferedReader(new FileReader(vertexShaderLocation));
	            String line;
	            while((line = vertexShaderFileReader.readLine()) != null) {
	                vertexShaderSource.append(line).append('\n');
	            }
	        }catch(IOException e) {
	            e.printStackTrace();
	            return -1;
	        }finally {
	            if(vertexShaderFileReader != null) {
	                try {
	                    vertexShaderFileReader.close();
	                }catch(IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	        BufferedReader fragmentShaderFileReader = null;
	        try {
	            fragmentShaderFileReader = new BufferedReader(new FileReader(fragmentShaderLocation));
	            String line;
	            while((line = fragmentShaderFileReader.readLine()) != null) {
	                fragmentShaderSource.append(line).append('\n');
	            }
	        }catch(IOException e) {
	            e.printStackTrace();
	            return -1;
	        }finally {
	            if(fragmentShaderFileReader != null) {
	                try {
	                    fragmentShaderFileReader.close();
	                }catch(IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	        fragment_shader = fragmentShaderSource.toString();
	        vertex_shader = vertexShaderSource.toString();
	        
		return loadShaderSources(vertex_shader,fragment_shader);
	}
	

    public static int loadShaderSources(String vertexShaderSource, String fragmentShaderSource)
    {
        int shaderProgram = glCreateProgram();
        int vertexShader = glCreateShader(GL_VERTEX_SHADER);
        int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
       

        glShaderSource(vertexShader, vertexShaderSource);
        glCompileShader(vertexShader);
        if (glGetShaderi(vertexShader, GL_COMPILE_STATUS) == GL_FALSE) {
            System.err.println("Vertex shader wasn't able to be compiled correctly. Error log:");
            System.err.println(glGetShaderInfoLog(vertexShader, 1024));
            return -1;
        }
        glShaderSource(fragmentShader, fragmentShaderSource);
        glCompileShader(fragmentShader);
        if (glGetShaderi(fragmentShader, GL_COMPILE_STATUS) == GL_FALSE) {
            System.err.println("Fragment shader wasn't able to be compiled correctly. Error log:");
            System.err.println(glGetShaderInfoLog(fragmentShader, 1024));
        }

        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);

        glLinkProgram(shaderProgram);

        glDeleteShader(vertexShader);
        glDeleteShader(fragmentShader);

        return shaderProgram;
    }

}
