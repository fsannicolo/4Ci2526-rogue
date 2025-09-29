package rogue;

public class Active extends Item {
    private int chargeLevel;
    private final int maxCharge;

    public Active(double damageMod, double fireMod, int maxCharge) {
        super(damageMod, fireMod);
        this.maxCharge = maxCharge;
        this.chargeLevel = 0; // Inizialmente scarico
    }

    public boolean isLoaded() {
        return chargeLevel >= maxCharge;
    }

    // Metodi per caricare/scaricare l'oggetto Active potrebbero essere aggiunti qui
}
