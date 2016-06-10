package generators;

import org.lwjgl.input.Mouse;

public class MouseZGenerator extends BaseValueGenerator{

	@Override
	public double getValue(double x) {
		return  (Mouse.isButtonDown(0)? 1 : 0);
	}
}
