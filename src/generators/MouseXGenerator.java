package generators;

import java.awt.MouseInfo;

public class MouseXGenerator extends BaseValueGenerator{

	@Override
	public double getValue(double x) {
		
		try {
			return  MouseInfo.getPointerInfo().getLocation().getX();
		}
		catch(NullPointerException e) {
			System.out.println("MouseXGenerator: NullPointerException");
		}
		return 0;
		
		
	}
}
