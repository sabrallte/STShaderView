package helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IO {
	
	public static String readFile(String path) {
		StringBuilder vertexShaderSource = new StringBuilder();
		BufferedReader vertexShaderFileReader = null;
		try {
			vertexShaderFileReader = new BufferedReader(new FileReader(path));
            String line;
            while((line = vertexShaderFileReader.readLine()) != null) {
                vertexShaderSource.append(line).append('\n');
            }
        }catch(IOException e) {
            e.printStackTrace();
            return null;
        }finally {
            if(vertexShaderFileReader != null) {
                try {
                    vertexShaderFileReader.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return vertexShaderSource.toString();
	}
	

}
