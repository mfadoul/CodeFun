package gmu.masters.swe637.hw2;

public class Fraction {

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		
		++numberOfFractions;
	}

	public Fraction() {
		this(0, 1);
	}

	@Override
	public boolean equals(Object obj) {
		if (!Fraction.class.isInstance(obj)) {
			return false;
		}
		
		Fraction otherFraction = (Fraction) obj;
		
		if (this.getDenominator() != otherFraction.getDenominator()) {
			return false;
		}

		if (this.getNumerator() != otherFraction.getNumerator()) {
			return false;
		}

		return true;
	}

	@Override
	public Object clone() {
		return (new Fraction (this.numerator, this.denominator));
	}

	public static int GetNumFracs() {
		return numberOfFractions;
	}

	public void Add(Fraction fraction2) {
		if (this.getDenominator() == fraction2.getDenominator()) {
			this.numerator += fraction2.getNumerator();
		} else {
			System.out.println("Fraction add error: Denominators must be the same.");
			return;
		}
		
	}

	public void Multiply(Fraction fraction2) {
		this.numerator *= fraction2.getNumerator();
		this.denominator *= fraction2.getDenominator();
	}

	public void PrintFrac() {
		System.out.println(this);
	}
	
	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return (this.numerator + " / " + this.denominator);
		
	}
	
	private int numerator;
	private int denominator;

	static private int numberOfFractions = 0;
}
