package rogue;

public abstract class Item {
    protected double damageMod;
    protected double fireMod;

    public Item(double damageMod, double fireMod) {
        this.damageMod = damageMod;
        this.fireMod = fireMod;
    }
}
