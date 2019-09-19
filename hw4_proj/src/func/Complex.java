package func;

public class Complex {
	private double real;
	private double imaginary;

	public Complex(double real, double imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}

	public Complex(Complex source) {
		this.real = source.getReal();
		this.imaginary = source.getImaginary();
	}

	// Getter method.
	public double getReal() {
		return real;
	}

	// Getter method.
	public double getImaginary() {
		return imaginary;
	}

	public static Complex add(Complex c1, Complex c2) {
		double reall;
		double img;
		reall = c1.getReal() + c2.getReal();
		img = c1.getImaginary() + c2.getImaginary();
		Complex cx = new Complex(reall, img);
		return cx;
	}

	public static Complex multiply(Complex c1, Complex c2) {
		double reall;
		double img;
		reall = c1.getReal() * c2.getReal();
		reall += c1.getImaginary() * c2.getImaginary() * -1.0;
		img = c1.getReal() * c2.getImaginary();
		img += c2.getReal() * c1.getImaginary();
		Complex cx = new Complex(reall, img);
		return cx;

	}

	public double norm() {
		double norm = Math.sqrt(Math.pow(real, 2.0) + Math.pow(imaginary, 2.0));
		return norm;

	}
}
