package design_pattern.decorator_3.starbuzz;

/**
 * @Author: Alan Ruan
 * @Date: 2019/03/13 15:37:29
 * @Description: //TODO
 */
public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}

	@Override
	public double cost() {
		return .99;
	}
}

