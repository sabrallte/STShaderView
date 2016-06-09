package generators;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BaseValueGenerator {
	
	int amplitude;
	
	public BaseValueGenerator() {
		this.amplitude = 1;
	}
	
	public BaseValueGenerator(int amplitude) {
		this.amplitude = amplitude;
	}
	
	public double getValue(double x) {
		throw new NotImplementedException();
	}

	public void setAmpltitude(int val) {
		this.amplitude = val;		
	}

}
