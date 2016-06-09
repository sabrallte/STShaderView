package generators;


public class LogGenerator extends BaseValueGenerator{
	
	public LogGenerator(int amplitude) {
		super(amplitude);
	}
	
	
	@Override
	public double getValue(double x) {
		return Math.log(x) * amplitude;
	}
}
