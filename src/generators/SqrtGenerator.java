package generators;


public class SqrtGenerator extends BaseValueGenerator{
	
	public SqrtGenerator(int amplitude) {
		super(amplitude);
	}
	
	
	@Override
	public double getValue(double x) {
		return Math.sqrt(x) * amplitude;
	}
}
