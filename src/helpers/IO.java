package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
	
	
	public static String saveShaderToFile(String shader, String path) {
			
			String[] test = shader.split("\n");
			try(  PrintWriter out = new PrintWriter(path)  ){
				
				for (String obj: test){
					out.println( obj );
				}
				
			    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("File to: " + path);
			
			return path;
			
		}
	
	

}
