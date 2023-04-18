package MySQLConnection;
public class Game {

    private String name;
    private int year;

    public Game(String name, int year) {
        this.setname(name);
        this.setyear(year);
    }

    public String getname() {
        return name;
    }

    public int getyear() {
        return year;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setyear(int year) {
        this.year = year;
    }

}
