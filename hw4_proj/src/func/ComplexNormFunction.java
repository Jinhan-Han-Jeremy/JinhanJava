package func;

public class ComplexNormFunction implements DoubleFunctionOfTwoInts {

	@Override
	public double fOfXY(int x, int y) {
		Complex Original = new Complex(x, y);
		Complex cpl = new Complex(Original);

		return cpl.norm();
	}

	@Override
	public String getName() {
		return "ComplexNorm";
	}

}
