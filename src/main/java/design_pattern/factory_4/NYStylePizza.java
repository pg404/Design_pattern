package main.java.design_pattern.factory_4;

/**
 * Project:Exercise
 * Package:main.java.design_pattern.factory_4
 * Author:Alan Ruan
 * Date:2018-09-22 17:42
 * Description://TODO
 */
public class NYStylePizza extends Pizza {

    public NYStylePizza(String item){
        if (item.equals("cheese")){
            System.out.println("NYCheesePizza");
        }else if (item.equals("veggie")){
            System.out.println("NYVeggiePizza");
        }else if (item.equals("clam")){
            System.out.println("NYClamPizza");
        }else if (item.equals("pepperonic")){
            System.out.println("NYPepperonicPizza");
        }
    }

}
