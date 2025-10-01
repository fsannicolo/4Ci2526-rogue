import java.util.ArrayList;

public class Player {
    
    private int hp;
    private final int HP_MAX;

    private double baseDamage, baseFireRate, finalDamage, finalFireRate;

    private Active active;
    private Trinket trinket;
    private ArrayList<Passive> passiveList;
    private ArrayList<Collectible> collectList;

    public Player(int hp, double damage, double fireRate) {
        this.hp = this.HP_MAX = hp;
        this.baseDamage = damage;
        this.baseFireRate = fireRate;
        passiveList = new ArrayList<>();
        collectList = new ArrayList<>();
    }

    /**
     * Aggiunge un oggetto all'inventario in base alla sua istanza
     * @param nuovo nuovo oggetto da aggiungere
     */
    public void addItem(Item nuovo) {

        if (nuovo instanceof Active) { 
            this.active = (Active)nuovo;
        }

        else if (nuovo instanceof Passive passive) {
            passiveList.add(passive);
        }

        else {
            this.trinket = (Trinket)nuovo;
        }
    }

    /**
     * Cancella il riferimento al trinket in inventario
     * @return il trinket precedente rimosso
     */
    public Trinket dropTrinket() {

        if (this.trinket == null) return null;

        Trinket temp = this.trinket;
        this.trinket = null;
        return temp;
    }

    /**
     * Controlla se nell'inventario sono presenti Trinket, e li rimuove
     * @return vero se ne sono stati rilevati
     */
    public boolean checkCollectibles() {

        boolean trovati = false;

        for (int i=collectList.size()-1; i>=0; i--) {

            Collectible c = collectList.get(i);
            if (c instanceof Trinket) {
                collectList.remove(i);
                trovati = true;
            }
        } 

        //collectList.removeIf(t -> t instanceof Trinket);

        return trovati;
    }

    /**
     * Aggiorna i valori finali di damage e fireRate in base agli oggetti nell'inventario
     */
    public void updateStats() {

        finalDamage = baseDamage;
        finalFireRate = baseFireRate;

        for (Passive p : passiveList) {
            finalDamage *= p.getDamageMod();
            finalFireRate *= p.getFireMod();
        }

        if (active != null && active.isLoaded()) {
            finalDamage *= active.getDamageMod();
            finalFireRate *= active.getFireMod();
        }

        if (trinket != null) {
            finalDamage *= trinket.getDamageMod();
            finalFireRate *= trinket.getFireMod();
        }
    }

    /**
     * Ripristina la carica massima dell'oggetto Active consumando una Battery nell'inventario, a patto che ci sia, rimuovendola
     * @return false se non è stato possibile ricaricare
     */
    public boolean recharge() {

        // cerco una batteria e la rimuovo
        for (int i=collectList.size()-1; i>=0; i--) {

            Collectible c = collectList.get(i);
            if (c instanceof Battery) {
                collectList.remove(c);

                this.active.reload();
                return true;
            }
        }

        return false;
    }

    /**
     * Ripristina tanti hp del giocatore quanti sono gli Heart presenti nella lista dei collezionabili, 
     * a patto che ce ne siano, ma senza mai eccedere gli hpMax. 
     * Ad ogni Heart consumato esso andrà rimosso dalla lista.
     * @return false se non è stato possibile curare il giocatore
     */
    public boolean heal() {

        boolean healed = false;
        int delta = HP_MAX - hp;

        if (hp <= 0 || delta == 0) return false;

        int i = collectList.size() - 1;
        while (delta > 0 && i >= 0) {

            Collectible c = collectList.get(i);
            if (c instanceof Heart) {
                
                // aggiorno i punti vita ad ogni cuore rimosso
                collectList.remove(c);
                hp++;
                delta--;
                healed = true;

                i--;
            }
        }

        return healed;
    }

    public double getFinalDamage() {
        return finalDamage;
    }

    public double getFinalFireRate() {
        return finalFireRate;
    }

    public void viewStats() {

        System.out.printf("HP: %d, danno corrente: %.2f, fire rate: %.2f \n", hp, finalDamage, finalFireRate);
    }
}
