package designpattern.factory_4;

/**
 * Project:Exercise
 * Package:designpattern.factory_4
 * Author:Alan Ruan
 * Date:2018-09-22 17:23
 * Description://TODO
 */
public abstract class PizzaStore {

    SimplePizzaFactory simplePizzaFactory;

    public PizzaStore(SimplePizzaFactory simplePizzaFactory){
        this.simplePizzaFactory = simplePizzaFactory;
    }

    public PizzaStore(){}

    public Pizza orderPizza(String type){

        Pizza pizza;
        pizza = createPizza(type);  //simplePizzaFactory.createPizza(type);

        pizza.prepare();
        pizza.bake();;
        pizza.cut();
        pizza.box();

        return pizza;

    }

     abstract Pizza createPizza(String type);

}
