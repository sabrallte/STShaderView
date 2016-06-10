package model;

import com.sun.javafx.geom.Vec3f;

import generators.BaseValueGenerator;

public class UniformProvider {
	
	// der UnifromProvider muss immer valide werte liefern!
	
	int x = 0;
	
	BaseValueGenerator iResolutionX;
	BaseValueGenerator iResolutionY;
	BaseValueGenerator iResolutionZ;
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setiResolutionX(BaseValueGenerator iResolutionX){
		this.iResolutionX = iResolutionX;
	}
	
	public void setiResolutionY(BaseValueGenerator iResolutionY){
		this.iResolutionY = iResolutionY;
	}
	
	public void setiResolutionZ(BaseValueGenerator iResolutionZ){
		this.iResolutionZ = iResolutionZ;
	}
	
	
	public Vec3f getiResolution(){
		return new Vec3f((float)iResolutionX.getValue(x), (float)iResolutionY.getValue(x), (float)iResolutionZ.getValue(x));
	}
	
	

}
