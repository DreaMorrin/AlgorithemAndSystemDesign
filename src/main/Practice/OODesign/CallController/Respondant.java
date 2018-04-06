package main.Practice.OODesign.CallController;

public class Respondant extends Employee {

    private Rank rank;

    public Respondant() {
        this.rank = Rank.Respondant;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
