package main.Practice.OODesign.LinuxFind;

public enum Flag {
    PERM("-perm"),
    NAME("-name"),
    MTIME("-mtime"),
    NEWER("-newer"),
    PRINT("-print"),
    EXEC("-exec"),
    OK("-ok"),
    TYPE("-type"),
    SIZE("-size");

    private final String str;

    private Flag(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
