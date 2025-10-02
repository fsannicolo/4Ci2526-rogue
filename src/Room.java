import java.util.ArrayList;

public abstract class Room {
    
    protected Passive passive;
    protected ArrayList<Collectible> collectList;

    public Room(Passive passive) {

        this.passive = passive;
        collectList = new ArrayList<>();
    }

    public void identify() {
        System.out.println("I'm a Room");
    }

    public Passive getPassive() {
        return passive;
    }

    public ArrayList<Collectible> getCollectList() {
        return collectList;
    }

    
}
