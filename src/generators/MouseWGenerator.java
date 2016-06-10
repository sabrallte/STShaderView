package generators;


import org.lwjgl.input.Mouse;

public class MouseWGenerator extends BaseValueGenerator{

	@Override
	public double getValue(double x) {
		return  (Mouse.isButtonDown(1)? 1 : 0);
	}
}
