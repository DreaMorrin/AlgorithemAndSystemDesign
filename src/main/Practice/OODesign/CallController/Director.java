package main.Practice.OODesign.CallController;

public class Director extends Employee {

    private Rank rank;

    public Director() {
        this.rank = Rank.Director;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
