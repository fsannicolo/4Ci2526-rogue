public class SuperBossRoom extends BossRoom {
    
    public SuperBossRoom(Passive passive) {
        super(passive);

    }

    @Override
    public void identify() {
        System.out.println("I'm a Super Boss Room");
        super.identify();
        System.out.println("End");
    }
    
}
