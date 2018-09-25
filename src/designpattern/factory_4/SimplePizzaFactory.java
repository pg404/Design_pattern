package designpattern.factory_4;

/**
 * Project:Exercise
 * Package:designpattern.factory_4
 * Author:Alan Ruan
 * Date:2018-09-22 16:47
 * Description://TODO
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type){
        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else if (type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        }else if (type.equals("clam")){
            pizza = new ClamPizza();
        }else if (type.equals("veggie")){
            pizza = new VeggiePizza();
        }

        return pizza;

    }

}
