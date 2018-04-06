package main.Practice.OODesign.CallController;

public class Manager extends Employee {

    private Rank rank;

    public Manager() {
        this.rank = Rank.Manager;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
