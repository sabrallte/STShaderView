package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class SourceCodeLoader {
	String api_key = "Nd8Kw8";
	//https://www.shadertoy.com/api/v1/shaders/ltl3RH?key=Nd8Kw8 --> {"Error":"Shader not found"}
	//https://www.shadertoy.com/api/v1/shaders/query/ltl3RH?key=Nd8Kw8 -->{"Shaders" : 0}
	String[] optional_shaders;
	
	
	public SourceCodeLoader() {}
	
	
	
	public String decodeJSON(String sourcecode) {
		
		JSONParser parser = new JSONParser();
	      String s = "{\"Shader\":{\"ver\":\"0.1\",\"info\":{\"date\":\"1451954508\",\"hasliked\":0,\"viewed\":288,\"name\":\"Game of Life 2\",\"flags\":32,\"description\":\"Game of Life. Mainly used as to demo buffers.\",\"id\":\"Mdc3WS\",\"published\":3,\"username\":\"sixstring982\",\"likes\":8,\"tags\":[\"automata\",\"cellular\"]},\"renderpass\":[{\"outputs\":[{\"channel\":0,\"id\":37}],\"code\":\"void mainImage( out vec4 fragColor, in vec2 fragCoord ) {\\n\\tvec2 uv = fragCoord.xy \\/ iResolution.xy;\\n    fragColor = vec4(uv, 0.5 + 0.5 * sin(iGlobalTime), 1.0);\\n    if (texture2D(iChannel0, uv).g < 0.5) {\\n        fragColor = vec4(1.0) - vec4(fragColor.xyz, 0.0);\\n    }\\n}\",\"inputs\":[{\"ctype\":\"buffer\",\"src\":\"\\/presets\\/previz\\/buffer00.png\",\"channel\":0,\"id\":257,\"sampler\":{\"filter\":\"linear\",\"internal\":\"byte\",\"wrap\":\"clamp\",\"vflip\":\"true\",\"srgb\":\"false\"}}],\"name\":\"Image\",\"description\":\"\",\"type\":\"image\"},{\"outputs\":[{\"channel\":0,\"id\":257}],\"code\":\"#define ON_COLOR vec4(0.0, 1.0, 0.0, 1.0)\\n#define OFF_COLOR vec4(0.0, 0.0, 0.0, 1.0)\\n\\nbool isLive(in vec2 uv) {\\n    return texture2D(iChannel0, uv).g > 0.0;\\n}\\n\\nint countNeighbors(in vec2 c) {\\n    int nc = 0;\\n    vec2 n;\\n    for (int x = -1; x <= 1; x++) {\\n        for (int y = -1; y <= 1; y++) {\\n            if (x != 0 || y != 0) {\\n                n.x = c.x + float(x);\\n                if (n.x < 0.0) {\\n                    n.x = iResolution.x;\\n                } else if (n.x >= iResolution.x) {\\n                    n.x = 0.0;\\n                }\\n                \\n                n.y = c.y + float(y);\\n                if (n.y < 0.0) {\\n                    n.y = iResolution.y;\\n                } else if (n.y >= iResolution.y) {\\n                    n.y = 0.0;\\n                }\\n                \\n                n \\/= iResolution.xy;\\n                \\n                if (isLive(n)) {\\n                    nc++;\\n                }\\n            }\\n        }\\n    }\\n    \\n    return nc;\\n}\\n\\nvoid mainImage(out vec4 fragColor, in vec2 fragCoord ) {\\n    vec2 uv = fragCoord.xy \\/ iResolution.xy;\\n    \\n    if (length(iMouse.xy - fragCoord.xy) < 2.0) {\\n        fragColor = ON_COLOR;\\n        return;\\n    }\\n    \\n    if (iGlobalTime < 1.0) {\\n        if (fragCoord.x > 50.0 &&\\n            fragCoord.x < 50.99 &&\\n            fragCoord.y > 49.0 &&\\n            fragCoord.y < 51.99) {\\n            fragColor = ON_COLOR;\\n        } else if (fragCoord.x > 51.0 &&\\n                   fragCoord.x < 51.99 &&\\n            \\t   fragCoord.y > 51.0 &&\\n                   fragCoord.y < 51.99) {\\n            fragColor = ON_COLOR;\\n        } else if (fragCoord.x > 49.0 &&\\n                   fragCoord.x < 49.99 &&\\n            \\t   fragCoord.y > 50.0 &&\\n                   fragCoord.y < 50.99) {\\n            fragColor = ON_COLOR;\\n        } else {\\n            fragColor = OFF_COLOR;\\n        }\\n    } else {\\n    \\tbool live = isLive(uv);\\n    \\tint nc = countNeighbors(fragCoord);\\n        if ((!live && nc == 3) ||\\n        (live && (nc == 2 || nc == 3))) {\\n        \\tfragColor = ON_COLOR;\\n    \\t} else {\\n\\t        fragColor = OFF_COLOR;\\n\\t    }\\n\\t}\\n}\",\"inputs\":[{\"ctype\":\"buffer\",\"src\":\"\\/presets\\/previz\\/buffer00.png\",\"channel\":0,\"id\":257,\"sampler\":{\"filter\":\"linear\",\"internal\":\"byte\",\"wrap\":\"clamp\",\"vflip\":\"true\",\"srgb\":\"false\"}}],\"name\":\"Buf A\",\"description\":\"\",\"type\":\"buffer\"}]}}";
			
	      try{
	         Object obj = parser.parse(sourcecode);
	         
	         JSONObject jsonObject = (JSONObject) obj;	// [Shader] oder [Error]
	         
	         //Shader nicht gefunden
	         if (!jsonObject.keySet().toString().equals("[Shader]")) {
	         	 return null;}
	        	 
	         jsonObject=  (JSONObject) jsonObject.get("Shader"); // [ver, info, renderpass]
	         JSONArray jsonArray = new JSONArray();
	         jsonArray=  (JSONArray) jsonObject.get("renderpass"); // [ver, info, renderpass]
	         
	         //hier stehen nun unterschiedlich viele Shader zur Verfügung
	         //System.out.println(jsonArray.get(0));	// {"outputs":[{"channel":0,"id":37}],"code":"void mainImage( out vec4 fragColor, in vec2 fragCoord ) 
	         //System.out.println(jsonArray.get(1));  // {"outputs":[{"channel":0,"id":257}],"code":"#define ON_COLOR vec4(0.0, 1.0, 0.0, 1.0)\n#define OFF_CO
	         
	         jsonObject = (JSONObject) jsonArray.get(0); // [outputs, code, inputs, name, description, type]
	         return (String) jsonObject.get("code");
	         
	      }catch(ParseException pe){
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }
		return null;
		
	}
	
	
	public String loadFromID(String id) {
		String website = "https://www.shadertoy.com/api/v1/shaders/" + id + "?key=" + api_key;
		return loadFromURL(website);
	}
	
	public String loadFromURL(String website_url) {
		
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    	
	    try {
	        url = new URL(website_url);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));
	        String code = "";

	        while ((line = br.readLine()) != null) {
	            code += line;
	        }

	        return code;
	        
	    } catch (MalformedURLException mue) {
	         mue.printStackTrace();
	    } catch (IOException ioe) {
	         ioe.printStackTrace();
	    } finally {
	        try {
	            if (is != null) is.close();
	        } catch (IOException ioe) {
	            // nothing to see here
	        }
	    }
		return null;
	}
	
	public String getIDfromURL(String website_url) {
		
		//Extrahiert von https://www.shadertoy.com/view/Ms2SD1
		// deb Wert Ms2SD1
		
		URL url;
		System.out.println("getIDfromURL: " + website_url);
		try { 
			url = new URL(website_url);
			return url.getFile().split("/")[2];
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public String queryFromId(String id) {
		String website = "https://www.shadertoy.com/api/v1/shaders/query/" + id + "?key=" + api_key;
		return loadFromURL(website);
	}
	
	
	public String[] decodeJSONquery(String query) {
		
		//Gibt die Id's zurück die in *query* unter *Results* notiert sind
		
		
		JSONParser parser = new JSONParser();
			
	      try{
	         Object obj = parser.parse(query);
	         
	         JSONObject jsonObject = (JSONObject) obj; // [Results, Shaders]  --> TODO auch mgl: {"Shaders" : 0} wenn trotz query nix gefunden werden kann
	         System.out.println(query);
	         System.out.println(jsonObject.keySet().toString());
	         //Shader nicht gefunden
	         if (jsonObject.keySet().toString().equals("[Error]")) {
	         	 return null;}
	        	 
	         JSONArray jsonArray = new JSONArray();
	         jsonArray=  (JSONArray) jsonObject.get("Results"); // [["Xtl3DX","MdcSzX"]
	         String[] results = (String[]) jsonArray.toArray(new String[0]);
	         return results;
	         
	      }catch(ParseException pe){
			
	         System.out.println("position: " + pe.getPosition());
	         System.out.println(pe);
	      }
		return null;
		
	}
	
	public String convertShaderToyToGLSL(String shader_source) {
		//fragCoord --> gl_FragCoord
		//fragColor --> gl_FragColor
		//void mainImage( out vec4 fragColor, in vec2 fragCoord ) --> void main()
		shader_source = shader_source.replaceAll("fragCoord", "gl_FragCoord");
		shader_source = shader_source.replaceAll("fragColor", "gl_FragColor");
		shader_source = shader_source.replaceAll("mainImage", "main");
		shader_source = shader_source.replaceAll("out vec4 gl_FragColor, in vec2 gl_FragCoord", "");
		
		String uniforms = 	"uniform vec3      iResolution;           // viewport resolution (in pixels)\n" + 
							"uniform float     iGlobalTime;           // shader playback time (in seconds)\n" + 
							"uniform float     iTimeDelta;            // render time (in seconds)\n" + 
							"uniform int       iFrame;                // shader playback frame\n" + 
							"uniform float     iChannelTime[4];       // channel playback time (in seconds)\n" + 
							"uniform vec3      iChannelResolution[4]; // channel resolution (in pixels)\n" + 
							"uniform vec4      iMouse;                // mouse pixel coords. xy: current (if MLB down), zw: click\n" + 
							"\n" + 
							"//uniform samplerXX iChannel0..3;          // input channel. XX = 2D/Cube\n" + 
							"uniform sampler2D iChannel0;\n" + 
							"uniform sampler2D iChannel1;\n" + 
							"uniform sampler2D iChannel2;\n" + 
							"uniform sampler2D iChannel3;\n" + 
							"\n" + 
							"uniform vec4      iDate;                 // (year, month, day, time in seconds)\n" + 
							"uniform float     iSampleRate;           // sound sample rate (i.e., 44100)\n\n"; 
		
		shader_source = uniforms + shader_source;
		
		
		return shader_source;
	}
	
	public String saveShaderToFile(String shader, String path) {
		
		String[] test = shader.split("\n");
		try(  PrintWriter out = new PrintWriter(path)  ){
			
			for (String obj: test){
				out.println( obj );
			}
			
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Saved new Shader to: " + path);
		
		return path;
		
	}
	
	public String load(String web_url, boolean is_ID) {
		
		/*
		 * Als web_url werden URLS oder IDS akzeptiert -> is_ID = true
		 * 
		 * */
		
		
		String id ="";
		String source_code;
		String shader_code;
		String save_to_path = "res/shader/";
		
		
		if (!is_ID) {
			id =  getIDfromURL(web_url);
		}else {id = web_url;}
		
		source_code =  loadFromID(id);
		shader_code =  decodeJSON(source_code);
		
		if (shader_code == null) {
			String query =  queryFromId(id);
			optional_shaders =  decodeJSONquery(query);
			System.out.println(String.format("Keinen eindeutigen Shader für die ID: %s", id)); 
			for (String a : optional_shaders) {
				System.out.println(String.format("Alternativ Shader: %s", a));
			}
			return null;
		}
		
		shader_code =  convertShaderToyToGLSL(shader_code);
		
		Path p1 = Paths.get(save_to_path+ id+".fs");
		String path = saveShaderToFile(shader_code, p1.toAbsolutePath().toString());
		
		return path;
	}
	
	
	public String[] getOptionalShaders() {
		if(optional_shaders.length > 0) {
			return optional_shaders;
		}
		else { return null;}
	}
	


	
	public static void main(String[] args) {
		String web_url ="https://www.shadertoy.com/view/Ms2SD1";
		
		SourceCodeLoader scl = new SourceCodeLoader();
		System.out.println(scl.load(web_url, false));
	}

}
