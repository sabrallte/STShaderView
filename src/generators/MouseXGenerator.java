package generators;

import java.awt.MouseInfo;

public class MouseXGenerator extends BaseValueGenerator{

	@Override
	public double getValue(double x) {
		return  MouseInfo.getPointerInfo().getLocation().getX();
	}
}
