package generators;

import java.awt.MouseInfo;

public class MouseYGenerator extends BaseValueGenerator{

	@Override
	public double getValue(double x) {
		return  MouseInfo.getPointerInfo().getLocation().getY();
	}
}
