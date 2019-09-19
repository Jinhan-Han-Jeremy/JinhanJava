package func;

public class ComplexSquaredNormFunction implements DoubleFunctionOfTwoInts {
	@Override
	public double fOfXY(int x, int y) {
		Complex Original = new Complex(x, y);
		Complex cpl = new Complex(Original);

		return (cpl.norm()) * (cpl.norm());
	}

	@Override
	public String getName() {
		return "ComplexSquaredNorm";
	}

}
