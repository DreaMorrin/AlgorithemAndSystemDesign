package main.Practice.OODesign.Opentable;

import java.util.*;

public class Host {
    private long id;
    private PriorityQueue<Server> serverList;
    private List<Table> tableList;
    private Queue<Party> queue;

    public Host(int id) {
        this.id = id;
        serverList = new PriorityQueue<Server>(new Comparator<Server>() {
            @Override
            public int compare(Server s1, Server s2) {
                return s1.getTableList().size() - s2.getTableList().size();
            }
        });
        this.queue = new LinkedList<>();
    }

    public void newParty(Party party) {
        this.queue.offer(party);
    }

    public void assignParty() {
        if (!queue.isEmpty()) {
            Party party = queue.poll();
            tableList.forEach(table -> {
                int start = -1;
                int end = -1;
                if (table.getCapacity() == party.getNumOfPeople()) {
                    for (int i = 0; i < table.getAvaialbeTime().length; i++) {
                        if (table.getAvaialbeTime()[i][0] == party.getBookTime().getStartTime()) {
                            start = i;
                        }
                        if (table.getAvaialbeTime()[i][0] == party.getBookTime().getEndTime()) {
                            end = i;
                        }
                    }
                    if (start != -1 && end != -1) {
                        //update party time
                        table.getAvaialbeTime()[start] = new long[]{-1l, -1l};
                        table.getAvaialbeTime()[end] = new long[]{-1l, -1l};
                    }
                }
            });
        }
    }

    public void partyCheckOut(Party party) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PriorityQueue<Server> getServerList() {
        return serverList;
    }

    public void setServerList(PriorityQueue<Server> serverList) {
        this.serverList = serverList;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public Queue<Party> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Party> queue) {
        this.queue = queue;
    }
}
