package generators;


public class FloorGenerator extends BaseValueGenerator{
	
	public FloorGenerator(int amplitude) {
		super(amplitude);
	}
	
	@Override
	public double getValue(double x) {
		return Math.floor(x) * amplitude;
	}
}
