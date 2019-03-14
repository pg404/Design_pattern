package design_pattern.decorator_3.starbuzz;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}

	@Override
	public double cost() {
		return 1.05;
	}
}

