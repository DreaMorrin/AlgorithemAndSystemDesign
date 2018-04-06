package main.Practice.OODesign.LinuxFind;

public class Linux {
    public static void main(String[] args) {
        Linux linux = new Linux();
        Command command = new Command("find","\"leadship_principal.txt\"", "/");
        System.out.println(command);
        command.setFlag(Flag.NAME);
        Command command2 = new Command("echo", "\"This is echo!\"", "");
        Option opt = new Option(command2, Flag.PRINT);
        command.setOption(opt);
        System.out.println(command);
    }
}
