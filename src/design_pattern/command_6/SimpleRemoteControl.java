package design_pattern.command_6;

/**
 * Project:Exercise
 * Package:design_pattern.command_6
 * Author:Alan Ruan
 * Date:2018-09-24 00:53
 * Description://TODO
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl(){
    }

    public void setCommand(Command command){
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }

}
