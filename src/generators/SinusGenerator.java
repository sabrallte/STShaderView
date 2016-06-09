package generators;


public class SinusGenerator extends BaseValueGenerator{
	
	public SinusGenerator(int amplitude) {
		super(amplitude);
	}
	
	
	@Override
	public double getValue(double x) {
		return Math.sin(x) * amplitude;
	}
}
