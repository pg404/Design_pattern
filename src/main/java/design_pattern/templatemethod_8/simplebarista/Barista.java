package design_pattern.templatemethod_8.simplebarista;

public class Barista {
 
	public static void main(String[] args) {
		Tea tea = new Tea();
		Coffee coffee = new Coffee();
		System.out.println("Making tea...");

		System.out.println(" ");

		System.out.println("Making coffee...");
		coffee.prepareRecipe();
	}
}
