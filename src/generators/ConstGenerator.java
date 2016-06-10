package generators;


public class ConstGenerator extends BaseValueGenerator{
	
	
	
	public ConstGenerator(double value) {
		this.setValue(value);
	}
	
	public ConstGenerator() {
	}

	@Override
	public double getValue(double x) {
		return this.value;
	}
}
