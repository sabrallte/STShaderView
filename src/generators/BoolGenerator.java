package generators;


public class BoolGenerator extends BaseValueGenerator{
	
	
	public BoolGenerator(int value){
		// Boolean wird auf 1 und 0 abgebildet da im Shader keine Boolwerte angewendet werden
		this.value = value;
	}
	
	@Override
	public double getValue(double x) {
		return this.value;
	}
}
