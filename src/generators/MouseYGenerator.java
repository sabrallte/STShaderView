package generators;

import java.awt.MouseInfo;

public class MouseYGenerator extends BaseValueGenerator{

	@Override
	public double getValue(double x) {
		try {
			return  MouseInfo.getPointerInfo().getLocation().getY();
		}
		catch(NullPointerException e) {
			System.out.println("MouseXGenerator: NullPointerException");
		}
		return 0;
	}
}
