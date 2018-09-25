package designpattern.command_6;

/**
 * Project:Exercise
 * Package:designpattern.command_6
 * Author:Alan Ruan
 * Date:2018-09-24 00:51
 * Description://TODO
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
