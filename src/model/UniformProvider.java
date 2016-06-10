package model;

import java.time.LocalDateTime;

import com.sun.javafx.geom.Vec3f;
import com.sun.javafx.geom.Vec4f;

import generators.BaseValueGenerator;
import generators.ConstGenerator;
import generators.MouseWGenerator;
import generators.MouseXGenerator;
import generators.MouseYGenerator;
import generators.MouseZGenerator;
import generators.PictureGenerator;
import generators.WebcamGenerator;
import interfaces.ITextureGenerator;

public class UniformProvider {
	
	
	int x = 1;  // Laufvariable
	
	public BaseValueGenerator iResolutionX;
	public BaseValueGenerator iResolutionY;
	public BaseValueGenerator iResolutionZ;
	public BaseValueGenerator iMouseX;
	public BaseValueGenerator iMouseY;
	public BaseValueGenerator iMouseZ;
	public BaseValueGenerator iMouseW;
	public ITextureGenerator iChannel0;
	public ITextureGenerator iChannel1;
	public ITextureGenerator iChannel2;
	public ITextureGenerator iChannel3;
	public BaseValueGenerator iChannelResolution0X;
	public BaseValueGenerator iChannelResolution0Y;
	public BaseValueGenerator iChannelResolution0Z;
	
	public BaseValueGenerator iDateX;
	public BaseValueGenerator iDateY;
	public BaseValueGenerator iDateZ;
	public BaseValueGenerator iDateW;
	
	public BaseValueGenerator iSampleRate;
	
	public BaseValueGenerator iFrame;
	
	
	public UniformProvider() {
		
		// Der UniformProvider muss immer valide Werte liefern,
		// da diese ohne Prüfung in den Shader übertragen werden!
		System.out.println("new UniformProvider");
		iResolutionX = new ConstGenerator();
		iResolutionY = new ConstGenerator();
		iResolutionZ = new ConstGenerator();
		iMouseX = new MouseXGenerator();
		iMouseY = new MouseYGenerator();
		iMouseZ = new MouseZGenerator();
		iMouseW = new MouseWGenerator();
		iChannel0 = new WebcamGenerator();
		
		iChannel1 = new PictureGenerator("res/textures/1.png");
		iChannel2 = new PictureGenerator("res/textures/2.png");
		iChannel3 = new PictureGenerator("res/textures/3.png");
		
		iChannelResolution0X = new ConstGenerator();
		iChannelResolution0Y = new ConstGenerator();
		iChannelResolution0Z = new ConstGenerator();
		
		iFrame = new BaseValueGenerator();
		
		iDateX = new ConstGenerator(LocalDateTime.now().getYear());
		iDateY = new ConstGenerator(LocalDateTime.now().getMonthValue());
		iDateZ = new ConstGenerator(LocalDateTime.now().getMinute());
		iDateW = new ConstGenerator(LocalDateTime.now().getSecond());
		
		iSampleRate = new ConstGenerator(44000);
		
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
	
	
	// iChannel0
	public void setiChannel0(ITextureGenerator iChannel0){
		if(iChannel0!= null) {this.iChannel0 = iChannel0; System.out.println("set iChannel0: " + iChannel0);}
	}
	
	public ITextureGenerator getiChannel0() {
		return iChannel0;
		}
	
	// iChannel1
	public void setiChannel1(ITextureGenerator iChannel1){
		if(iChannel1!= null) {this.iChannel1 = iChannel1; System.out.println("set iChannel1: " + iChannel1);}
	}
	
	public ITextureGenerator getiChannel1() {
		return iChannel1;
		}
	
	// iChannel2
	public void setiChannel2(ITextureGenerator iChannel2){
		if(iChannel2!= null) {this.iChannel2 = iChannel2; System.out.println("set iChannel2: " + iChannel2);}
	}
	
	public ITextureGenerator getiChannel2() {
		return iChannel2;
		}
	
	// iChannel3
	public void setiChannel3(ITextureGenerator iChannel3){
		if(iChannel3!= null) {this.iChannel3 = iChannel3; System.out.println("set iChannel3: " + iChannel3);}
	}
	
	public ITextureGenerator getiChannel3() {
		return iChannel3;
		}
	
	
	// iChannelResolution 0 TODO: noch nicht in shadertoy umgesetzt
	public void setiChannelResolution0X(BaseValueGenerator iChannelResolution0X){
		if(iChannelResolution0X!= null) {this.iChannelResolution0X = iChannelResolution0X;System.out.println("set iChannelResolution0X:" + iChannelResolution0X);}
	}
	
	public void setiChannelResolution0Y(BaseValueGenerator iChannelResolution0Y){
		if(iChannelResolution0Y!= null) {this.iChannelResolution0Y = iChannelResolution0Y;System.out.println("set iChannelResolution0Y:" + iChannelResolution0Y);}
	}
	
	public void setiChannelResolution0Z(BaseValueGenerator iChannelResolution0Z){
		if(iChannelResolution0Z!= null) {this.iChannelResolution0Z = iChannelResolution0Z;System.out.println("set iChannelResolution0Z:" + iChannelResolution0Z);}
	}
	
	public Vec3f getiChannelResolution0X(){
		return new Vec3f((float)iChannelResolution0X.getValue(x), (float)iChannelResolution0X.getValue(x), (float)iChannelResolution0X.getValue(x));
	}
	
	// iFrame
	public void setiFrame(BaseValueGenerator iFrame){
		if(iFrame!= null) {this.iFrame = iFrame;System.out.println("set iFrame:" + iFrame);}
	}
	
	public int getiFrame(){
		return (int) this.iFrame.getValue(x);
	}
	
	// iDateX
	public void setiDateX(BaseValueGenerator iDateX){
		if(iDateX!= null) {this.iDateX = iDateX;System.out.println("set iDateX:" + iDateX);}
	}
	
	public int getiDateX(){
		return (int) this.iDateX.getValue(x);
	}
	
	// iDateY
	public void setiDateY(BaseValueGenerator iDateY){
		if(iDateY!= null) {this.iDateY = iDateY;System.out.println("set iDateY:" + iDateY);}
	}
	
	public int getiDateY(){
		return (int) this.iDateY.getValue(x);
	}
	
	// iDateZ
	public void setiDateZ(BaseValueGenerator iDateZ){
		if(iDateZ!= null) {this.iDateZ = iDateZ;System.out.println("set iDateZ:" + iDateZ);}
	}
	
	public int getiDateZ(){
		return (int) this.iDateZ.getValue(x);
	}
	
	// iDateW
	public void setiDateW(BaseValueGenerator iDateW){
		if(iDateW!= null) {this.iDateW = iDateW;System.out.println("set iDateW:" + iDateW);}
	}
	
	public int getiDateW(){
		return (int) this.iDateW.getValue(x);
	}
	
	// iSampleRate
	public void setiSampleRate(BaseValueGenerator iSampleRate){
		if(iSampleRate!= null) {this.iSampleRate = iSampleRate;System.out.println("set iSampleRate:" + iSampleRate);}
	}
	
	public double getiSampleRate(){
		return  this.iSampleRate.getValue(x);
	}
	
	
    // helpers
    public boolean needsTextureRefresh() {
    	// TODO weitere Channel abfragen wenn eingebunden
    	if(iChannel0.needsRefresh()) {return true;}
    	return false;
    }

	
	
    public static void main(String[] args) throws Exception
    {
        new UniformProvider().getiResolution();

    }
    
    

}



