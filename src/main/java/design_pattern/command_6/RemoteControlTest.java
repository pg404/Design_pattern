package design_pattern.command_6;

/**
 * Project:Exercise
 * Package:main.java.design_pattern.command_6
 * Author:Alan Ruan
 * Date:2018-09-24 00:55
 * Description://TODO
 */
public class RemoteControlTest {



    public static void main(String[] args){

        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light("here");
        GarbageDoor garbageDoor = new GarbageDoor();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        GarbageDoorOpenCommand garbageDoorOpenCommand = new GarbageDoorOpenCommand(garbageDoor);

        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();
        remoteControl.setCommand(garbageDoorOpenCommand);
        remoteControl.buttonWasPressed();

    }

}
