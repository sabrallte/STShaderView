package model;

import com.sun.javafx.geom.Vec3f;
import com.sun.javafx.geom.Vec4f;

import generators.BaseValueGenerator;
import generators.ConstGenerator;
import generators.MouseWGenerator;
import generators.MouseXGenerator;
import generators.MouseYGenerator;
import generators.MouseZGenerator;

public class UniformProvider {
	
	
	int x = 1;  // Laufvariable
	
	public BaseValueGenerator iResolutionX;
	public BaseValueGenerator iResolutionY;
	public BaseValueGenerator iResolutionZ;
	public BaseValueGenerator iMouseX;
	public BaseValueGenerator iMouseY;
	public BaseValueGenerator iMouseZ;
	public BaseValueGenerator iMouseW;
	
	
	public UniformProvider() {
		
		// Der UniformProvider muss immer valide Werte liefern,
		// da diese ohne Prüfung in den Shader übertragen werden!
		
		iResolutionX = new ConstGenerator();
		iResolutionY = new ConstGenerator();
		iResolutionZ = new ConstGenerator();
		iMouseX = new MouseXGenerator();
		iMouseY = new MouseYGenerator();
		iMouseZ = new MouseZGenerator();
		iMouseW = new MouseWGenerator();
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	// iResolution
	
	public void setiResolutionX(BaseValueGenerator iResolutionX){
		if(iResolutionX!= null) {this.iResolutionX = iResolutionX; System.out.println("set iResolutionX: " + iResolutionX);}
	}
	
	public void setiResolutionY(BaseValueGenerator iResolutionY){
		if(iResolutionY!= null) {this.iResolutionY = iResolutionY;System.out.println("set iResolutionY: " + iResolutionY);}
	}
	
	public void setiResolutionZ(BaseValueGenerator iResolutionZ){
		if(iResolutionZ!= null) {this.iResolutionZ = iResolutionZ;System.out.println("set iResolutionZ:" + iResolutionZ);}
	}
	
	
	public Vec3f getiResolution(){
		return new Vec3f((float)iResolutionX.getValue(x), (float)iResolutionY.getValue(x), (float)iResolutionZ.getValue(x));
	}
	
	
	
	// iMouse
	
	public void setiMouseX(BaseValueGenerator iMouseX){
		if(iMouseX!= null) {this.iMouseX = iMouseX; System.out.println("set iMouseX: " + iMouseX);}
	}
	
	public void setiMouseY(BaseValueGenerator iMouseY){
		if(iMouseY!= null) {this.iMouseY = iMouseY; System.out.println("set iMouseY: " + iMouseY);}
	}
	
	public void setiMouseZ(BaseValueGenerator iMouseZ){
		if(iMouseZ!= null) {this.iMouseX = iMouseZ; System.out.println("set iMouseZ: " + iMouseZ);}
	}
	
	public void setiMouseW(BaseValueGenerator iMouseW){
		if(iMouseW!= null) {this.iMouseW = iMouseW; System.out.println("set iMouseW: " + iMouseW);}
	}
	
	public Vec4f getiMouse(){
		return new Vec4f((float)iMouseX.getValue(x), (float)iMouseY.getValue(x), (float)iMouseZ.getValue(x), (float)iMouseW.getValue(x));
	}
	
	
    public static void main(String[] args) throws Exception
    {
        new UniformProvider().getiResolution();

    }

}



