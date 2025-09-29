package rogue;

public class Trinket extends Item implements Collectible {
    public Trinket(double damageMod, double fireMod) {
        super(damageMod, fireMod);
    }

    @Override
    public boolean canDropped() {
        return true;
    }
}
