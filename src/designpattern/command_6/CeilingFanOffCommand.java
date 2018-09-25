package designpattern.command_6;

public class CeilingFanOffCommand implements Command {
	CeilingFan ceilingFan;

	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		ceilingFan.off();
	}
}
