package generators;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BaseValueGenerator {
	
	int amplitude = 1;
	double value = 1;
	
	public BaseValueGenerator() {
		this.amplitude = 1;
	}
	
	public BaseValueGenerator(int amplitude) {
		this.amplitude = amplitude;
	}
	
	public double getValue(double x) {
		// von laufvariable x abh�ngige Werte
		// da x durch shadertoy gesetzt wird, gibt der 
		// BaseValueGenerator immer den aktuellen Frame zur�ck
		return x;
	}
	
	public double getValue() {
		// f�r konstante werte
		throw new NotImplementedException();
	}
	
	public void setValue(double value) {
		this.value = value;
	}

	public void setAmpltitude(int val) {
		this.amplitude = val;		
	}

}
