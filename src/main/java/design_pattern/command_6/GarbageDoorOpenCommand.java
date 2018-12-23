package design_pattern.command_6;

/**
 * Project:Exercise
 * Package:main.java.design_pattern.command_6
 * Author:Alan Ruan
 * Date:2018-09-24 00:59
 * Description://TODO
 */
public class GarbageDoorOpenCommand implements Command {

    GarbageDoor garbageDoor;

    @Override
    public void execute() {
        garbageDoor.up();
    }

    public GarbageDoorOpenCommand(GarbageDoor garbageDoor){
        this.garbageDoor = garbageDoor;
    }



}
