package sample;

public class Player {
    private int points;
    private String name;

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

    public int getPoints(){
        return points;
    }

    public void score(){
        points++;
    }

    public String getName() {
        return name;
    }
}
