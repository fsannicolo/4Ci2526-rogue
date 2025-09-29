package rogue;

import java.util.ArrayList;

public class Player {
    private Active activeItem;
    private ArrayList<Passive> passiveItems;
    private Trinket trinket;
    private ArrayList<Collectible> collectibles;

    private int hp;
    private final int hpMax;
    private double baseDamage;
    private double finalDamage;
    private double baseFireRate;
    private double finalFireRate;

    public Player(int hpMax, double baseDamage, double baseFireRate) {
        this.hpMax = hpMax;
        this.hp = hpMax; // Inizialmente l'hp è al massimo
        this.baseDamage = baseDamage;
        this.finalDamage = baseDamage; // Inizialmente finalDamage è uguale a baseDamage
        this.baseFireRate = baseFireRate;
        this.finalFireRate = baseFireRate; // Inizialmente finalFireRate è uguale a baseFireRate

        this.passiveItems = new ArrayList<>();
        this.collectibles = new ArrayList<>();
    }


    public void updateStats() {
        // Resetta i valori finali alle basi
        finalDamage = baseDamage;
        finalFireRate = baseFireRate;

        // Applica i modificatori degli oggetti Passive
        for (Passive passive : passiveItems) {
            finalDamage += passive.damageMod;
            finalFireRate += passive.fireMod;
        }

        // Applica i modificatori dell'oggett
        o Active se è carico
        if (activeItem != null && activeItem.isLoaded()) {
            finalDamage += activeItem.damageMod;
            finalFireRate += activeItem.fireMod;
        }

        // Applica i modificatori dell'oggetto Trinket
        if (trinket != null) {
            finalDamage += trinket.damageMod;
            finalFireRate += trinket.fireMod;
        }
    }

    // Metodi getter e setter (se necessari) e altri metodi di gioco verranno aggiunti in seguito
}
