package main.Practice.OODesign.Opentable;

import java.util.List;

public class Server {
    private long id;
    private List<Table> tableList;
    private String name;

    public Server(long id, List<Table> tableList, String name) {
        this.id = id;
        this.tableList = tableList;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
