public class subset {
    int parent;
    int rank;
    int value;
    public subset(int parent, int rank, int value) {
        this.parent = parent;
        this.rank = rank;
        this.value = value;
    }
    public subset() {
    }
    public int getParent() {
        return parent;
    }
    public void setParent(int parent) {
        this.parent = parent;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

}
