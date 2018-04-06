package main.Practice.OODesign.LinuxFind;

public class Option {
    private static final String pipe = "| xarg ";
    private Command command;
    private Flag flag;

    public Option(Command command, Flag flag) {
        this.command = command;
        this.flag = flag;
    }

    public String toString() {
        return flag.getStr() + " " + pipe + command.toString();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
