package generators;


public class NoiseGenerator extends BaseValueGenerator{
	
	public NoiseGenerator(int amplitude) {
		super(amplitude);
	}
	
	
	@Override
	public double getValue(double x) {
		return Math.random() * amplitude;
	}
}
