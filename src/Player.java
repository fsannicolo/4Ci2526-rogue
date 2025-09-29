import java.util.ArrayList;

public class Player {
    
    private int hp;
    private final int HP_MAX;

    private double damage, fireRate, finalDamage, finalFireRate;

    private Active active;
    private Trinket trinket;
    private ArrayList<Passive> passiveList;
    private ArrayList<Collectible> collectList;

    public Player(int hp, double damage, double fireRate) {
        this.hp = this.HP_MAX = hp;
        this.damage = damage;
        this.fireRate = fireRate;
        passiveList = new ArrayList<>();
        collectList = new ArrayList<>();
    }

    public double getFinalDamage() {
        return finalDamage;
    }

    public double getFinalFireRate() {
        return finalFireRate;
    }


}
