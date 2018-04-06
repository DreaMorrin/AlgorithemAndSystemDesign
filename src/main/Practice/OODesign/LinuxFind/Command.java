package main.Practice.OODesign.LinuxFind;

public class Command {

    private String operation;
    private Flag flag;
    private String variable;
    private String path;
    private Option option;
    private SubType subType;

    public Command(String operation, String variable, String path) {
        this.operation = operation;
        this.variable = variable;
        this.path = path;
    }

    public String toString() {
        return operation + " " + path + " " + (flag != null ? flag.getStr() + " " : "")
                + (subType != null ? subType.toString() + " " : "") + variable
                + " " + (option != null ? option.toString() : "");
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public SubType getSubType() {
        return subType;
    }

    public void setSubType(SubType subType) {
        this.subType = subType;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
